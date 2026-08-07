# 📘 Aula 31 — Operadores de Incremento e Decremento em Java

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Utilizar os operadores `++` e `--`
* ✅ Entender a diferença entre pré-incremento e pós-incremento
* ✅ Aplicar corretamente esses operadores em loops e contadores
* ✅ Evitar erros comuns e comportamentos inesperados
* ✅ Compreender quando utilizar cada abordagem

---

# 🧠 Conceitos Fundamentais

## 🔹 O que são Operadores de Incremento e Decremento?

Os operadores de incremento e decremento servem para alterar o valor de uma variável numérica em **1 unidade**.

| Operador | Nome           | Comportamento                   |
| -------- | -------------- | ------------------------------- |
| `++i`    | Pré-incremento | Incrementa primeiro, usa depois |
| `i++`    | Pós-incremento | Usa primeiro, incrementa depois |
| `--i`    | Pré-decremento | Decrementa primeiro, usa depois |
| `i--`    | Pós-decremento | Usa primeiro, decrementa depois |

---

# 🔍 Diferença Entre Pré e Pós Incremento

## 🔹 Pós-incremento (`i++`)

Primeiro o valor é utilizado, depois ocorre o incremento.

```java
int a = 5;

System.out.println(a++); // imprime 5
System.out.println(a);   // agora vale 6
```

### Fluxo:

1. Usa o valor atual (`5`)
2. Incrementa para (`6`)

---

## 🔹 Pré-incremento (`++i`)

Primeiro ocorre o incremento, depois o valor é utilizado.

```java
int a = 5;

System.out.println(++a); // imprime 6
System.out.println(a);   // continua 6
```

### Fluxo:

1. Incrementa para (`6`)
2. Usa o valor atualizado (`6`)

---

# ⚖️ Comparação Visual

| Código | Valor Impresso | Valor Final         |
| ------ | -------------- | ------------------- |
| `a++`  | valor antigo   | incrementado depois |
| `++a`  | valor novo     | já incrementado     |
| `a--`  | valor antigo   | decrementado depois |
| `--a`  | valor novo     | já decrementado     |

---

# 💻 Código Completo da Aula

```java
public class IncrementoDecremento {

    public static void main(String[] args) {

        // Pós-incremento: usa o valor, depois incrementa
        int a = 10;
        System.out.println("Pós-incremento: " + a++); // imprime 10
        System.out.println("Após: " + a);              // imprime 11

        // Pré-incremento: incrementa, depois usa o valor
        int b = 10;
        System.out.println("Pré-incremento: " + ++b); // imprime 11
        System.out.println("Após: " + b);              // imprime 11

        // Pós-decremento
        int c = 5;
        System.out.println("Pós-decremento: " + c--); // imprime 5
        System.out.println("Após: " + c);              // imprime 4

        // Pré-decremento
        int d = 5;
        System.out.println("Pré-decremento: " + --d); // imprime 4
        System.out.println("Após: " + d);              // imprime 4

        // Caso de uso: Contador regressivo
        int estoque = 3;
        System.out.println("\nControle de estoque:");

        while (estoque > 0) {
            System.out.println("Unidades restantes: " + estoque--);
        }

        System.out.println("Estoque zerado.");

        // Caso de uso: loop crescente
        System.out.println("\nLoop crescente:");

        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }

        // Caso de uso: loop decrescente
        System.out.println("\nLoop decrescente:");

        for (int i = 4; i >= 0; i--) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
```

---

# 🖥️ Saída Esperada

```text
Pós-incremento: 10
Após: 11

Pré-incremento: 11
Após: 11

Pós-decremento: 5
Após: 4

Pré-decremento: 4
Após: 4

Controle de estoque:
Unidades restantes: 3
Unidades restantes: 2
Unidades restantes: 1
Estoque zerado.

Loop crescente:
0 1 2 3 4

Loop decrescente:
4 3 2 1 0
```

---

# 🔄 Uso em Loops

## 🔹 Incrementando no `for`

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

Nesse contexto:

```java
i++
```

e

```java
++i
```

produzem o mesmo resultado, porque o valor retornado pelo incremento não é utilizado.

---

## 🔹 Loop Decrescente

```java
for (int i = 10; i >= 0; i--) {
    System.out.println(i);
}
```

Muito utilizado em:

* contagem regressiva
* controle de estoque
* timers
* algoritmos reversos

---

# ⚠️ Erros Comuns

## ❌ Confundir Pré e Pós Incremento

```java
int x = 5;
int y = x++;
```

### Resultado:

```text
y = 5
x = 6
```

Muitos iniciantes esperam que `y` receba `6`, mas isso não acontece porque o pós-incremento usa o valor antes de incrementar.

---

## ❌ Loop Infinito

```java
int i = 0;

while (i < 5) {
    System.out.println(i);
}
```

### Problema:

O valor de `i` nunca muda.

### Correção:

```java
i++;
```

---

# 🧩 Boas Práticas

## ✅ Prefira clareza

Evite expressões complexas:

```java
int resultado = a++ + ++b - --c;
```

Embora válido, esse tipo de código reduz bastante a legibilidade.

---

## ✅ Use incremento principalmente em loops

O uso mais comum e recomendado:

```java
for (int i = 0; i < 10; i++)
```

---

## ✅ Evite múltiplos incrementos na mesma linha

Ruim:

```java
array[i++] = lista[++j];
```

Melhor:

```java
i++;
j++;

array[i] = lista[j];
```

---

# 📌 Resumo da Aula

| Conceito        | Explicação                          |
| --------------- | ----------------------------------- |
| `i++`           | Usa primeiro, incrementa depois     |
| `++i`           | Incrementa primeiro, usa depois     |
| `i--`           | Usa primeiro, decrementa depois     |
| `--i`           | Decrementa primeiro, usa depois     |
| Uso mais comum  | Loops e contadores                  |
| Principal risco | Confusão entre pré e pós incremento |

---

# 🧪 Exercícios Propostos

## 1️⃣ Faça um contador crescente de 1 até 10

---

## 2️⃣ Faça uma contagem regressiva de 10 até 0

---

## 3️⃣ Simule um sistema de vidas de jogo

Exemplo:

```text
Vida restante: 3
Vida restante: 2
Vida restante: 1
Game Over
```

---

## 4️⃣ Descubra o valor final das variáveis

```java
int x = 5;
int y = x++;
int z = ++x;
```

---

# ⚙️ Como Compilar e Executar

## 🔹 Compilar

```bash
javac IncrementoDecremento.java
```

## 🔹 Executar

```bash
java IncrementoDecremento
```

---

# 🚀 Conclusão

Os operadores de incremento e decremento são extremamente utilizados no desenvolvimento Java, especialmente em:

* loops
* contadores
* índices de arrays
* controle de repetição
* algoritmos iterativos

Entender corretamente a diferença entre pré e pós incremento evita bugs sutis e melhora sua leitura de código.
