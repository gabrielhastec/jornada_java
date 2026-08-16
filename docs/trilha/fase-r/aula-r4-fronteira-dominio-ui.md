# Aula R4 — Onde o domínio termina e a tela começa

**Fase R · Semana 4 · ~2h**

**Pré-requisitos (o que você já viu e vai usar aqui):**
- Aulas 18 a 21 — classe, atributo, método, construtor, composição
- Aula 24 — o que é uma interface (citada no final, sem exigir domínio)
- Aula 31 — **você já fez isso certo**: `domain`, `repository`, `service`, `ui`

**Conceito novo desta aula:** separação de responsabilidades entre camadas, na prática.

---

## Bloco 1 — O problema

> A loja vai ganhar um site. A regra "não vender mais do que tem em estoque" já existe, testada e funcionando há meses no sistema de console. O time decide reaproveitar a classe `Produto` na nova API.
>
> Na primeira venda pelo site, o cliente compra 5 unidades de um item com 2 em estoque. A API responde **200 OK**, sem erro nenhum. A venda entra. O estoque fica negativo.
>
> Um dev vai olhar o log do servidor e encontra, entre milhares de linhas:
>
> ```
> Quantidade inválida. Atribuído 0
> ```
>
> A regra funcionou. Ela **avisou**. Só que avisou no lugar onde só o servidor vê — e ninguém contou para o cliente, nem para a API.

Esse cenário é literal: é o comportamento do seu `Produto` da aula 19, e o mesmo padrão está em **11 arquivos** do repositório ([auditoria](../../AUDITORIA.md), Achado 5).

---

## Bloco 2 — O conceito

### 2.1 Duas responsabilidades diferentes

Toda operação de um sistema tem duas partes que **parecem** uma só quando o programa é de console:

| Responsabilidade | Pergunta que responde | Onde mora |
|---|---|---|
| **Decidir** | A venda pode acontecer? Qual o total? O estoque dá? | domínio (`domain`, `entities`) e regra (`service`) |
| **Mostrar** | Como isso aparece para quem está do outro lado? | interface (`ui`, `Menu`, e depois `Controller` na web) |

Quando `Produto` chama `System.out.println`, ele está fazendo as duas — e aí ele fica **preso ao console**. O dia em que a mesma classe precisar servir uma API, um relatório em PDF, um app de celular ou um teste automatizado, ela não serve: ela só sabe falar com terminal.

### 2.2 A regra prática

> **O domínio decide e devolve. Quem mostra é a interface.**

"Devolve" pode ser de três formas — e escolher entre elas é uma decisão de projeto que você vai tomar muitas vezes:

**a) Devolvendo um valor**

```java
// em vez de imprimir o total, retorne o total
public BigDecimal calcularTotal() {
    return preco.multiply(new BigDecimal(quantidade));
}
```

**b) Devolvendo o próprio estado, para quem quiser formatar**

```java
// toString() é a forma padrão de Java para "me descreva em texto"
@Override
public String toString() {
    return nome + " | R$ " + preco + " | " + quantidade + " un.";
}
```

`toString()` é chamado automaticamente quando você concatena o objeto com texto ou faz `System.out.println(produto)`. Note a diferença: a classe **oferece** o texto; ela não decide **para onde** esse texto vai.

**c) Lançando exceção quando a operação não pode acontecer**

```java
public void baixarEstoque(int quantidade) {
    if (quantidade > this.quantidade) {
        throw new EstoqueInsuficienteException(nome, this.quantidade, quantidade);
    }
    this.quantidade -= quantidade;
}
```

Aqui está a diferença crucial em relação ao seu código atual: quem chamou **não tem como ignorar**. Com `System.out.println`, o método falha e retorna normalmente — o programa segue como se tivesse dado certo. Com exceção, o fluxo para e a camada de cima decide o que fazer: no console, mostrar mensagem; na API, devolver HTTP 409; num processamento em lote, registrar na lista de falhas e seguir para o próximo.

**A mesma regra, três respostas diferentes, porque quem decide como comunicar é quem conhece o usuário — e o domínio não conhece.**

### 2.3 A direção da dependência

```
   ui  ────────►  service  ────────►  domain
(console,        (regras que          (Produto, Venda,
 menu, API)      coordenam)            Cliente)

A seta significa "conhece / usa".
Ninguém aponta para trás: domain NÃO conhece ui.
```

Teste rápido para saber se você acertou: **procure `import` de coisas de tela dentro do domínio**. Se `Produto.java` importa `Scanner`, ou chama `System.out`, a seta inverteu.

E você já sabe fazer isso: na aula 31, `ProdutoConsoleUI` mostra e `ProdutoService` decide. **Não é conhecimento novo — é aplicar de forma consistente o que você já acertou uma vez.**

---

## Bloco 3 — Onde isso aparece na sua vida de desenvolvedor

| Situação | O que muda |
|---|---|
| **API REST (Fase WEB)** | A mesma classe de domínio serve o controller. Se ela imprimir no console, a mensagem vai para o log do servidor e o cliente recebe sucesso — o bug do Bloco 1 |
| **Testes automatizados** | Você consegue testar a regra sem simular teclado nem capturar saída de console. Regra que imprime é regra difícil de testar — e regra difícil de testar quase sempre está mal posicionada |
| **Trocar a interface** | Console hoje, web amanhã, app depois. Se o domínio estiver limpo, a troca mexe só na camada de cima |
| **Code review** | "Por que essa entidade está imprimindo?" é dos comentários mais comuns em PR de júnior |
| **Log estruturado (Fase PRO)** | Em produção não se usa `System.out`: usa-se logger com nível, timestamp e correlation id. Mas mesmo o logger fica no serviço, não na entidade |

> **A conexão com a sua dificuldade em POO:** você disse que sabe criar entidade, service e interface, mas não sabe **quando** usar. A resposta começa aqui: cada camada existe porque tem uma responsabilidade diferente. Encapsulamento, herança e interface só fazem sentido depois que essa fronteira está clara — sem ela, POO vira "criar classes porque o curso mandou".

---

## Bloco 4 — Implementação guiada

Exemplo em **outro domínio** (reserva de hotel), no formato antes/depois:

**Antes — a entidade mistura decisão com apresentação:**

```java
public class Reserva {
    private int hospedes;
    private int capacidadeQuarto;

    public void confirmar(int hospedes) {
        if (hospedes > capacidadeQuarto) {
            System.out.println("Quarto comporta no maximo " + capacidadeQuarto + " hospedes.");
            this.hospedes = capacidadeQuarto;      // "corrige" sozinho
        } else {
            this.hospedes = hospedes;
            System.out.println("Reserva confirmada!");
        }
    }
}
```

Problemas: quem chamou não sabe se confirmou; o dado foi alterado silenciosamente; a classe só funciona com console.

**Depois — a entidade decide, a interface mostra:**

```java
// domain/Reserva.java  — nao conhece tela nenhuma
public class Reserva {
    private int hospedes;
    private final int capacidadeQuarto;

    public void confirmar(int hospedes) {
        if (hospedes > capacidadeQuarto) {
            throw new CapacidadeExcedidaException(capacidadeQuarto, hospedes);
        }
        this.hospedes = hospedes;
    }
}
```

```java
// ui/ReservaConsoleUI.java  — so mostra
public class ReservaConsoleUI {
    public void confirmar(Reserva reserva, int hospedes) {
        try {
            reserva.confirmar(hospedes);
            System.out.println("Reserva confirmada!");
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Nao foi possivel: " + e.getMessage());
        }
    }
}
```

Amanhã, numa API, a mesma `Reserva` é usada por um controller que transforma a exceção em HTTP 409 — **sem alterar uma linha do domínio**.

---

## Bloco 5 — A prova

O teste que responde se você separou de verdade:

> **Consigo usar essa classe num programa que não tem console?**

Escreva um `main` temporário que usa `Produto` (da aula 19, já convertido para `BigDecimal` na R3) e que **não imprime nada** — só cria o produto, executa as operações e guarda os resultados em variáveis. Se para saber o que aconteceu você **precisa** olhar o que a classe imprimiu, a separação ainda não está feita.

Anote no [`PROGRESSO.md`](../../PROGRESSO.md) se conseguiu de primeira.

---

## Bloco 6 — Sua vez

**Tarefa 1 — Aula 19 (`Produto`).** Tire o `System.out` de dentro da entidade.
- `setPreco` e `setQuantidade` devem **recusar** valor inválido (lançar `IllegalArgumentException`), em vez de trocar por zero
- Adicione `toString()` descrevendo o produto
- O `Main` passa a mostrar as informações e a tratar o erro
- Critério final: `grep -n "System.out" entities/Produto.java` não retorna nada

**Tarefa 2 — Aula 22 (`Conta` e `ContaEspecial`).**
- `sacar` deixa de imprimir "Saldo insuficiente" e passa a sinalizar a falha para quem chamou
- `exibirSaldo()` sai da entidade; quem mostra é o `Main`
- Pergunta para responder no README da aula: *com a mudança, `ContaEspecial` ainda consegue permitir saldo negativo até o limite? Isso é desejável?* (essa pergunta volta na aula P3)

**Tarefa 3 — Kata 04 (`FolhaService`) ou kata 05 (`RelatorioService`), escolha um.**
- O serviço passa a **devolver** o resultado (texto ou objeto) em vez de imprimir
- Quem imprime é o `Menu`/`Main`

> **Deixe as aulas 20, 21 e 24 como estão.** Elas são demonstrações didáticas curtas, e o custo de mexer não se paga. Anote no README de cada uma: *"exibe direto na entidade por ser demonstração; o padrão correto está na aula 31"*. Reconhecer exceção consciente à regra é diferente de não conhecer a regra.

---

## Bloco 7 — Registro

No [`PROGRESSO.md`](../../PROGRESSO.md):
- o resultado do teste do Bloco 5
- a resposta da pergunta da Tarefa 2
- uma frase sua respondendo: *o que muda no meu código quando eu penso "quem decide" e "quem mostra" separadamente?*

**Teste do "explique de volta":** explique por que uma classe de domínio que imprime no console é difícil de testar. Se conseguir, você entendeu a aula — e adiantou metade da aula P10 (testes).

---

## Material de apoio

- *Clean Code* (Robert Martin), cap. 3 — funções que fazem uma coisa só
- [Martin Fowler — Tell Don't Ask](https://martinfowler.com/bliki/TellDontAsk.html)
- [Baeldung — `toString()` em Java](https://www.baeldung.com/java-tostring)
- Sua própria aula 31 (`ui/ProdutoConsoleUI` + `service/ProdutoService`) — o exemplo certo já está no seu repositório

## Próxima aula

**R5 — O sistema nasce:** juntar o que foi corrigido nas aulas R1 a R4 e levar o domínio para o [`01-loja`](../../../03-projetos/01-loja/), que já entrega `POST /produtos` e `GET /produtos` por HTTP. A partir dali, toda aula acrescenta uma funcionalidade nesse sistema. A regra que você acabou de aprender vira a fronteira mais importante do projeto: o `controller` mostra, o `domain` decide — e o domínio não importa `org.springframework`.
