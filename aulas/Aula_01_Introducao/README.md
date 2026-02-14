
# 📘 Aula 01 – Introdução ao Java

## 🎯 Objetivo da Aula

Nesta aula você dará o primeiro passo no desenvolvimento com **Java**, entendendo:

* ✅ A estrutura básica de um programa Java
* ✅ O papel da classe e do método `main()`
* ✅ Como exibir informações no console
* ✅ A diferença entre `print` e `println`
* ✅ Como compilar e executar um programa Java via terminal

---

## 🧠 Conceitos Fundamentais

### 🔹 1. Estrutura de um Programa Java

Todo programa Java precisa obrigatoriamente de:

* Uma **classe**
* Um método principal chamado **`main`**
* Código dentro de blocos `{ }`

Exemplo estrutural:

```java
public class NomeDaClasse {
    public static void main(String[] args) {
        // código aqui
    }
}
```

📌 O método `main` é o ponto de entrada da aplicação.
Sem ele, o programa não executa.

---

### 🔹 2. Comentários em Java

Comentários são usados para documentação e organização do código.

```java
// Comentário de uma linha

/*
 Comentário
 de múltiplas linhas
*/
```

São ignorados pelo compilador.

---

### 🔹 3. Saída de Dados no Console

Java utiliza a classe `System` para exibir informações.

#### `System.out.print()`

* Imprime na mesma linha

#### `System.out.println()`

* Imprime e pula para a próxima linha

Exemplo:

```java
System.out.print("Olá");
System.out.println(" Mundo");
```

Saída:

```
Olá Mundo
```

---

## 💻 Código da Aula

```java
public class helloWord {
    public static void main(String[] args) {

        // Exibe mensagem sem quebra de linha
        System.out.print("Olá, mundo!");

        // Exibe mensagem com quebra de linha
        System.out.println(" Meu primeiro programa em Java.");
    }
}
```

---

## ⚙️ Como Compilar e Executar

### 🔹 1. Compilar o programa

No terminal, dentro da pasta `src`:

```bash
javac helloWord.java
```

Isso irá gerar um arquivo:

```
helloWord.class
```

---

### 🔹 2. Executar o programa

```bash
java helloWord
```

📌 Importante:
Não coloque `.java` ao executar.

---

## 🏗 O que está acontecendo por trás?

Quando você executa:

```bash
javac helloWord.java
```

O compilador Java transforma o código `.java` em **bytecode** (`.class`).

Depois, quando você executa:

```bash
java helloWord
```

A **JVM (Java Virtual Machine)** interpreta esse bytecode e executa o programa.

Esse é o motivo pelo qual Java é considerado **portável** ("Write Once, Run Anywhere").

---

## 📚 Boas Práticas Iniciais

✔ Nome da classe deve começar com letra maiúscula
✔ Nome do arquivo deve ser igual ao nome da classe
✔ Sempre manter o código bem indentado
✔ Usar comentários de forma estratégica

---

## 🚀 Evolução Esperada

Após esta aula você já consegue:

* Criar arquivos `.java`
* Compilar via terminal
* Executar aplicações simples
* Entender a estrutura mínima de um programa Java

Essa base será usada em todas as próximas aulas.
