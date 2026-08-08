
# 📘 Aula 03 – Variáveis e Tipos de Dados

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Declarar, inicializar e reatribuir variáveis
* ✅ Nomear variáveis segundo a convenção Java
* ✅ Conhecer os **8 tipos primitivos**, seus tamanhos e faixas de valor
* ✅ Escolher o tipo certo para cada dado
* ✅ Usar os sufixos `L` e `f` e o separador `_`
* ✅ Reconhecer **overflow** e **perda de precisão**
* ✅ Entender por que `double` **não serve para dinheiro**
* ✅ Usar `String` como tipo de texto

> **Pré-requisito:** Aula 01 (estrutura de uma classe) e Aula 02 (operadores aritméticos).
> **Nesta aula ainda não existem objetos.** Tudo aqui é valor puro. Objetos começam na [Aula 18](../18-classes-e-objetos/).

Essa aula é a base de todas as outras: **todo programa é dado guardado em variável e transformado**.

---

# 🧠 1. O que é uma Variável

Uma variável é um **espaço nomeado na memória** que guarda um valor durante a execução do programa.

Toda variável em Java tem três partes:

```java
int idade = 20;
│   │      │
│   │      └── valor
│   └───────── nome
└───────────── tipo
```

Java é uma linguagem **estaticamente tipada**: você declara o tipo, e ele **nunca muda**. O valor pode mudar quantas vezes você quiser.

```java
int idade = 20;
idade = 21;          // ✅ muda o valor
idade = "vinte";     // ❌ nem compila: String não cabe num int
```

---

## 🔹 1.1 Declaração × Inicialização

```java
int idade;           // declaração: reserva o espaço
idade = 20;          // inicialização: coloca o primeiro valor
```

Normalmente se faz tudo numa linha:

```java
int idade = 20;
```

⚠️ **Variável local sem valor não pode ser usada.** Isso não compila:

```java
int idade;
System.out.println(idade);   // ❌ variable idade might not have been initialized
```

---

## 🔹 1.2 Constantes com `final`

Quando o valor **não deve mudar**, use `final`:

```java
final int ANO_ATUAL = 2026;
ANO_ATUAL = 2027;    // ❌ cannot assign a value to final variable
```

Convenção: constante em `MAIUSCULA_COM_UNDERSCORE`.

> **Uso no dia a dia:** alíquota de imposto, limite de tentativas de login, tamanho máximo de arquivo. Deixar como `final` documenta a intenção e impede que alguém altere por engano.

---

# 🏷️ 2. Nomes: Regras e Convenção

**Regras da linguagem** (se quebrar, não compila):

* Não pode começar com número: `2idade` ❌
* Não pode ter espaço nem acento: `minha idade` ❌, `endereço` ⚠️ (compila, mas evite)
* Não pode ser palavra reservada: `int class = 1;` ❌
* **Diferencia maiúscula de minúscula:** `idade` e `Idade` são duas variáveis diferentes

**Convenção da comunidade** (compila do mesmo jeito, mas é assim que se escreve Java):

| Elemento | Convenção | Exemplo |
|---|---|---|
| Variável | `camelCase` | `precoUnitario` |
| Constante | `MAIUSCULA_COM_UNDERSCORE` | `TAXA_JUROS` |
| Classe | `PascalCase` | `VariaveisJava` |

✅ Nome bom descreve **o dado**, não o tipo:

```java
int qtdItens = 12;      // ✅ diz o que é
int numeroInt = 12;     // ❌ repete o que o tipo já disse
int x = 12;             // ❌ não diz nada
```

---

# 🔢 3. Os 8 Tipos Primitivos

Tipo primitivo guarda o **valor puro** direto na memória. Não é objeto, não tem método, é rápido e leve.

São exatamente 8 — não existe um nono:

| Tipo | Tamanho | Faixa de valores | Guarda |
|---|---|---|---|
| `byte` | 8 bits | −128 a 127 | inteiro bem pequeno |
| `short` | 16 bits | −32.768 a 32.767 | inteiro pequeno |
| `int` | 32 bits | −2.147.483.648 a 2.147.483.647 | **inteiro padrão** |
| `long` | 64 bits | ±9,2 quintilhões | inteiro gigante |
| `float` | 32 bits | ~7 dígitos de precisão | decimal aproximado |
| `double` | 64 bits | ~15 dígitos de precisão | **decimal padrão** |
| `char` | 16 bits | um caractere Unicode | `'A'`, `'ç'`, `'7'` |
| `boolean` | 1 bit* | `true` ou `false` | verdadeiro/falso |

<sub>\* na prática a JVM reserva mais que 1 bit, mas o valor lógico é binário.</sub>

**Os dois padrões:** quando não houver motivo para outra coisa, use `int` para inteiro e `double` para decimal. São os que o Java assume por padrão e os mais usados no dia a dia.

---

## 🔹 3.1 Escolher o Tipo Certo

O tipo não é só uma exigência do compilador — ele **documenta a intenção** e define o custo em memória.

```java
long idade = 10L;    // ❌ 64 bits para um número que nunca passa de 130
byte idade = 10;     // ✅ 8 bits, e já diz "esse valor é pequeno"
```

Em um programa de console isso não muda nada. Em uma tabela de banco com 50 milhões de linhas, muda muito.

**Guia rápido:**

| O dado é… | Use |
|---|---|
| contagem, idade, quantidade | `int` |
| id de banco, timestamp, valor muito grande | `long` |
| medida física aproximada (peso, altura, temperatura) | `double` |
| resposta sim/não, status ativo/inativo | `boolean` |
| uma única letra, símbolo ou dígito | `char` |
| texto (nome, e-mail, endereço) | `String` |
| **dinheiro** | ❌ nenhum primitivo — veja a seção 6 |

---

# ✍️ 4. Literais: Sufixos e Separador

**Literal** é o valor escrito direto no código: `20`, `1.75`, `'A'`, `true`.

## 🔹 O sufixo `L` (long)

Java lê todo número inteiro escrito no código como `int`. Se o valor passa do limite do `int`, precisa do `L`:

```java
long habitantes = 8000000000;    // ❌ integer number too large
long habitantes = 8000000000L;   // ✅
```

## 🔹 O sufixo `f` (float)

Java lê todo número com casa decimal como `double`. Para `float`, o `f` é obrigatório:

```java
float temperatura = 36.6;    // ❌ possible lossy conversion from double to float
float temperatura = 36.6f;   // ✅
```

## 🔹 O separador `_`

Serve **só para leitura humana** — o compilador ignora:

```java
int habitantes = 1000000;      // quantos zeros são mesmo?
int habitantes = 1_000_000;    // ✅ um milhão, na hora
```

## 🔹 Aspas simples × aspas duplas

```java
char letra = 'J';        // ✅ char usa aspas SIMPLES, um caractere só
char letra = "J";        // ❌ incompatible types: String cannot be converted to char
String nome = "João";    // ✅ String usa aspas DUPLAS
```

---

# ⚠️ 5. Overflow: Quando o Valor Não Cabe

Este é o motivo real de a faixa de valores da tabela importar.

```java
int limite = 2147483647;    // o maior int que existe
System.out.println(limite + 1);
```

Saída:

```text
-2147483648
```

**Não deu erro.** Não lançou exceção, não avisou nada: o valor "deu a volta" e virou o menor número possível. O programa continua rodando com o número errado.

> **Uso no dia a dia:** um contador de visualizações declarado como `int` passa de 2,1 bilhões e vira negativo. Um `id` de tabela que cresce mais do que o previsto começa a colidir. É por isso que id de banco costuma ser `long`, não `int`. Esse tipo de bug não aparece em teste — aparece em produção, meses depois.

---

# 🎯 6. Precisão: por que `double` Não Serve para Dinheiro

Rode isto:

```java
System.out.println(0.1 + 0.2);
System.out.println(1.03 - 0.42);
```

Saída:

```text
0.30000000000000004
0.6100000000000001
```

**Não é bug do Java.** `float` e `double` guardam números em **base 2**, e algumas frações decimais simplesmente não têm representação exata em binário — do mesmo jeito que 1/3 não tem representação exata em base 10 (0,333… infinito).

`0.5` e `0.25` são exatos (são 1/2 e 1/4). **`0.1` não é**: vira dízima infinita em binário, e o `double` guarda só uma aproximação.

Cada operação arrasta esse errinho. Multiplique por milhares de transações e você tem o clássico *"o fechamento do mês não bateu por R$ 0,03"*.

**A regra que vale para sempre:**

| Para… | Use |
|---|---|
| grandeza física e aproximada (peso, altura, temperatura, % de progresso) | `double` |
| dinheiro, ou qualquer valor que precise fechar exato | **`BigDecimal`** |

`BigDecimal` guarda o número em base 10, com precisão exata. Ele **não é um tipo primitivo** — é uma classe da biblioteca do Java, então usá-lo exige saber o que é um objeto e um método. Por isso ele não aparece aqui: o assunto é a **[Aula R3 da trilha — "Dinheiro não é `double`"](../../docs/trilha/fase-r/aula-r3-dinheiro.md)**.

Por ora, o que você precisa levar desta aula é **saber identificar o problema**: se o valor é dinheiro, `double` está errado.

> **Uso no dia a dia:** `double preco` em um pull request de sistema financeiro é comentário de bloqueio na hora. É também uma das perguntas mais clássicas de entrevista para vaga backend.

---

# 🔤 7. `String`: o Tipo para Texto

Nenhum dos 8 primitivos guarda texto — `char` guarda **um** caractere só. Para uma sequência de caracteres, existe a `String`:

```java
String nome = "João Silva";
```

`String` **não é primitivo**: é uma classe. Por enquanto, o que você precisa saber é:

* usa **aspas duplas**
* o operador `+` **concatena** (junta) textos e valores:

```java
System.out.println(nome + " tem " + idade + " anos.");
```

Saída:

```text
João Silva tem 21 anos.
```

> Os **métodos** da `String` (`toUpperCase()`, `length()`, `replace()`, `charAt()`…) e o conceito de **imutabilidade** são o assunto da **[Aula 16](../16-manipulacao-de-strings/)** — depois que você já souber o que é um objeto e um método.

---

# 🔍 8. Escopo: Onde a Variável Existe

Uma variável existe apenas **dentro do bloco `{ }` em que foi declarada**, e deixa de existir quando o bloco termina.

```java
public static void main(String[] args) {
    int idade = 20;      // existe do aqui até o } final do main
}
// aqui fora, idade não existe mais
```

Isso vira assunto de verdade quando você aprender `if`, laços e métodos — cada um abre um bloco novo. Por ora, guarde a ideia: **variável não vaza do bloco onde nasceu.**

---

# 💻 Código da Aula

```java
public class VariaveisJava {

    public static void main(String[] args) {

        // ============================================================
        // 1. DECLARAR, INICIALIZAR E REATRIBUIR
        // ============================================================
        int idade = 20;
        System.out.println("Idade: " + idade);

        idade = 21;                        // muda o VALOR, nunca o TIPO
        System.out.println("Nova idade: " + idade);

        final int ANO_ATUAL = 2026;        // final = não aceita reatribuição
        System.out.println("Ano atual: " + ANO_ATUAL);

        // ============================================================
        // 2. OS 8 TIPOS PRIMITIVOS
        // ============================================================
        byte  itensNaCaixa   = 100;
        short alunosNaEscola = 30_000;
        int   habitantesDaCidade = 1_000_000;
        long  habitantesDoPlaneta = 8_000_000_000L;   // L obrigatório

        float  temperatura = 36.6f;                   // f obrigatório
        double distanciaEmKm = 384_400.5;

        char inicialDoNome = 'J';                     // aspas SIMPLES
        boolean maiorDeIdade = true;

        // ============================================================
        // 3. OVERFLOW
        // ============================================================
        int limiteDoInt = 2147483647;
        System.out.println("limite do int + 1 -> " + (limiteDoInt + 1));

        // ============================================================
        // 4. double É APROXIMADO
        // ============================================================
        System.out.println("0.1 + 0.2   -> " + (0.1 + 0.2));

        // ============================================================
        // 5. String
        // ============================================================
        String nome = "João Silva";
        System.out.println(nome + " tem " + idade + " anos.");
    }
}
```

> O arquivo completo, com todos os `println` e comentários, está em [`src/VariaveisJava.java`](src/VariaveisJava.java).

---

# 🖥️ Saída Esperada

```text
Idade: 20
Nova idade: 21
Ano atual: 2026

byte  -> 100
short -> 30000
int   -> 1000000
long  -> 8000000000
float  -> 36.6
double -> 384400.5
char    -> J
boolean -> true

limite do int     -> 2147483647
limite do int + 1 -> -2147483648

0.1 + 0.2   -> 0.30000000000000004
1.03 - 0.42 -> 0.6100000000000001

Nome: João Silva
João Silva tem 21 anos.
```

---

# ⚠️ Erros Comuns

| Erro | Mensagem do compilador |
|---|---|
| `long x = 8000000000;` (faltou o `L`) | `integer number too large` |
| `float f = 3.14;` (faltou o `f`) | `possible lossy conversion from double to float` |
| `char c = "A";` (aspas duplas) | `incompatible types: String cannot be converted to char` |
| Usar variável sem inicializar | `variable x might not have been initialized` |
| Reatribuir um `final` | `cannot assign a value to final variable` |
| `Idade` × `idade` | `cannot find symbol` |

E os dois que **não dão mensagem nenhuma** — os perigosos:

* **overflow** (seção 5): o número dá a volta em silêncio
* **`double` para dinheiro** (seção 6): o centavo some em silêncio

---

# ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

```bash
javac VariaveisJava.java
```

```bash
java VariaveisJava
```

> O nome do arquivo tem que ser **exatamente** igual ao nome da classe pública — `VariaveisJava.java` para `public class VariaveisJava`. É regra da linguagem, e foi o [Achado 1 da auditoria](../../docs/AUDITORIA.md#achado-1--20-pastas-não-compilam-nome-do-arquivo--nome-da-classe).

---

# 🧪 Exercícios Propostos

**1️⃣** Declare uma variável para cada um dos 8 tipos primitivos, com um valor que faça sentido para o tipo, e imprima todas.

**2️⃣** Provoque o overflow do `byte`: atribua `127` e some `1`. Anote o resultado e explique com a tabela da seção 3.

**3️⃣** Descubra por que estas duas linhas não compilam e conserte:

```java
short populacao = 70000;
float nota = 8.5;
```

**4️⃣** Some `0.1` dez vezes em um `double` e imprima o total. O resultado é exatamente `1.0`?

**5️⃣** Para cada dado abaixo, escolha o tipo e **justifique em uma frase**: CPF · quantidade em estoque · preço do produto · se o cliente é VIP · nota de 0 a 10 · id do pedido no banco.

---

# 📌 Resumo da Aula

| Conceito | O que levar |
|---|---|
| Variável | tipo + nome + valor; o tipo nunca muda |
| `final` | constante, não aceita reatribuição |
| 8 primitivos | `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean` |
| Padrões | `int` para inteiro, `double` para decimal |
| Sufixos | `L` para `long`, `f` para `float` |
| Overflow | estourou a faixa, o valor dá a volta **sem erro** |
| Precisão | `double` é aproximado — dinheiro é `BigDecimal` |
| `String` | texto, aspas duplas, não é primitivo |

---

# 🚀 Evolução Esperada

Após esta aula você já consegue:

* Declarar variáveis com o tipo certo e nome legível
* Explicar a diferença entre os 8 primitivos e quando usar cada um
* Justificar por que um `id` de banco é `long` e não `int`
* Explicar por que `0.1 + 0.2 != 0.3` — e o que usar no lugar

**Próxima aula:** [Aula 04 — Saída de dados formatada](../04-saida-de-dados/), onde os valores que você acabou de declarar passam a ser exibidos de forma controlada, com `printf` e casas decimais.
