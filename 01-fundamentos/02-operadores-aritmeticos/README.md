
# 📘 Aula 02 – Operadores Aritméticos

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a utilizar os **operadores aritméticos do Java** para realizar cálculos matemáticos básicos dentro de um programa.

Ao final, você será capaz de:

* ✅ Realizar operações de soma, subtração, multiplicação e divisão
* ✅ Utilizar o operador de resto (`%`)
* ✅ Entender como expressões são avaliadas
* ✅ Compreender o comportamento da divisão entre números inteiros

---

## 🧠 Conceitos Fundamentais

Os operadores aritméticos permitem executar cálculos diretamente no código.

### 🔹 Operadores Básicos

| Operador | Nome           | Exemplo  | Resultado |
| -------- | -------------- | -------- | --------- |
| `+`      | Adição         | `5 + 3`  | `8`       |
| `-`      | Subtração      | `10 - 4` | `6`       |
| `*`      | Multiplicação  | `6 * 2`  | `12`      |
| `/`      | Divisão        | `8 / 2`  | `4`       |
| `%`      | Resto (módulo) | `10 % 3` | `1`       |

---

## 🔎 Entendendo o Operador de Resto `%`

O operador `%` retorna o **resto da divisão inteira**.

Exemplo:

```java
10 % 3
```

Divisão inteira:

```
10 ÷ 3 = 3 (com resto 1)
```

Resultado:

```
1
```

📌 Muito utilizado para:

* Verificar se número é par ou ímpar
* Trabalhar com ciclos
* Operações matemáticas específicas

---

## ⚠️ Atenção: Divisão entre Inteiros

Em Java, quando dividimos dois números inteiros (`int`), o resultado também será inteiro.

Exemplo:

```java
System.out.println(5 / 2);
```

Resultado:

```
2
```

O valor decimal é descartado.

Se quiser resultado decimal:

```java
System.out.println(5.0 / 2);
```

Resultado:

```
2.5
```

Isso ocorre porque agora estamos utilizando um número do tipo `double`.

---

## 💻 Código da Aula

```java
public class operArit {
    public static void main(String[] args) {

        System.out.println("Soma: 5 + 3 = " + (5 + 3));
        System.out.println("Subtração: 10 - 4 = " + (10 - 4));
        System.out.println("Multiplicação: 6 * 2 = " + (6 * 2));
        System.out.println("Divisão: 8 / 2 = " + (8 / 2));
        System.out.println("Resto: 10 % 3 = " + (10 % 3));

    }
}
```

---

## 🧩 O que está acontecendo nesse código?

Exemplo:

```java
"Soma: 5 + 3 = " + (5 + 3)
```

Temos duas coisas acontecendo:

1. A expressão `(5 + 3)` é resolvida primeiro.
2. O resultado (`8`) é concatenado com a string.

📌 Os parênteses garantem que a operação seja feita antes da concatenação.

Se fosse:

```java
"Soma: " + 5 + 3
```

O resultado seria:

```
Soma: 53
```

Porque o Java interpretaria como concatenação de texto.

---

## ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

### 🔹 Compilar

```bash
javac operArit.java
```

### 🔹 Executar

```bash
java operArit
```

---

## 🚀 Evolução Esperada

Após esta aula você já consegue:

* Trabalhar com expressões matemáticas em Java
* Entender precedência básica de operadores
* Evitar erros comuns de concatenação
* Diferenciar divisão inteira de divisão decimal

Essa base será essencial para trabalhar com:

* Variáveis
* Entrada de dados
* Processamento de informações
* Estruturas condicionais
