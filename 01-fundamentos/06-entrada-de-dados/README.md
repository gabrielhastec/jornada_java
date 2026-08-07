
# 📘 Aula 06 – Entrada de Dados com Scanner

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Ler dados digitados pelo usuário
* ✅ Utilizar a classe `Scanner`
* ✅ Trabalhar com diferentes tipos de entrada (`int`, `double`, `String`, `char`)
* ✅ Configurar `Locale` para leitura correta de decimais
* ✅ Resolver o problema clássico do `nextLine()` após leitura numérica
* ✅ Encerrar corretamente o `Scanner`

Essa aula marca o início da **interatividade** nos programas Java.

---

# 🧠 Conceitos Fundamentais

## 🔹 1. Importação da Classe Scanner

A classe `Scanner` pertence ao pacote:

```java
import java.util.Scanner;
```

Ela permite ler dados da entrada padrão (teclado).

Também utilizamos:

```java
import java.util.Locale;
```

Para garantir que números decimais usem ponto (`.`).

---

# 🔹 2. Criando o Scanner

```java
Scanner sc = new Scanner(System.in);
```

* `System.in` → fluxo de entrada padrão (teclado)
* `sc` → objeto responsável pela leitura

---

# 🔹 3. Métodos de Leitura

## 📌 `nextInt()`

Lê número inteiro.

```java
int numero = sc.nextInt();
```

---

## 📌 `nextDouble()`

Lê número decimal.

```java
double valor = sc.nextDouble();
```

⚠️ Importante:
Se estiver no Brasil, é necessário:

```java
Locale.setDefault(Locale.US);
```

Para aceitar `10.5` em vez de `10,5`.

---

## 📌 `next()`

Lê apenas uma palavra (até o primeiro espaço).

```java
String nome = sc.next();
```

---

## 📌 `nextLine()`

Lê uma linha inteira (inclusive espaços).

```java
String frase = sc.nextLine();
```

---

## 📌 Leitura de `char`

Scanner não possui método direto para `char`, então usamos:

```java
char letra = sc.next().charAt(0);
```

Explicação:

1. `next()` → lê uma palavra
2. `charAt(0)` → pega o primeiro caractere

---

# ⚠️ Problema Clássico: `nextLine()` após números

Quando usamos:

```java
int numero = sc.nextInt();
String texto = sc.nextLine();
```

O `nextLine()` pode ser "pulado".

Isso acontece porque:

* `nextInt()` não consome a quebra de linha (`\n`)
* `nextLine()` lê essa quebra pendente

---

## ✅ Solução

Adicionar:

```java
sc.nextLine(); // limpa o buffer
```

Antes do `nextLine()` real.

---

# 💻 Código da Aula

```java
import java.util.Locale;
import java.util.Scanner;

public class entradaDados {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        System.out.printf("Você digitou: %.2f%n", x);

        char y = sc.next().charAt(0);
        System.out.println("Primeira letra: " + y);

        String a1 = sc.next();
        int a2 = sc.nextInt();
        double a3 = sc.nextDouble();
        System.out.printf(
            "String: %s, Inteiro: %d, Double: %.2f%n",
            a1, a2, a3
        );

        sc.nextLine(); // limpa buffer

        String s1 = sc.nextLine();
        System.out.println("Frase: " + s1);

        sc.close();
    }
}
```

---

# 🧩 Análise Técnica

## 🔹 Locale

```java
Locale.setDefault(Locale.US);
```

Garante que:

```
10.5  ✅
10,5  ❌
```

Sem isso, pode ocorrer:

```
InputMismatchException
```

---

## 🔹 Fechamento do Scanner

```java
sc.close();
```

Boa prática para liberar recursos do sistema.
Em aplicações maiores isso é essencial.

---

# ⚠️ Erros Comuns

❌ Esquecer de importar `Scanner`
❌ Não configurar `Locale`
❌ Esquecer de limpar o buffer
❌ Não fechar o scanner
❌ Usar `next()` achando que ele lê frase inteira

---

# ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

### 🔹 Compilar

```bash
javac entradaDados.java
```

### 🔹 Executar

```bash
java entradaDados
```

Digite os valores conforme solicitado pelo programa.

---

# 🚀 Evolução Esperada

Após esta aula você já consegue:

* Criar programas interativos
* Ler múltiplos tipos de dados
* Resolver problemas de buffer
* Trabalhar com entrada real do usuário
* Evitar erros comuns de leitura

Esse conhecimento será base para:

* Estruturas condicionais
* Estruturas de repetição
* Exercícios práticos
* Projetos completos
