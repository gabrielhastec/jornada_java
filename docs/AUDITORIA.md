# Auditoria do conteúdo existente

**Data:** 06/08/2026 · **Escopo:** 31 aulas de `01-fundamentos/` + 9 katas de `02-katas/`

Você suspeitava que havia "aula errada". Havia — e mais do que o esperado. Este documento é o **ponto de partida da nova trilha**: cada achado vira exercício de revisão, com semana marcada.

## Como a auditoria foi feita

Do jeito que se faz num time de verdade, e que você vai repetir sozinho na Fase R:

1. **Compilar tudo**, pasta por pasta, com avisos ligados: `javac -Xlint:all`
2. **Varrer padrões** com `grep` em todo o repositório (dinheiro em `double`, comparação de objeto com `==`, domínio imprimindo no console, `catch` vazio, recurso não fechado)
3. **Ler o código** das aulas sinalizadas e comparar com o que o README daquela aula ensina

## Resultado em números

| Métrica | Resultado |
|---|---|
| Pastas que **não compilam** | **20 de 40** (17 aulas + 3 katas) |
| Arquivos com nome ≠ nome da classe | 22 |
| Pastas com dinheiro em `double`/`float` | 15 |
| Arquivos com domínio imprimindo no console | 11 |
| Comparação de objeto com `==` | 2 pontos |
| `catch` vazio ou recurso não fechado | 0 (esse você acertou) |

---

## Achado 1 — 20 pastas não compilam: nome do arquivo ≠ nome da classe

**Gravidade: alta.** É o que impede metade do repositório de rodar.

```
01-fundamentos/03-variaveis/src/variaveisJava.java:2: error:
    class VariaveisJava is public, should be declared in a file named VariaveisJava.java
```

**Por que aconteceu (e essa é a lição real):** no commit `7ff245f — Padronização do nome das classes para a convenção Java` você renomeou as **classes** de `variaveisJava` para `VariaveisJava`, mas os **arquivos** continuaram com o nome antigo. E o Windows não avisou, porque o sistema de arquivos dele é *case-insensitive*: para o Windows, `variaveisJava.java` e `VariaveisJava.java` são **o mesmo arquivo**. Um `git mv variaveisJava.java VariaveisJava.java` nessa situação não faz nada.

Em Java, isso é regra da linguagem: **toda classe `public` tem que estar em um arquivo com exatamente o mesmo nome**. Sem isso, não compila.

**Como se corrige no Windows** (renomear em dois passos, porque o direto é ignorado):

```bash
git mv variaveisJava.java temp.java && git mv temp.java VariaveisJava.java
```

**Onde acontece:**

| Trilha | Pastas afetadas |
|---|---|
| Fundamentos | 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13, 14, 15, 16, 17, 18 |
| Katas | 01, 02, 03 |

> **Uso no dia a dia:** essa mesma armadilha aparece em qualquer projeto com dev no Windows e build no Linux. O código roda na máquina de todo mundo e **quebra no servidor**, porque o Linux diferencia maiúscula de minúscula. É uma das causas mais comuns de "funciona na minha máquina" — e agora você já viveu ela.

---

## Achado 2 — Aula 18: o método `main` está com `M` maiúsculo

**Gravidade: alta.** `01-fundamentos/18-encapsulamento-e-modificadores/src/application/main.java`

```java
public class Main {
    public static void Main(String[] args) {   // <- M maiusculo
```

Mesmo corrigindo o nome do arquivo, este programa **não roda**: a JVM procura por `main` (minúsculo) e devolve `Main method not found in class application.Main`. O compilador não reclama, porque `Main(String[])` é um método estático perfeitamente válido — só não é o ponto de entrada.

> **Uso no dia a dia:** é o primeiro contato com a diferença entre **erro de compilação** (o compilador te avisa) e **erro de execução** (só aparece quando roda). Boa parte do trabalho de backend é lidar com a segunda categoria.

---

## Achado 3 — Dinheiro representado em `double` (15 pastas)

**Gravidade: alta em sistema real, média para estudo.**

`double preco`, `double saldo`, `double salario`, `double limite` aparecem em 15 pastas. `double` é ponto flutuante binário e **não consegue representar decimais exatos**:

```java
System.out.println(0.1 + 0.2);        // 0.30000000000000004
System.out.println(1.03 - 0.42);      // 0.6100000000000001
```

Multiplique isso por milhares de transações e você tem o clássico "o fechamento do mês não bate por R$ 0,03" — que ninguém consegue explicar e que dá noite em claro em time de pagamentos.

**O certo:** `BigDecimal` (ou representar centavos em `long`).

**Onde acontece:** aulas 04, 08, 13, 17, 18, 19, 21, 28, 29, 30, 31 · katas 02, 04, 05, 09

> **Uso no dia a dia:** em qualquer sistema financeiro, e-commerce ou folha de pagamento, valor monetário em `double` é reprovado em code review na hora. É também pergunta clássica de entrevista.

---

## Achado 4 — Comparação de objeto com `==` (2 pontos)

**Gravidade: alta.** `02-katas/09-conta-bancaria/`

```java
service/BancoService.java:19   .filter(c -> c.getId() == id)
utils/Menu.java:107            if (c.getId() == id) {
```

`==` em objetos compara **endereço de memória**, não conteúdo. Funciona no teste (literais compartilham o mesmo objeto no *string pool*) e falha com o usuário real (texto vindo do `Scanner` é objeto novo).

Este é o alvo da [Aula 01 do novo método](trilha/fase-0/aula-01-caca-ao-bug.md) — a auditoria encontrou um **segundo** ponto que não estava mapeado antes, no `Menu`.

---

## Achado 5 — Domínio imprimindo no console (11 arquivos)

**Gravidade: média (conceitual, e é a raiz da sua dificuldade com POO).**

Entidades e serviços chamando `System.out.println` diretamente:

```
01-fundamentos: 17/entities, 18/entities, 19/entities, 20/entities,
                21/entities (2 arquivos), 23/entities (2 arquivos), 31/service
02-katas:       04/service, 05/service
```

**Por que isso é problema:** a classe `Produto` passa a depender do console. No dia em que esse mesmo `Produto` for usado numa API REST (Fase WEB da trilha), ele vai imprimir no log do servidor em vez de responder ao cliente — e a regra de negócio fica presa a uma tecnologia de tela.

**A regra:** o domínio **decide e devolve**; quem **mostra** é a camada de interface (`ui`, `Menu`, `Controller`). Suas aulas 30 e 31 já fazem isso certo, com `ui/ProdutoConsoleUI` — ou seja, **você já sabe**: só não aplicou de forma consistente.

---

## Achado 6 — Aula 18 ensina o oposto de encapsulamento

**Gravidade: alta (conceitual).** É a aula mais importante para o seu problema declarado com POO — e é justamente a que está errada.

```java
public void setPreco(double preco) {
    if (preco >= 0) {
        this.preco = preco;
    } else {
        System.out.println("Preço inválido. Atribuído 0.0");
        this.preco = 0.0;        // <- "corrige" sozinho e segue em frente
    }
}
```

E no `main`, o comentário diz `// será rejeitado` — mas **não é rejeitado**: o preço vira `0.0` e o programa continua como se nada tivesse acontecido. Um produto que custava R$ 2.500 passa a custar zero e ninguém fica sabendo.

Três problemas de uma vez:
1. **Corrompe dado silenciosamente** — o pior tipo de bug, porque não aparece em log nem em tela
2. **O comentário mente sobre o comportamento** — documentação divergindo do código
3. **A entidade imprime na tela** — mistura domínio com interface (Achado 5)

**O que encapsular realmente significa:** o objeto **se recusa** a entrar em estado inválido — lançando exceção — em vez de aceitar e maquiar.

> **Uso no dia a dia:** essa é a diferença entre um sistema que dá erro claro ("preço não pode ser negativo") e um sistema que grava lixo no banco e só é descoberto três meses depois, quando o relatório não fecha.

---

## Achado 7 — Aula 21: herança com estado exposto e falha silenciosa

**Gravidade: média (conceitual).**

```java
public class Conta {
    protected String titular;      // <- subclasse mexe direto no estado
    protected double saldo;

    public void sacar(double valor) {
        if (valor <= saldo) { saldo -= valor; }
        else { System.out.println("Saldo insuficiente."); }   // <- quem chamou nao fica sabendo
    }
}
```

1. **`protected` em atributo** é encapsulamento furado: toda subclasse (existente ou futura) pode alterar `saldo` sem passar por nenhuma regra
2. **Falha silenciosa:** `sacar` imprime e retorna normalmente. Quem chamou não tem como saber se deu certo — o método deveria lançar exceção
3. **Discussão que a aula não faz:** `ContaEspecial.sacar` permite saldo negativo até o limite, ou seja, **muda a regra da superclasse**. Isso é aceitável? Essa é a pergunta que separa quem decora herança de quem entende (princípio de substituição de Liskov) — e vai ser respondida na Fase POO

---

## Achado 8 — Kata 06: `Calculadora extends DivisaoPorZeroException`

**Gravidade: alta (conceitual).**

```java
public class Calculadora extends DivisaoPorZeroException {
```

Uma calculadora **não é** uma exceção. Herança usada como atalho para "conseguir usar" o tipo. Teste da frase: *"Calculadora é uma DivisaoPorZeroException"* — não faz sentido em português, logo não faz sentido em Java. Efeito colateral visível: o compilador avisa `serializable class Calculadora has no definition of serialVersionUID`, porque a classe virou uma exceção sem querer.

---

## Achado 9 — Kata 09: exceções empacotadas em `utils`

**Gravidade: média.** Três exceções de negócio como classes aninhadas dentro de `utils/Exceptions.java`, forçando `import utils.Exceptions.*`. Detalhado na [Aula 01](trilha/fase-0/aula-01-caca-ao-bug.md).

Compare com o **kata 08**, que fez certo: pacote `exceptions/`, uma classe por arquivo. Você acertou no 08 e regrediu no 09 — sinal de que a regra ainda não estava consolidada.

---

## Achado 10 — `serialVersionUID` ausente (10 avisos)

**Gravidade: baixa.** Toda classe que herda de `Exception` é serializável e o compilador pede um identificador de versão. Não quebra nada em aplicação de console; some quando você adicionar o campo ou quando usar `@Serial`. Fica registrado para você **saber o que o aviso significa** em vez de ignorá-lo — ignorar aviso de compilador é hábito ruim que se paga caro depois.

---

## Situação aula a aula

| # | Aula | Compila | Achados |
|---|---|---|---|
| 01 | introducao | ✅ | — |
| 02–16 | operadores → strings | ❌ | Achado 1 (nome de arquivo) · 04, 08 e 13 também com Achado 3 |
| 17 | classes-e-objetos | ❌ | Achados 1, 3, 5 |
| 18 | encapsulamento | ❌ | Achados 1, 2, 3, 5, **6** |
| 19 | construtores | ✅ | Achados 3, 5 |
| 20 | objetos | ✅ | Achado 5 |
| 21 | heranca | ✅ | Achados 3, 5, **7** |
| 22 | polimorfismo | ✅ | classe abstrata `Forma` no pacote `utils` (organização) |
| 23 | interfaces | ✅ | Achado 5 |
| 24–27 | arrays → generics | ✅ | — |
| 28 | excecoes | ✅ | Achados 3, 10 · repositório lançando exceção de negócio |
| 29 | enums | ✅ | Achados 3, 10 |
| 30 | tipos-primitivos | ✅ | Achado 3 · **estrutura em camadas correta** |
| 31 | operadores-incremento | ✅ | Achados 3, 5 · **estrutura em camadas correta** |

| # | Kata | Compila | Achados |
|---|---|---|---|
| 01–03 | operações, salário, venda | ❌ | Achado 1 · 02 também com Achado 3 |
| 04 | folha-de-pagamento | ✅ | Achados 3, 5 |
| 05 | analise-de-credito | ✅ | Achados 3, 5 · **melhor kata do repositório** |
| 06 | calculadora | ✅ | Achados **8**, 10 |
| 07 | caixa-eletronico | ✅ | Achado 10 |
| 08 | registro-escolar | ✅ | Achado 10 · **exceções organizadas corretamente** |
| 09 | conta-bancaria | ✅ | Achados 3, **4**, 9, 10 |

---

## O que essa auditoria diz sobre o seu nível

Duas conclusões que valem mais que a lista de erros:

**1. Os erros não são de lógica — são de disciplina e de modelagem.** Nenhum `catch` vazio, nenhum recurso vazando, nenhum algoritmo errado. O que falha é: convenção da linguagem (Achado 1), fronteira entre camadas (Achado 5) e proteção de estado (Achados 6, 7). Isso é exatamente o degrau entre "escrevo código que funciona" e "escrevo código que outra pessoa mantém" — e é o degrau que separa júnior de pleno.

**2. Você já demonstrou saber o certo em vários pontos.** Camadas corretas nas aulas 30 e 31, Strategy no kata 05, exceções organizadas no kata 08. O problema não é desconhecimento: é que **o conhecimento chegou depois** e o conteúdo antigo nunca foi revisitado. É por isso que a nova trilha começa por revisão.

## Plano de correção

Cada achado tem semana marcada na [trilha](TRILHA.md), na Fase R. Nenhuma correção é feita por mim: eu explico o conceito e reviso; a correção é sua — é ela que fixa o aprendizado.
