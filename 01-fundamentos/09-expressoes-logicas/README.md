
# 📘 Aula 09 – Expressões Lógicas

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Combinar expressões booleanas
* ✅ Criar condições compostas
* ✅ Utilizar operadores lógicos
* ✅ Entender avaliação de curto-circuito
* ✅ Aplicar lógica em cenários reais

Essa aula prepara o terreno para estruturas condicionais mais complexas.

---

# 🧠 Conceitos Fundamentais

## 🔹 1. O que são Expressões Lógicas?

São combinações de expressões booleanas utilizando operadores lógicos.

Exemplo:

```java
(idade >= 18) && (nota >= 6.0)
```

O resultado será sempre `true` ou `false`.

---

# 🔹 2. Operadores Lógicos

| Operador | Nome       | Significado                               |           |                                                 |
| -------- | ---------- | ----------------------------------------- | --------- | ----------------------------------------------- |
| `&&`     | E lógico   | Verdadeiro se **ambas** forem verdadeiras |           |                                                 |
| `        |            | `                                         | OU lógico | Verdadeiro se **pelo menos uma** for verdadeira |
| `!`      | NÃO lógico | Inverte o valor booleano                  |           |                                                 |

---

# 🔹 3. Operador `&&` (E lógico)

Retorna `true` somente se as duas condições forem verdadeiras.

Exemplo:

```java
(a < b) && (b < c)
```

Tabela Verdade:

| Condição A | Condição B | Resultado |
| ---------- | ---------- | --------- |
| true       | true       | true      |
| true       | false      | false     |
| false      | true       | false     |
| false      | false      | false     |

---

# 🔹 4. Operador `||` (OU lógico)

Retorna `true` se pelo menos uma condição for verdadeira.

Tabela Verdade:

| Condição A | Condição B | Resultado |
| ---------- | ---------- | --------- |
| true       | true       | true      |
| true       | false      | true      |
| false      | true       | true      |
| false      | false      | false     |

---

# 🔹 5. Operador `!` (NÃO lógico)

Inverte o valor booleano.

```java
!(a > b)
```

Se `(a > b)` for `false`, o resultado será `true`.

---

# 💻 Código da Aula

```java
public class expLogica {
    public static void main(String[] args) {

        int a = 10, b = 20, c = 30;

        System.out.println((a > b) && (b < c)); // false
        System.out.println((a < b) && (b < c)); // true
        System.out.println((a > b) || (b < c)); // true
        System.out.println(!(a > b));           // true

        int idade = 18;
        double nota = 7.5;

        boolean passou = (idade >= 18) && (nota >= 6.0);
        System.out.println("Passou? " + passou);
    }
}
```

---

# 🧩 Análise Técnica

## 🔹 Curto-Circuito (Short-Circuit)

Java utiliza avaliação de curto-circuito:

### No `&&`

Se a primeira condição for `false`, a segunda nem é avaliada.

```java
false && qualquerCoisa
```

Resultado já será `false`.

---

### No `||`

Se a primeira condição for `true`, a segunda nem é avaliada.

```java
true || qualquerCoisa
```

Resultado já será `true`.

📌 Isso melhora performance e evita erros.

---

# 📌 Exemplos Práticos

## 🔹 Aprovação de Aluno

```java
boolean aprovado = (nota >= 6.0) && (frequencia >= 75);
```

---

## 🔹 Elegibilidade para Vaga

```java
boolean elegivel = (idade >= 18) && (experiencia >= 2);
```

---

## 🔹 Permissão para Dirigir

```java
boolean podeDirigir = (idade >= 18) && (possuiCNH);
```

---

# ⚠️ Precedência dos Operadores

Ordem de prioridade:

1. `!`
2. `&&`
3. `||`

Exemplo:

```java
true || false && false
```

Avaliação real:

```java
true || (false && false)
```

Resultado:

```
true
```

Se quiser controlar a ordem, use parênteses.

---

# ⚠️ Erros Comuns

❌ Confundir `&` com `&&`
❌ Confundir `|` com `||`
❌ Esquecer parênteses
❌ Usar lógica invertida sem perceber

---

# ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

### 🔹 Compilar

```bash
javac expLogica.java
```

### 🔹 Executar

```bash
java expLogica
```

---

# 🚀 Evolução Esperada

Após esta aula você já consegue:

* Criar condições compostas
* Aplicar lógica real em decisões
* Entender curto-circuito
* Estruturar regras de negócio simples
* Preparar código para estruturas condicionais

Essa aula é a base para:

* `if`
* `switch`
* Loops condicionais
* Sistemas de validação
