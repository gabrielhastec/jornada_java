
# 📘 Aula 17 – Métodos e Modularização

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Criar seus próprios métodos, em vez de escrever tudo dentro do `main`
* ✅ Entender a anatomia de um método: retorno, nome, parâmetros e corpo
* ✅ Diferenciar método `void` de método que **devolve** valor
* ✅ Usar `return` para devolver um resultado e encerrar o método
* ✅ Entender que **parâmetro é cópia** do argumento
* ✅ Aplicar **sobrecarga** (mesmo nome, parâmetros diferentes)
* ✅ Entender o que `static` significa — e por que ele some na próxima aula

> **Pré-requisito:** Aulas 01 a 16 (variáveis, condicionais, laços, strings).
> **Nesta aula ainda não existem objetos.** Objetos começam na [Aula 18](../18-classes-e-objetos/) — e esta aula é exatamente a ponte para lá.

---

# 🧠 1. Por que Métodos Existem

Até aqui, todo o seu código morava dentro do `main`. Veja o problema:

```java
public static void main(String[] args) {
    double media1 = (7.5 + 9.0) / 2;
    System.out.println("Aluno A: " + media1);

    double media2 = (6.0 + 4.5) / 2;
    System.out.println("Aluno B: " + media2);

    double media3 = (8.0 + 8.5) / 2;
    System.out.println("Aluno C: " + media3);
}
```

A mesma conta escrita três vezes. Se a regra mudar (passar a considerar peso, ou arredondar), você tem **três lugares** para alterar — e vai esquecer de um.

Com método:

```java
static double calcularMedia(double n1, double n2) {
    return (n1 + n2) / 2;
}
```

Agora a regra existe em **um lugar só**. Mudou a regra, mudou ali.

**Um método faz duas coisas ao mesmo tempo:**

1. **Elimina repetição** — a regra fica em um lugar
2. **Dá nome a uma ideia** — `calcularMedia(...)` diz o que acontece; `(n1 + n2) / 2` obriga a decifrar

A segunda é a mais importante e a menos percebida. Código legível é código em que os nomes contam a história.

---

# 🔬 2. Anatomia de um Método

```java
static double calcularMedia(double n1, double n2) {
    return (n1 + n2) / 2;
}
```

| Parte | No exemplo | O que é |
|---|---|---|
| Modificador | `static` | pertence à classe, não a um objeto (seção 7) |
| Tipo de retorno | `double` | o tipo do valor devolvido — `void` se não devolve nada |
| Nome | `calcularMedia` | **verbo**, em `camelCase` |
| Parâmetros | `(double n1, double n2)` | os dados que o método precisa receber |
| Corpo | `{ ... }` | o que ele faz |
| `return` | `return (n1 + n2) / 2;` | devolve o resultado e **encerra** o método |

**Assinatura do método** é o nome + a lista de tipos dos parâmetros: `calcularMedia(double, double)`. É por ela que o compilador identifica qual método você está chamando.

---

# 📤 3. `void` × Método com Retorno

## 🔹 `void` — faz algo, não devolve nada

```java
static void exibirCabecalho(String titulo) {
    System.out.println("===== " + titulo + " =====");
}
```

Chamada:

```java
exibirCabecalho("BOLETIM");    // executa e pronto
```

❌ Não dá para guardar o resultado — não existe resultado:

```java
String x = exibirCabecalho("BOLETIM");   // erro: 'void' type not allowed here
```

---

## 🔹 Com retorno — devolve um valor para quem chamou

```java
static double calcularMedia(double n1, double n2) {
    return (n1 + n2) / 2;
}
```

O valor devolvido precisa ser **usado ou guardado**:

```java
double media = calcularMedia(7.5, 9.0);              // guardado
System.out.println(calcularMedia(7.5, 9.0));         // usado direto
calcularMedia(7.5, 9.0);                             // ⚠️ calculado e jogado fora
```

A terceira linha compila e não faz nada de útil. Você já viu esse mesmo comportamento com `String`: `nome.toUpperCase();` sozinho também joga o resultado fora ([Aula 16](../16-manipulacao-de-strings/)).

---

## 🔹 `return` encerra o método na hora

```java
static String situacao(double media) {
    if (media >= 7.0) {
        return "Aprovado";        // saiu daqui: nada abaixo executa
    }
    if (media >= 5.0) {
        return "Recuperação";
    }
    return "Reprovado";
}
```

⚠️ **Todo caminho possível precisa terminar em `return`.** Se existir um caminho sem retorno, o compilador acusa: `missing return statement`.

---

# 📥 4. Parâmetro × Argumento

* **Parâmetro** é a variável declarada na assinatura: `double n1`
* **Argumento** é o valor real passado na chamada: `7.5`

```java
static double calcularMedia(double n1, double n2) { ... }   // n1, n2 = parâmetros

calcularMedia(7.5, 9.0);                                    // 7.5, 9.0 = argumentos
```

A ordem importa — o primeiro argumento cai no primeiro parâmetro, sempre.

---

## 🔹 Parâmetro é uma CÓPIA

Este é o ponto que mais gera confusão:

```java
static int dobrar(int valor) {
    valor = valor * 2;      // altera a CÓPIA
    return valor;
}
```

```java
int idade = 20;
int idadeDobrada = dobrar(idade);

System.out.println(idade);           // 20  <- NÃO mudou
System.out.println(idadeDobrada);    // 40
```

O método recebeu **o valor** `20`, não a variável `idade`. Java sempre passa argumento **por valor**.

> Essa regra tem uma consequência importante quando o argumento é um objeto — e é justamente ali que quase todo mundo erra. Você vê isso na [Aula 21](../21-objetos/), depois de saber o que é uma referência.

---

# 🔁 5. Sobrecarga (*Overloading*)

Java permite **vários métodos com o mesmo nome**, desde que a lista de parâmetros seja diferente:

```java
static double calcularMedia(double n1, double n2) {
    return (n1 + n2) / 2;
}

static double calcularMedia(double n1, double n2, double n3) {
    return (n1 + n2 + n3) / 3;
}
```

```java
calcularMedia(7.5, 9.0);          // usa o de 2 parâmetros
calcularMedia(7.5, 9.0, 6.0);     // usa o de 3 parâmetros
```

O compilador escolhe pela **quantidade e pelos tipos** dos argumentos.

⚠️ **O tipo de retorno não conta.** Isto não compila:

```java
static double calcular(int a) { ... }
static int    calcular(int a) { ... }   // ❌ already defined
```

> **Uso no dia a dia:** você já usou sobrecarga sem saber. `System.out.println` aceita `int`, `double`, `String`, `boolean` — são vários métodos `println` sobrecarregados.

---

# 🔍 6. Escopo: Onde Cada Variável Existe

Variável declarada dentro de um método **só existe dentro dele**:

```java
static double calcularMedia(double n1, double n2) {
    double soma = n1 + n2;      // 'soma' existe só aqui
    return soma / 2;
}

public static void main(String[] args) {
    System.out.println(soma);   // ❌ cannot find symbol
}
```

Isso é uma **proteção**, não uma limitação: cada método é uma caixa fechada. Você consegue ler um método e entender o que ele faz sem precisar ler o resto do arquivo.

Duas variáveis com o mesmo nome em métodos diferentes **não são a mesma variável** — não há conflito nenhum.

---

# ⚙️ 7. Por que `static`?

Repare que todos os métodos desta aula têm `static`:

```java
static double calcularMedia(double n1, double n2) { ... }
```

`static` significa: **o método pertence à classe, não a um objeto**. Ele pode ser chamado direto, sem criar nada antes.

O `main` é `static` justamente por isso — a JVM precisa chamá-lo antes de existir qualquer objeto. E, como o `main` é `static`, ele **só consegue chamar diretamente outros métodos `static` da mesma classe**. Se você tirar o `static` de `calcularMedia`, o compilador acusa:

```text
non-static method calcularMedia(double,double) cannot be referenced from a static context
```

Guarde esse erro: ele vai aparecer de novo, e agora você sabe o motivo.

> **A ponte para a próxima aula:** nesta aula os métodos são soltos, sem dono. Na [Aula 18](../18-classes-e-objetos/) eles ganham um **objeto** ao qual pertencem — e aí o `static` desaparece da maioria deles, porque o método passa a operar sobre os dados daquele objeto específico.

---

# 💻 Código da Aula

```java
public class Metodos {

    public static void main(String[] args) {

        exibirCabecalho("BOLETIM");

        // método que devolve valor
        double media = calcularMedia(7.5, 9.0);
        System.out.println("Média de 2 notas: " + media);

        // sobrecarga: mesmo nome, 3 parâmetros
        double mediaTrimestral = calcularMedia(7.5, 9.0, 6.0);
        System.out.println("Média de 3 notas: " + mediaTrimestral);

        // o retorno de um método alimenta outro
        System.out.println("Situação: " + situacao(calcularMedia(8.0, 9.0)));
        System.out.println("Situação: " + situacao(calcularMedia(5.0, 6.0)));
        System.out.println("Situação: " + situacao(calcularMedia(4.0, 3.0)));

        // parâmetro é cópia: o original não muda
        int idade = 20;
        int idadeDobrada = dobrar(idade);
        System.out.println("original = " + idade + " | devolvido = " + idadeDobrada);

        exibirCabecalho("FIM");
    }

    static void exibirCabecalho(String titulo) {
        System.out.println();
        System.out.println("===== " + titulo + " =====");
    }

    static double calcularMedia(double n1, double n2) {
        return (n1 + n2) / 2;
    }

    static double calcularMedia(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }

    static String situacao(double media) {
        if (media >= 7.0) {
            return "Aprovado";
        }
        if (media >= 5.0) {
            return "Recuperação";
        }
        return "Reprovado";
    }

    static int dobrar(int valor) {
        valor = valor * 2;
        return valor;
    }
}
```

> O arquivo completo, com os comentários e o diagrama da anatomia, está em [`src/Metodos.java`](src/Metodos.java).

---

# 🖥️ Saída Esperada

```text

===== BOLETIM =====
Média de 2 notas: 8.25
Média de 3 notas: 7.5
Situação: Aprovado
Situação: Recuperação
Situação: Reprovado
original = 20 | devolvido = 40

===== FIM =====
```

---

# ⚠️ Erros Comuns

| Erro | Mensagem do compilador |
|---|---|
| Método com retorno sem `return` em algum caminho | `missing return statement` |
| Guardar o resultado de um método `void` | `'void' type not allowed here` |
| Chamar método não-`static` a partir do `main` | `non-static method ... cannot be referenced from a static context` |
| Sobrecarga só pelo tipo de retorno | `method ... is already defined` |
| Usar fora do método uma variável declarada dentro dele | `cannot find symbol` |
| Argumento na ordem errada | compila e devolve resultado errado — **sem aviso nenhum** |

O último é o perigoso: `calcularDesconto(preco, percentual)` chamado como `calcularDesconto(percentual, preco)` compila perfeitamente. Ordem de parâmetro do mesmo tipo é fonte clássica de bug silencioso.

---

# 🧩 Boas Práticas

**✅ Nome de método é verbo:** `calcularMedia`, `exibirCabecalho`, `validarCpf`.
Se o nome não tem verbo, provavelmente o método faz coisa demais ou não tem propósito claro.

**✅ Um método, uma responsabilidade.** Se você precisa de "e" para descrever o que ele faz (*"calcula a média **e** imprime na tela"*), são dois métodos.

**✅ Prefira devolver a imprimir.** Um método que calcula e devolve serve para tela, arquivo, API e teste. Um método que calcula e imprime só serve para o console.

```java
static double calcularMedia(double n1, double n2) {   // ✅ devolve
    return (n1 + n2) / 2;
}

static void calcularMedia(double n1, double n2) {     // ❌ preso ao console
    System.out.println((n1 + n2) / 2);
}
```

> Essa é a mesma regra do **[Achado 5 da auditoria](../../docs/AUDITORIA.md#achado-5--domínio-imprimindo-no-console-11-arquivos)** — *quem calcula não mostra* — e é o assunto da [Aula R4 da trilha](../../docs/trilha/fase-r/aula-r4-fronteira-dominio-ui.md). Começar a praticar isso aqui, com método solto, deixa a POO muito mais fácil depois.

**✅ Método longo é sinal, não pecado.** Passou de ~20 linhas, provavelmente há um método menor escondido lá dentro esperando um nome.

---

# 🧪 Exercícios Propostos

**1️⃣** Escreva `static int somar(int a, int b)` e use-o no `main`.

**2️⃣** Escreva `static boolean ehPar(int numero)` que devolve `true` ou `false`. Use-o dentro de um `for` de 1 a 10.

**3️⃣** Sobrecarregue `saudacao()`: uma versão sem parâmetro que devolve `"Olá!"` e outra que recebe um nome e devolve `"Olá, Maria!"`.

**4️⃣** Escreva `static double calcularDesconto(double preco, double percentual)` que devolve o preço já com desconto. Depois chame-a com os argumentos **trocados de ordem** e explique por que o compilador não reclamou.

**5️⃣** Pegue um dos seus katas em [`02-katas/`](../../02-katas/) que tem tudo dentro do `main` e extraia **pelo menos dois métodos** com nome de verbo. Compare o `main` antes e depois.

---

# 📌 Resumo da Aula

| Conceito | O que levar |
|---|---|
| Método | um nome para um pedaço de comportamento |
| `void` | executa, não devolve |
| `return` | devolve o valor **e** encerra o método |
| Parâmetro × argumento | declarado × passado na chamada |
| Passagem por valor | o método recebe uma cópia; o original não muda |
| Sobrecarga | mesmo nome, lista de parâmetros diferente |
| Escopo | variável do método só existe dentro dele |
| `static` | pertence à classe, não a um objeto |

---

# ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

```bash
javac Metodos.java
```

```bash
java Metodos
```

---

# 🚀 Evolução Esperada

Após esta aula você já consegue:

* Tirar código de dentro do `main` e dar nome a ele
* Decidir entre `void` e método com retorno
* Explicar por que alterar um parâmetro não altera a variável de quem chamou
* Ler a mensagem `non-static method ... cannot be referenced from a static context` e saber o que fazer

**Próxima aula:** [Aula 18 — Classes e objetos](../18-classes-e-objetos/). Lá, os dados (que hoje você passa como parâmetro) e os métodos (que hoje estão soltos) passam a morar **juntos**, dentro de um objeto. É o começo da orientação a objetos — e ela fica muito mais simples quando você já sabe o que é um método.
