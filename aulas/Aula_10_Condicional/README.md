
# 📘 Aula 10 – Estruturas Condicionais (`if / else`)

## 🎯 Objetivos

Nesta aula você aprenderá a:

* ✅ Controlar o fluxo do programa
* ✅ Criar decisões com `if`
* ✅ Utilizar `else`
* ✅ Trabalhar com `else if`
* ✅ Estruturar regras de negócio básicas

---

# 🧠 Conceito Fundamental

Estruturas condicionais permitem que o programa execute blocos diferentes de código dependendo de uma condição lógica.

A condição **sempre deve resultar em um valor booleano (`true` ou `false`)**.

---

# 🔹 1. Condicional Simples (`if`)

Executa um bloco **apenas se a condição for verdadeira**.

### Sintaxe

```java
if (condicao) {
    // código executado se for true
}
```

### Exemplo

```java
int idade = 20;

if (idade >= 18) {
    System.out.println("Pode entrar.");
}
```

Se `idade` for menor que 18, nada acontece.

---

# 🔹 2. Condicional Composta (`if / else`)

Permite definir um caminho alternativo.

### Sintaxe

```java
if (condicao) {
    // se true
} else {
    // se false
}
```

### Exemplo

```java
double media = 7.0;

if (media >= 6.0) {
    System.out.println("Aprovado");
} else {
    System.out.println("Reprovado");
}
```

Agora sempre haverá uma resposta.

---

# 🔹 3. Condicional Encadeada (`if / else if / else`)

Usada quando existem **múltiplas condições exclusivas**.

### Sintaxe

```java
if (condicao1) {
} else if (condicao2) {
} else {
}
```

### Exemplo

```java
idade = 17;

if (idade < 16) {
    System.out.println("Não pode entrar.");
} else if (idade < 18) {
    System.out.println("Entrada com permissão dos pais.");
} else {
    System.out.println("Entrada liberada.");
}
```

📌 Importante:
A avaliação é feita **de cima para baixo**.
Quando uma condição é verdadeira, as demais não são verificadas.

---

# 💻 Código Completo da Aula

```java
public class condicional {

    public static void main(String[] args) {

        int idade = 20;

        if (idade >= 18) {
            System.out.println("Pode entrar.");
        }

        double media = 7.0;

        if (media >= 6.0) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }

        idade = 17;

        if (idade < 16) {
            System.out.println("Não pode entrar.");
        } else if (idade < 18) {
            System.out.println("Entrada com permissão dos pais.");
        } else {
            System.out.println("Entrada liberada.");
        }
    }
}
```

---

# 📊 Fluxo de Execução (Modelo Mental)

Exemplo:

```java
if (idade < 16)
```

1. A condição é avaliada.
2. Se `true` → executa o bloco.
3. Se `false` → vai para o próximo `else if`.
4. Se nenhuma condição for verdadeira → executa `else`.

---

# ⚠️ Boas Práticas

### ✅ Sempre usar chaves `{}`

Mesmo com apenas uma linha:

```java
if (condicao) {
    executar();
}
```

Evita bugs futuros.

---

### ✅ Evitar lógica redundante

Evite:

```java
if (idade >= 18) {
    return true;
} else {
    return false;
}
```

Prefira:

```java
return idade >= 18;
```

---

### ✅ Ordem correta das condições

Coloque as condições mais específicas primeiro.

Errado:

```java
if (idade >= 16) {
} else if (idade >= 18) {
}
```

Correto:

```java
if (idade >= 18) {
} else if (idade >= 16) {
}
```

---

# 📌 Exemplos Práticos

## 🎉 Permissão para festa

```java
boolean podeEntrar = idade >= 18;
```

---

## 🎓 Aprovação por média

```java
if (media >= 9) {
    System.out.println("Excelente");
} else if (media >= 7) {
    System.out.println("Bom");
} else if (media >= 6) {
    System.out.println("Regular");
} else {
    System.out.println("Reprovado");
}
```

---

# 🧩 Integração com Aula 09

As estruturas condicionais dependem diretamente de:

* Expressões lógicas (`&&`, `||`, `!`)
* Comparações (`>=`, `<`, `==`)
* Valores booleanos

Sem dominar lógica, o `if` vira tentativa e erro.

---

# ⚙️ Compilação e Execução

```bash
javac condicional.java
java condicional
```

---

# 🚀 Próximo Passo Natural

Depois de dominar `if`, o próximo salto lógico é:

* 🔄 `switch`
* 🔁 Laços (`while`, `for`)
* 📥 Entrada de dados com `Scanner`
* 🧠 Exercícios combinando tudo
