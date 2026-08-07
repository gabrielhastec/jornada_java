# Aula 01 — Caça ao bug: investigar como profissional

**Fase 0 · Semana 2 · ~2h**
**Pré-requisito:** repositório reorganizado (Semana 1)
**Código-alvo:** [`02-katas/09-conta-bancaria`](../../../02-katas/09-conta-bancaria/) — seu próprio código

> Esta é a primeira aula do novo método. Ela não ensina um recurso novo da linguagem: ensina a **habilidade que a prova técnica realmente mede**. Em processo seletivo de backend, raramente pedem "escreva uma classe do zero". Pedem: aqui está um código que alguém escreveu, ele está com um comportamento errado, ache e conserte — explicando o raciocínio.

---

## Bloco 1 — O problema

> Segunda-feira, 8h. O suporte abre um chamado: *"Cliente reclama que transferiu R$ 500 e o dinheiro não chegou na conta de destino. Ele diz que o sistema mostrou 'Cliente não encontrado', mas o CPF está certo — a gente conferiu no cadastro."*
>
> Você abre o sistema, cadastra dois clientes de teste, transfere entre eles: **funciona**. Fecha o chamado como "não reproduzido".
>
> Dois dias depois, mais quatro chamados iguais.

Esse é o bug mais perigoso que existe: **o que funciona no seu teste e falha no uso real**. Ele não gera stack trace nem alerta. Ele só gera cliente irritado.

O seu `09-conta-bancaria` tem exatamente esse bug, agora, e mais dois problemas estruturais que causariam incidentes parecidos num sistema de verdade.

---

## Bloco 2 — Os conceitos por trás dos três achados

### 2.1 Identidade × referência: `==` não é `equals`

Em Java, uma variável de objeto guarda **o endereço** do objeto, não o objeto. Então:

- `==` pergunta: *"são o mesmo objeto, na mesma posição de memória?"*
- `.equals()` pergunta: *"têm o mesmo conteúdo?"*

Com `String`, isso vira uma armadilha específica, porque o Java tem o *string pool*: literais iguais escritos no código-fonte apontam para o **mesmo** objeto.

Exemplo em outro domínio — validação de login:

```java
String emailCadastrado = "ana@empresa.com";
String emailDigitado   = "ana@empresa.com";
System.out.println(emailCadastrado == emailDigitado);       // true  <- literal: mesmo objeto do pool

String emailDoBanco = new String("ana@empresa.com");
System.out.println(emailCadastrado == emailDoBanco);        // false <- outro objeto, mesmo conteúdo
System.out.println(emailCadastrado.equals(emailDoBanco));   // true  <- a pergunta certa
```

**Por que isso engana:** enquanto você testa com literais escritos no código, `==` funciona. Quando o valor vem de `Scanner`, de um `ResultSet` do banco, de um JSON da API ou de concatenação, ele passa a ser um objeto novo — e `==` vira `false` para sempre. O bug só aparece com usuário real.

**A regra:** `==` só para primitivos (`int`, `double`, `boolean`) e para checar `null`. Para qualquer objeto, `.equals()`. E como o valor pode ser nulo, prefira a ordem segura: `"valor".equals(variavel)` ou `Objects.equals(a, b)`.

### 2.2 Exceção é contrato, não utilitário

Erro de negócio ("cliente não encontrado", "saldo insuficiente") é parte da **API do seu domínio**: é o vocabulário com que uma camada avisa a outra que algo previsto deu errado. Isso muda três coisas na organização:

- **Onde mora:** num pacote `exceptions` (ou junto do domínio que ele descreve), nunca dentro de `utils`. `utils` é o pacote-lixeira: quando tudo cabe lá, ninguém acha nada.
- **Uma por arquivo:** `ClienteNaoEncontradoException.java`, não três classes aninhadas dentro de uma classe `Exceptions`. Classes aninhadas obrigam `import utils.Exceptions.*` com wildcard — e wildcard esconde de onde o tipo veio.
- **Checked × unchecked, com critério:** `extends Exception` (checked) obriga **toda** a cadeia de chamadas a declarar `throws`. Repare no seu `transferir`: a assinatura tem três `throws` e ocupa sete linhas. Isso é o compilador te avisando que a escolha foi cara. A prática dominante hoje (e o padrão do Spring) é: **erro de regra de negócio → unchecked** (`extends RuntimeException`), tratado em um ponto só, na borda da aplicação.

**Onde isso aparece no mundo real:** numa API REST, essa hierarquia é o que permite escrever um único `@RestControllerAdvice` que traduz `ClienteNaoEncontradoException` → HTTP 404 e `SaldoInsuficienteException` → HTTP 409, sem um `try/catch` sequer no controller. Se as exceções estão empilhadas dentro de uma classe utilitária, esse mapeamento fica confuso — e é justamente ele que você vai escrever na Fase 2.

### 2.3 Invariante: a regra tem que morar dentro do objeto

**Invariante** é uma regra que precisa valer **sempre**, não importa qual código executou: *"saldo de conta corrente nunca fica negativo"*.

Hoje, no seu código, quem protege o saldo é o `BancoService`. Só que `Cliente` tem `setSaldo(double)` público. Ou seja: qualquer classe, em qualquer lugar, hoje ou daqui a seis meses, pode fazer `cliente.setSaldo(-9999)` e o objeto aceita numa boa. A regra existe num lugar; a permissão de violá-la existe em todos os outros.

Isso tem nome de princípio: ***Tell, Don't Ask*** — não pergunte o estado do objeto para decidir por ele; **mande** o objeto fazer a operação e deixe que ele proteja o próprio estado.

Exemplo em outro domínio — carrinho de compras:

```java
// Ask (regra vaza para fora, e cada chamador precisa lembrar dela)
if (carrinho.getItens().size() < 50) {
    carrinho.getItens().add(item);
}

// Tell (a regra mora onde o estado mora; é impossível burlar por fora)
carrinho.adicionar(item);   // lança CarrinhoCheioException se passar do limite
```

**Como reconhecer o cheiro:** quando um serviço faz `objeto.setX(objeto.getX() ± algo)`, a lógica está do lado errado da fronteira.

> **Bônus — o quarto bug, que ainda não te mordeu:** `double saldo`. `double` é ponto flutuante binário e não representa decimal exato: `0.1 + 0.2` dá `0.30000000000000004`. Em dinheiro isso vira centavo de diferença que ninguém consegue explicar no fechamento do mês. Dinheiro se representa com `BigDecimal` (ou inteiro em centavos). Guarde para a Semana 3.

---

## Bloco 3 — Onde isso aparece no sistema real

| Achado | Como aparece em produção | Quem paga a conta |
|---|---|---|
| `==` em vez de `equals` | Busca por CPF/e-mail/código não encontra registro que existe no banco | Suporte, que não consegue reproduzir |
| Exceções mal organizadas | API devolve 500 para erro previsto do usuário; alerta do plantão dispara de madrugada à toa | Quem está de sobreaviso |
| Invariante fora do objeto | Saldo negativo, estoque negativo, pedido confirmado sem item — sem ninguém saber qual código fez | O time inteiro, no post-mortem |

---

## Bloco 4 — Como um profissional investiga (o roteiro)

Não saia lendo o código à procura de "o que está estranho". Siga o método — é ele que te salva na prova técnica quando o código é de outra pessoa e tem 3.000 linhas:

1. **Reproduza.** Bug que você não consegue reproduzir, você não consegue consertar. Encontre a entrada exata que quebra.
2. **Reduza.** Corte o caminho até o menor programa que ainda mostra o erro. Aqui, um `main` de 10 linhas basta.
3. **Formule uma hipótese, escrita.** "Acho que a comparação falha porque as duas Strings são objetos diferentes." Hipótese vaga ("acho que tem algo errado na busca") não é hipótese.
4. **Teste a hipótese** com o mínimo de mudança: um `System.out.println`, um breakpoint, um `assert`. Se a hipótese cair, volte ao passo 3 — sem se apegar.
5. **Corrija a causa, não o sintoma.** Sintoma: "vou cadastrar o cliente de novo". Causa: "a comparação está errada".
6. **Prove que consertou** — e prove que o bug não volta (é para isso que serve teste automatizado, que entra na Semana 8).

Na entrevista, **verbalize esses passos enquanto codifica**. O entrevistador está avaliando o processo mais do que a linha final.

---

## Bloco 5 — A prova (faça antes de corrigir)

Crie um arquivo temporário `ReproducaoDoBug.java` (fora de `src`, para não versionar) e escreva um `main` que:

1. Cria um `Cliente` com id `"12345678900"` **escrito como literal**, coloca numa lista e faz uma transferência → observe o resultado.
2. Cria um `Cliente` cujo id venha de `new String("12345678900")` — simulando o que o `Scanner` faz com a entrada do usuário — e repete a transferência.
3. Imprima, nos dois casos: `idCadastrado == idBuscado` e `idCadastrado.equals(idBuscado)`.

Você vai ver o mesmo dado produzindo dois comportamentos. **Escreva no `PROGRESSO.md` o que apareceu no console antes de mudar qualquer linha.** Bug reproduzido é bug entendido.

---

## Bloco 6 — Sua vez (o exercício)

Três correções, em ordem. Faça **você**; use a IA em modo revisor, só depois de terminar cada uma.

### Tarefa 1 — Corrigir a comparação
`02-katas/09-conta-bancaria/src/service/BancoService.java`, dentro de `buscarCliente`.

**Critério de aceite:**
- A busca funciona com id vindo do `Scanner` (teste rodando a aplicação de verdade, digitando o CPF).
- A correção não quebra se o id for `null` — decida como tratar e justifique.
- Procure no repositório inteiro se o mesmo erro aparece em outro lugar: `grep -rn "== *id\|id *==" 02-katas/`. Achou? Corrija também.

### Tarefa 2 — Reorganizar as exceções
`02-katas/09-conta-bancaria/src/utils/Exceptions.java`.

**Critério de aceite:**
- Um pacote `exceptions`, uma classe pública por arquivo, sem classe container.
- Decida entre checked e unchecked e **escreva a justificativa** no README do kata (é uma decisão de design — cabe um ADR curto).
- Se optar por unchecked, note o efeito colateral: as assinaturas de `depositar`, `sacar` e `transferir` encolhem. Repare em como o código fica mais legível — esse é o argumento a favor, e você vai ter vivido ele.
- O kata continua compilando: `javac -d out $(find src -name "*.java")`.

### Tarefa 3 — Trazer a regra para dentro da entidade
`entities/Cliente.java` e `service/BancoService.java`.

**Critério de aceite:**
- `Cliente` (ou uma classe `Conta`, se você achar que o saldo não pertence ao cliente — pense nisso) passa a ter os métodos `depositar(double)` e `sacar(double)`, que validam e alteram o próprio saldo.
- `setSaldo` público deixa de existir.
- `BancoService` passa a **orquestrar** (achar os clientes, coordenar a transferência) sem manipular saldo diretamente.
- Responda no README: *depois dessa mudança, ainda é possível deixar um saldo negativo por acidente? Por qual caminho?*

---

## Bloco 7 — Registro

Em [`docs/PROGRESSO.md`](../../PROGRESSO.md), na entrada da Semana 2:

- o que o console mostrou na reprodução do bug (Bloco 5);
- qual hipótese você formulou e se ela estava certa de primeira;
- a decisão checked × unchecked e o motivo;
- a resposta da última pergunta da Tarefa 3.

E o teste final, que vale mais que as três tarefas: **explique em voz alta, sem olhar o código, por que `==` funcionava no seu teste e falhava com o usuário.** Se travar na explicação, releia o Bloco 2.1 e tente de novo amanhã.

---

## Material de apoio

- [Oracle — String pool e `intern()`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html)
- `Effective Java`, item 10 (obedeça o contrato de `equals`) e item 17 (minimize a mutabilidade)
- [Baeldung — checked vs unchecked exceptions](https://www.baeldung.com/java-checked-unchecked-exceptions)
- Martin Fowler — [Tell Don't Ask](https://martinfowler.com/bliki/TellDontAsk.html)

## Próxima aula

**Semana 3 — Modelagem de domínio:** por que `saldo` provavelmente não deveria estar em `Cliente`, e como decidir isso sem chutar. Levaremos junto o bônus de hoje: dinheiro com `BigDecimal`.
