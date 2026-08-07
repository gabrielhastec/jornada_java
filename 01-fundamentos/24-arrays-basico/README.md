# 📘 Aula 24 – Arrays (Básico)

## 🎯 Objetivo

* Entender o que é um array
* Declarar e inicializar arrays
* Acessar e modificar elementos
* Percorrer arrays com `for` e `for-each`
* Compreender índice, tamanho e limites
* Aplicar arrays em um pequeno sistema prático

---

# 1️⃣ Conceito Central

Um **array** é uma estrutura que armazena múltiplos valores do **mesmo tipo**, organizados por índice.

> Um array é uma coleção fixa e indexada de elementos do mesmo tipo.

Características importantes:

* Tamanho fixo após criação
* Índices começam em `0`
* Acesso direto por posição
* Armazena tipos primitivos ou objetos

---

# 2️⃣ Declaração e Inicialização

## 📌 Declaração

```java
int[] numeros;
```

## 📌 Criação com tamanho definido

```java
numeros = new int[5];
```

Agora temos 5 posições:

```
Índice:   0   1   2   3   4
Valor:    0   0   0   0   0
```

Valores padrão:

* `int` → 0
* `double` → 0.0
* `boolean` → false
* Objetos → null

---

## 📌 Declaração + Inicialização direta

```java
int[] numeros = {10, 20, 30, 40};
```

---

# 3️⃣ Acessando Elementos

```java
int[] numeros = {10, 20, 30};

System.out.println(numeros[0]); // 10
numeros[1] = 50;
System.out.println(numeros[1]); // 50
```

⚠️ Acesso inválido:

```java
numeros[3]; // ArrayIndexOutOfBoundsException
```

---

# 4️⃣ Percorrendo Arrays

## 🔹 Com `for` tradicional

```java
for (int i = 0; i < numeros.length; i++) {
    System.out.println(numeros[i]);
}
```

Use `.length` para saber o tamanho.

---

## 🔹 Com `for-each`

```java
for (int numero : numeros) {
    System.out.println(numero);
}
```

Mais simples, mas não permite acessar o índice diretamente.

---

# 5️⃣ Exemplo Prático – Sistema de Notas de Alunos

Vamos criar um pequeno sistema que:

* Armazena notas
* Calcula média
* Mostra maior e menor nota

---

## 📂 Classe `SistemaNotas`

```java
public class SistemaNotas {

    public static void main(String[] args) {

        double[] notas = {7.5, 8.0, 6.5, 9.0, 5.5};

        double soma = 0;
        double maior = notas[0];
        double menor = notas[0];

        for (int i = 0; i < notas.length; i++) {

            soma += notas[i];

            if (notas[i] > maior) {
                maior = notas[i];
            }

            if (notas[i] < menor) {
                menor = notas[i];
            }
        }

        double media = soma / notas.length;

        System.out.println("=== RESULTADO ===");
        System.out.println("Média: " + media);
        System.out.println("Maior nota: " + maior);
        System.out.println("Menor nota: " + menor);
    }
}
```

---

## 🔍 O que esse sistema demonstra?

* Criação de array com valores iniciais
* Uso de `.length`
* Percurso com `for`
* Acumulação de valores
* Comparação de elementos
* Cálculo baseado no tamanho do array

---

# 6️⃣ Modelo Mental Correto

Visualize o array como:

```
double[] notas = {7.5, 8.0, 6.5, 9.0, 5.5};

Índice:  0    1    2    3    4
Valor:  7.5  8.0  6.5  9.0  5.5
```

O índice é a posição na memória.

---

# 7️⃣ Arrays de Objetos

Arrays também podem armazenar objetos:

```java
String[] nomes = {"Ana", "Carlos", "Maria"};
```

Ou:

```java
Relatorio[] relatorios = new Relatorio[3];
```

⚠️ Nesse caso:

* O array é criado
* Mas os objetos ainda são `null` até instanciados

---

# 8️⃣ Erros Comuns

### ❌ Esquecer que começa em 0

### ❌ Usar `<=` no loop

```java
for (int i = 0; i <= numeros.length; i++) // ERRO
```

### ❌ Achar que array cresce automaticamente

Arrays têm tamanho fixo.

---

# 9️⃣ Diferença para Aula 25 (Array Avançado)

Na próxima aula você verá:

* Arrays multidimensionais
* Arrays de objetos com lógica real
* Ordenação
* Busca
* Manipulação mais complexa

Hoje o foco é:

> Estrutura básica + controle por índice + percurso.

---

# 🧠 Conclusão Arquitetural

Array é:

* Estrutura fundamental de dados
* Base para listas, coleções e estruturas mais complexas
* Essencial para entender memória e organização sequencial

Sem dominar arrays, não se domina estrutura de dados.
