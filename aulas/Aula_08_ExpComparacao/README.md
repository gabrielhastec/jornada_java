
# 📘 Aula 08 – Expressões de Comparação

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Utilizar operadores relacionais
* ✅ Comparar valores numéricos
* ✅ Entender o tipo `boolean`
* ✅ Compreender o resultado lógico (`true` ou `false`)
* ✅ Preparar base para estruturas condicionais

Essa aula é essencial para a construção de regras e decisões no código.

---

# 🧠 Conceitos Fundamentais

## 🔹 1. O que são Expressões de Comparação?

São expressões que comparam dois valores e retornam um resultado do tipo:

```java
boolean
```

O resultado sempre será:

```
true  ou  false
```

---

# 🔹 2. Operadores Relacionais

| Operador | Significado    | Exemplo   | Resultado |
| -------- | -------------- | --------- | --------- |
| `>`      | Maior que      | `10 > 5`  | true      |
| `<`      | Menor que      | `10 < 5`  | false     |
| `>=`     | Maior ou igual | `10 >= 5` | true      |
| `<=`     | Menor ou igual | `10 <= 5` | false     |
| `==`     | Igual          | `10 == 5` | false     |
| `!=`     | Diferente      | `10 != 5` | true      |

---

# 🔹 3. Tipo Boolean

O tipo `boolean` armazena apenas dois valores:

```java
true
false
```

Exemplo:

```java
boolean resultado = 10 > 5;
System.out.println(resultado); // true
```

Esse tipo será fundamental para:

* Estruturas condicionais (`if`)
* Estruturas de repetição (`while`)
* Validações de regras

---

# 💻 Código da Aula

```java
public class comparacao {
    public static void main(String[] args) {

        int a = 10, b = 5;

        System.out.println(a > b);   // true
        System.out.println(a < b);   // false
        System.out.println(a >= b);  // true
        System.out.println(a <= b);  // false
        System.out.println(a == b);  // false
        System.out.println(a != b);  // true

        double salario = 3500.00;
        System.out.println(salario > 3000); // true
    }
}
```

---

# 🧩 Análise Técnica

## 🔹 Avaliação da Expressão

Exemplo:

```java
a > b
```

O Java:

1. Avalia os valores
2. Realiza a comparação
3. Retorna `true` ou `false`

---

## 🔹 Comparação com `double`

```java
salario > 3000
```

Aqui ocorre promoção automática:

* `3000` (int)
* `salario` (double)

O Java converte `3000` para `double` antes da comparação.

---

# ⚠️ Atenção: `==` não é atribuição

Erro comum:

```java
a = b;   // atribuição
a == b;  // comparação
```

* `=` → atribui valor
* `==` → compara valores

---

# ⚠️ Comparação com String (Importante)

⚠️ Nunca usar `==` para comparar Strings.

Errado:

```java
nome == "João"
```

Correto:

```java
nome.equals("João")
```

Isso ocorre porque `String` é objeto e `==` compara referência de memória.

(Esse conceito será aprofundado futuramente.)

---

# 📌 Expressões Compostas (Prévia)

Em breve você poderá combinar comparações:

```java
a > b && salario > 3000
```

Mas isso será visto na próxima aula (Expressões Lógicas).

---

# ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

### 🔹 Compilar

```bash
javac comparacao.java
```

### 🔹 Executar

```bash
java comparacao
```

---

# 🚀 Evolução Esperada

Após esta aula você já consegue:

* Comparar valores corretamente
* Trabalhar com tipo `boolean`
* Entender avaliação lógica
* Evitar erro entre `=` e `==`
* Preparar base para `if` e estruturas condicionais

Essa aula é a fundação para:

* Decisões no código
* Validações
* Regras de negócio
* Sistemas reais
