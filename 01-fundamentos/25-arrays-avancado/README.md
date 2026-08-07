
# 📘 Aula 25 – Arrays Avançados

## 🎯 Objetivo

Aprofundar o uso de **arrays em Java**, incluindo:

* Arrays multidimensionais
* Loops aninhados para percorrer matrizes
* Métodos utilitários da classe `java.util.Arrays`
* Arrays contendo **objetos**

---

# 🧠 1. Arrays Multidimensionais

Um array multidimensional é um **array que contém outros arrays**.

O caso mais comum é uma **matriz (2 dimensões)**.

### Declaração

```java
int[][] matriz;
```

### Inicialização

```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

Visualmente:

```
1 2 3
4 5 6
7 8 9
```

---

# 🔁 2. Percorrendo Matrizes

Para acessar cada elemento usamos **loops aninhados**.

```java
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
    }
    System.out.println();
}
```

Explicação:

| Parte              | Significado       |
| ------------------ | ----------------- |
| `matriz.length`    | número de linhas  |
| `matriz[i].length` | número de colunas |

---

# 📦 3. Classe `Arrays`

A classe `java.util.Arrays` fornece diversos **métodos utilitários** para manipular arrays.

Importação:

```java
import java.util.Arrays;
```

---

## 🔹 Ordenação (`sort`)

```java
Arrays.sort(numeros);
```

Ordena o array em **ordem crescente**.

---

## 🔹 Busca Binária (`binarySearch`)

```java
int indice = Arrays.binarySearch(numeros, 8);
```

⚠️ Importante:

O array **precisa estar ordenado** antes.

---

## 🔹 Preencher Array (`fill`)

```java
Arrays.fill(array, valor);
```

Exemplo:

```java
Arrays.fill(preenchido, 42);
```

Resultado:

```
[42, 42, 42, 42, 42]
```

---

## 🔹 Copiar Array (`copyOf`)

```java
int[] copia = Arrays.copyOf(numeros, 3);
```

Cria um novo array contendo os **3 primeiros elementos**.

---

## 🔹 Converter para String (`toString`)

```java
System.out.println(Arrays.toString(numeros));
```

Resultado:

```
[1, 2, 5, 8, 9]
```

Sem esse método, o Java mostraria apenas o endereço de memória.

---

# 🧩 4. Array de Objetos

Arrays também podem armazenar **objetos**.

Exemplo simples:

```java
class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
```

Array de objetos:

```java
Produto[] produtos = new Produto[3];

produtos[0] = new Produto("Notebook", 3500);
produtos[1] = new Produto("Mouse", 80);
produtos[2] = new Produto("Teclado", 150);
```

Percorrendo:

```java
for (Produto p : produtos) {
    System.out.println(p.nome + " - R$" + p.preco);
}
```

---

# 💻 Código Completo da Aula

```java
import java.util.Arrays;

class Produto {

    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

}

public class ExemploArrays {

    public static void main(String[] args) {

        // ===============================
        // MATRIZ (ARRAY 2D)
        // ===============================

        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matriz:");

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }

        // ===============================
        // UTILIDADES DA CLASSE ARRAYS
        // ===============================

        int[] numeros = {5, 2, 8, 1, 9};

        Arrays.sort(numeros);

        System.out.println("Ordenado: " + Arrays.toString(numeros));

        int indice = Arrays.binarySearch(numeros, 8);

        System.out.println("Índice do 8: " + indice);

        int[] copia = Arrays.copyOf(numeros, 3);

        System.out.println("Cópia (3 primeiros): " + Arrays.toString(copia));

        int[] preenchido = new int[5];

        Arrays.fill(preenchido, 42);

        System.out.println("Preenchido: " + Arrays.toString(preenchido));

        // ===============================
        // ARRAY DE OBJETOS
        // ===============================

        Produto[] produtos = new Produto[3];

        produtos[0] = new Produto("Notebook", 3500);
        produtos[1] = new Produto("Mouse", 80);
        produtos[2] = new Produto("Teclado", 150);

        System.out.println("\nLista de produtos:");

        for (Produto p : produtos) {
            System.out.println(p.nome + " - R$ " + p.preco);
        }
    }
}
```

---

# 📊 Saída Esperada

```
Matriz:
1 2 3
4 5 6
7 8 9

Ordenado: [1, 2, 5, 8, 9]
Índice do 8: 3
Cópia (3 primeiros): [1, 2, 5]
Preenchido: [42, 42, 42, 42, 42]

Lista de produtos:
Notebook - R$ 3500.0
Mouse - R$ 80.0
Teclado - R$ 150.0
```

---

# 📌 Conclusão

✔ Matrizes (arrays multidimensionais)
✔ Loops aninhados
✔ Métodos utilitários da classe `Arrays`
✔ Arrays de objetos

Esses conceitos são muito usados em:

* algoritmos
* manipulação de dados
* estruturas de dados
* programação competitiva
