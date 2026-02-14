
# 📘 Aula 03 – Variáveis e Manipulação de Strings

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Declarar e inicializar variáveis
* ✅ Trabalhar com tipos primitivos (`int`, `double`)
* ✅ Entender a diferença entre tipos primitivos e tipos não primitivos
* ✅ Utilizar métodos essenciais da classe `String`
* ✅ Manipular texto de forma programática

Essa aula é fundamental, pois variáveis são a base de qualquer aplicação.

---

## 🧠 Conceitos Fundamentais

## 🔹 1. O que são Variáveis?

Variáveis são espaços na memória usados para armazenar dados que podem ser utilizados durante a execução do programa.

Estrutura geral:

```java
tipo nomeDaVariavel = valor;
```

Exemplo:

```java
int idade = 20;
double altura = 1.75;
String nome = "João Silva";
```

---

## 🔹 2. Tipos Primitivos vs Não Primitivos

### 📌 Tipos Primitivos

São tipos básicos que armazenam valores diretamente na memória.

Exemplos usados nesta aula:

| Tipo     | Descrição                 | Exemplo |
| -------- | ------------------------- | ------- |
| `int`    | Número inteiro            | 10      |
| `double` | Número decimal (precisão) | 1.75    |

Características:

* Armazenam valor direto
* Não possuem métodos
* Mais leves em memória

---

### 📌 Tipo Não Primitivo – `String`

`String` é um objeto (classe) que representa uma sequência de caracteres.

Características:

* Armazena referência para um objeto
* Possui métodos
* Permite manipulação avançada de texto

Exemplo:

```java
String nome = "João Silva";
```

---

## 🔎 3. Métodos da Classe String

A classe `String` possui diversos métodos úteis.

### 🔹 `toUpperCase()`

Converte para maiúsculas.

```java
nome.toUpperCase()
```

---

### 🔹 `toLowerCase()`

Converte para minúsculas.

---

### 🔹 `length()`

Retorna a quantidade de caracteres da string.

---

### 🔹 `contains()`

Verifica se determinado texto existe dentro da string.

Retorna `true` ou `false`.

---

### 🔹 `replace()`

Substitui parte do texto por outro.

---

### 🔹 `charAt(index)`

Retorna o caractere de uma posição específica.

⚠️ Importante:

* Índices começam em **0**
* Se acessar índice inválido → ocorre erro (`StringIndexOutOfBoundsException`)

---

## 💻 Código da Aula

```java
public class variaveisJava {
    public static void main(String[] args) {

        int idade = 20;
        double altura = 1.75;
        String nome = "João Silva";

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);

        // Exemplos de métodos String
        System.out.println("Maiúsculas: " + nome.toUpperCase());
        System.out.println("Minúsculas: " + nome.toLowerCase());
        System.out.println("Comprimento: " + nome.length());
        System.out.println("Contém 'Silva'? " + nome.contains("Silva"));
        System.out.println("Substituindo João por Maria: " + nome.replace("João", "Maria"));
        System.out.println("Caractere na posição 3: " + nome.charAt(3));
    }
}
```

---

## 🧩 Análise do Código

### 📌 Declaração de variáveis

```java
int idade = 20;
```

* Tipo: `int`
* Nome: `idade`
* Valor: `20`

---

### 📌 Uso de métodos em String

```java
nome.toUpperCase()
```

Aqui estamos chamando um método pertencente ao objeto `nome`.

Isso só é possível porque `String` é um tipo não primitivo (objeto).

---

## ⚠️ Pontos de Atenção

✔ `String` é imutável
Isso significa que métodos como `replace()` e `toUpperCase()` não alteram a variável original — eles retornam uma nova string.

Exemplo:

```java
nome.toUpperCase();
System.out.println(nome);
```

Resultado:

```
João Silva
```

Para alterar, é necessário reatribuir:

```java
nome = nome.toUpperCase();
```

---

## ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

### 🔹 Compilar

```bash
javac variaveisJava.java
```

### 🔹 Executar

```bash
java variaveisJava
```

---

## 🚀 Evolução Esperada

Após esta aula você já consegue:

* Declarar variáveis corretamente
* Diferenciar tipos primitivos e objetos
* Manipular texto programaticamente
* Utilizar métodos básicos da classe `String`
* Entender imutabilidade de objetos

Esses conceitos serão utilizados em:

* Entrada de dados
* Estruturas condicionais
* Processamento de dados
* Desenvolvimento de sistemas reais
