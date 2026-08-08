# Aula R3 — Dinheiro não é `double`

**Fase R · Semana 3 · ~2h**

**Pré-requisitos (o que você já viu e vai usar aqui):**
- Aula 03 — variáveis, os 8 tipos primitivos, sufixos (`10L`, `1.5f`) e por que `double` é aproximado
- Aula 17 — método: parâmetro, retorno, sobrecarga
- Aula 18/19 — classe, atributo, construtor
- Aula 29 — o que é lançar uma exceção com `throw` (usado no final, de forma simples)

**Conceito novo desta aula:** a classe `BigDecimal`. Ela é explicada do zero — você não precisa ter visto nada sobre ela.

---

## Bloco 1 — O problema

> Loja com 3.000 vendas por dia. No fim do mês, o financeiro liga: **o relatório de faturamento não bate com o extrato do banco**. A diferença é de R$ 4,17 — em um faturamento de R$ 800 mil.
>
> Ninguém consegue explicar. Não há venda faltando, não há estorno perdido. Os números simplesmente não fecham. O time passa dois dias conferindo pedido por pedido.

A causa é uma linha que parece inofensiva e que está **em 15 pastas do seu repositório**:

```java
private double preco;
```

## Bloco 2 — O conceito

### 2.1 Veja o problema acontecer

Rode isto (crie um arquivo `TesteDouble.java` em qualquer pasta temporária):

```java
public class TesteDouble {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2);          // 0.30000000000000004
        System.out.println(1.03 - 0.42);        // 0.6100000000000001
        System.out.println(0.1 * 3);            // 0.30000000000000004

        double total = 0.0;
        for (int i = 0; i < 10; i++) {
            total += 0.1;                        // dez vezes dez centavos
        }
        System.out.println(total);               // 0.9999999999999999
        System.out.println(total == 1.0);        // false
    }
}
```

Dez moedas de dez centavos não dão um real. **Não é bug do Java** — acontece em C, Python, JavaScript, em qualquer linguagem que use ponto flutuante binário.

### 2.2 Por que isso acontece

O computador guarda números em **base 2**. Em base 2, algumas frações decimais simplesmente **não têm representação exata** — do mesmo jeito que, em base 10, você não consegue escrever 1/3 exatamente (0,3333... infinito).

- `0.5` em binário é exato (é 1/2)
- `0.25` é exato (é 1/4)
- **`0.1` não é** — vira uma dízima infinita em binário, e o `double` guarda só uma aproximação com ~15 dígitos

Cada operação arrasta esse errinho. Com 3.000 vendas por dia, os errinhos somam — e viram os R$ 4,17 que ninguém explica.

### 2.3 A solução: `BigDecimal`

`BigDecimal` guarda o número em **base 10**, com precisão arbitrária: um valor inteiro e uma **escala** (quantas casas decimais). `R$ 12,34` é guardado como `1234` com escala `2`. Exato, sempre.

```java
import java.math.BigDecimal;

BigDecimal a = new BigDecimal("0.1");
BigDecimal b = new BigDecimal("0.2");
System.out.println(a.add(b));            // 0.3  <- exato
```

**Quatro coisas que você precisa saber para usar sem cair nas armadilhas:**

**1. Crie a partir de `String`, nunca de `double`.**

```java
new BigDecimal(0.1);          // 0.1000000000000000055511151231257827021181583404541015625
new BigDecimal("0.1");        // 0.1     <- correto
BigDecimal.valueOf(0.1);      // 0.1     <- tambem correto (usa Double.toString por dentro)
```

Se você criar a partir de `double`, o erro já entrou **antes** do `BigDecimal` — ele só preserva fielmente o lixo que recebeu.

**2. `BigDecimal` é imutável: operação devolve um objeto novo.**

```java
BigDecimal preco = new BigDecimal("100.00");
preco.add(new BigDecimal("50.00"));           // resultado JOGADO FORA
System.out.println(preco);                     // 100.00

preco = preco.add(new BigDecimal("50.00"));   // <- precisa reatribuir
System.out.println(preco);                     // 150.00
```

Esquecer a reatribuição é o erro nº 1 de quem está começando com `BigDecimal`. Você já conhece esse comportamento de outro lugar: `String` funciona igual (`nome.toUpperCase()` não altera `nome`).

**3. Operações têm nome, não símbolo.**

| Você quer | `double` | `BigDecimal` |
|---|---|---|
| somar | `a + b` | `a.add(b)` |
| subtrair | `a - b` | `a.subtract(b)` |
| multiplicar | `a * b` | `a.multiply(b)` |
| dividir | `a / b` | `a.divide(b, 2, RoundingMode.HALF_UP)` |
| comparar | `a > b` | `a.compareTo(b) > 0` |

Na divisão, **é obrigatório dizer quantas casas e como arredondar** — senão, uma conta como `10 / 3` lança `ArithmeticException` (dízima infinita, ele se recusa a inventar um resultado). `RoundingMode.HALF_UP` é o arredondamento comercial que você aprendeu na escola: 0,5 para cima.

**4. Use `compareTo` para comparar, não `equals`.**

```java
new BigDecimal("10.0").equals(new BigDecimal("10.00"));       // false  <- escalas diferentes!
new BigDecimal("10.0").compareTo(new BigDecimal("10.00"));    // 0      <- iguais em valor
```

`equals` compara valor **e** escala. Para dinheiro, o que importa é o valor: use `compareTo(...) == 0`.

### 2.4 A alternativa: centavos em `long`

Alguns sistemas (principalmente os de altíssimo volume) guardam **centavos em `long`**: R$ 12,34 vira `1234`. É exato e mais rápido, com o custo de você mesmo cuidar da formatação e de nunca esquecer que aquele número está em centavos.

Para o seu momento, `BigDecimal` é a escolha certa: é o padrão do mercado Java, é o que o JPA mapeia para `DECIMAL` no banco, e é o que vão esperar de você em code review.

---

## Bloco 3 — Onde isso aparece na sua vida de desenvolvedor

| Situação | O que acontece |
|---|---|
| **Code review** | `double preco` num PR de sistema financeiro é comentário de bloqueio na hora. É um dos poucos itens que quase todo revisor pega |
| **Banco de dados** | A coluna correta é `DECIMAL(10,2)` / `NUMERIC` — nunca `FLOAT`. Na sua migration `V1__create-table-product.sql` (branch `feat/catalogo-api`) você já usou `DECIMAL(10,2)`: acertou no banco e errou no Java |
| **Entrevista técnica** | "Por que não usar `double` para dinheiro?" é pergunta clássica de vaga backend. Saber responder com o exemplo do `0.1 + 0.2` te destaca |
| **API** | Preço serializado em JSON como `float` chega arredondado no front — o cliente vê R$ 19,99 e é cobrado R$ 20,00 |
| **Relatórios** | Somar milhares de linhas com `double` produz totais que não batem com a soma manual. É o bug do Bloco 1 |

**Regra prática para levar para sempre:** ponto flutuante (`double`, `float`) serve para grandeza **física e aproximada** — peso, temperatura, distância, percentual de progresso. Dinheiro, quantidade contável e qualquer coisa que precise fechar exato: `BigDecimal` ou inteiro.

---

## Bloco 4 — Implementação guiada

Exemplo em **outro domínio** (fatura de telefonia), para você ver o padrão e aplicar sozinho no seu código:

```java
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Fatura {

    private final BigDecimal valorBase;
    private final BigDecimal percentualImposto;   // 0.15 = 15%

    public Fatura(BigDecimal valorBase, BigDecimal percentualImposto) {
        this.valorBase = valorBase;
        this.percentualImposto = percentualImposto;
    }

    public BigDecimal getImposto() {
        // multiply devolve objeto novo; setScale define as casas do resultado
        return valorBase.multiply(percentualImposto)
                        .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal() {
        return valorBase.add(getImposto());
    }

    public BigDecimal getValorParcela(int parcelas) {
        if (parcelas <= 0) {
            throw new IllegalArgumentException("Numero de parcelas deve ser positivo.");
        }
        // divisao SEMPRE com escala e arredondamento explicitos
        return getTotal().divide(new BigDecimal(parcelas), 2, RoundingMode.HALF_UP);
    }
}
```

Repare em três decisões que valem para o seu código também:

1. Os campos são `final` — o valor de uma fatura não muda depois de criada (você aprofunda isso na aula P2, sobre invariantes)
2. Toda divisão declara escala e arredondamento
3. A regra de "parcelas tem que ser positivo" está **dentro** da classe que faz a conta, não espalhada em quem chama

> **Detalhe de arredondamento que aparece no mundo real:** ao parcelar R$ 100,00 em 3, cada parcela dá R$ 33,33 e sobram R$ 0,01. Sistema sério decide o que fazer com essa sobra (normalmente joga na primeira ou na última parcela). Isso não é preciosismo: é auditoria contábil. Você não precisa resolver isso agora — mas precisa saber que existe.

---

## Bloco 5 — A prova

Antes de sair trocando, **veja o erro com seus olhos** e registre:

1. Rode o `TesteDouble` do Bloco 2.1 e anote a saída.
2. Reescreva o mesmo laço com `BigDecimal` (dez somas de `"0.1"`) e mostre que o resultado é exatamente `1.0`.
3. Compare `equals` e `compareTo` com `"10.0"` e `"10.00"` e anote o resultado dos dois.

Cole as três saídas no [`PROGRESSO.md`](../../PROGRESSO.md).

---

## Bloco 6 — Sua vez

Converta os valores monetários para `BigDecimal`, nesta ordem (do menor para o maior):

**Tarefa 1 — Kata 02 (`02-katas/02-salario/`).** É o menor: um cálculo de salário por hora.
- Critério: o valor por hora aceita centavos (hoje é `int`, o que já é um bug — R$ 18,50 vira R$ 18,00)
- Critério: a saída continua mostrando duas casas decimais

**Tarefa 2 — Aula 19 (`01-fundamentos/19-encapsulamento-e-modificadores/`).** `Produto` com `preco` e `valorEstoque()`.
- Critério: `valorEstoque()` devolve `BigDecimal` com escala 2
- Critério: nenhum `new BigDecimal(double)` no código

**Tarefa 3 — Kata 09 (`02-katas/09-conta-bancaria/`).** O maior: saldo, salário, limite de crédito.
- Critério: comparações de saldo usam `compareTo`, não `<` ou `>`
- Critério: depósito e saque continuam funcionando pelo menu
- Pergunta para responder no README do kata: *qual comparação do código antigo teria dado errado com `equals` em vez de `compareTo`?*

> **Não converta as 15 pastas.** Estas três cobrem os casos que importam. As aulas 04, 08 e 13 são demonstrações de sintaxe, não regra de negócio — deixe como estão e registre no README da aula que ali `double` é aceitável **porque não representa dinheiro de verdade**. Saber onde **não** aplicar uma regra também é senioridade.

---

## Bloco 7 — Registro

No [`PROGRESSO.md`](../../PROGRESSO.md):
- as três saídas do Bloco 5
- qual foi o erro mais chato de pegar na conversão (aposto no "esqueci de reatribuir")
- a resposta da pergunta da Tarefa 3

**Teste do "explique de volta":** explique, sem consultar, por que `0.1 + 0.2 != 0.3` e por que `new BigDecimal(0.1)` não resolve o problema.

---

## Material de apoio

- [Javadoc — `BigDecimal`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigDecimal.html)
- [Javadoc — `RoundingMode`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/RoundingMode.html)
- *Effective Java*, item 60 — "Evite `float` e `double` quando precisar de respostas exatas"
- [0.30000000000000004.com](https://0.30000000000000004.com/) — o mesmo problema demonstrado em dezenas de linguagens

## Próxima aula

**R4 — Onde o domínio termina e a tela começa:** por que suas entidades não podem chamar `System.out.println`, e como isso se conecta diretamente com a sua dificuldade em POO.
