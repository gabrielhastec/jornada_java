
# 📘 Aula 13 – Operador Ternário (`? :`)

## 🎯 Objetivos

Nesta aula você aprenderá a:

* ✅ Escrever decisões simples em uma única linha
* ✅ Utilizar o operador `? :`
* ✅ Substituir `if-else` simples por expressão condicional
* ✅ Aplicar em regras práticas como descontos

---

# 🧠 Conceito Fundamental

O operador ternário é uma **expressão condicional** que retorna um valor.

### 📌 Sintaxe

```java
variavel = (condicao) ? valorSeVerdadeiro : valorSeFalso;
```

Funciona como um `if-else`, porém retorna um valor diretamente.

---

# 🔍 Equivalência com `if-else`

### Forma tradicional:

```java
int y;

if (x > 5) {
    y = 20;
} else {
    y = 30;
}
```

### Forma com operador ternário:

```java
int y = (x > 5) ? 20 : 30;
```

Resultado idêntico, código mais enxuto.

---

# 💻 Código da Aula

```java
public class condTernario {

    public static void main(String[] args) {

        int x = 10;
        int y = (x > 5) ? 20 : 30;

        System.out.println("y = " + y);

        double preco = 150.0;
        double desconto = (preco > 100.0) ? 0.1 : 0.05;

        double precoFinal = preco - (preco * desconto);

        System.out.println("Preço com desconto: " + precoFinal);
    }
}
```

---

# 🧩 Análise Técnica

### 🔹 Exemplo 1

```java
int y = (x > 5) ? 20 : 30;
```

Fluxo:

1. Avalia `x > 5`
2. Se `true` → retorna `20`
3. Se `false` → retorna `30`
4. Atribui o valor a `y`

---

### 🔹 Exemplo 2 – Regra de Desconto

```java
double desconto = (preco > 100.0) ? 0.1 : 0.05;
```

Regra aplicada:

* Produto acima de 100 → 10% desconto
* Caso contrário → 5%

---

# 📊 Exemplo de Execução

Entrada fixa:

```java
double preco = 150.0;
```

Cálculo:

```
150 > 100 → true
Desconto = 0.1
Preço final = 150 - (150 * 0.1)
Preço final = 135
```

Saída:

```
Preço com desconto: 135.0
```

---

# ⚠️ Regras Importantes

## ✅ O operador ternário retorna um valor

Você não pode usá-lo como bloco de código.

❌ Errado:

```java
(x > 5) ? System.out.println("Maior") : System.out.println("Menor");
```

Embora funcione, não é uma boa prática.
Prefira usar ternário para **atribuição**, não para executar múltiplas ações.

---

## ✅ Os dois lados devem ser compatíveis em tipo

Exemplo válido:

```java
double valor = (condicao) ? 10.0 : 20;
```

Java faz conversão automática.

---

## ⚠️ Evite ternários complexos

Evite:

```java
int resultado = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
```

Funciona, mas reduz legibilidade.

Se a lógica cresce, volte para `if-else`.

---

# 🧠 Quando Usar?

Use operador ternário quando:

* A decisão é simples
* Existe apenas uma variável sendo atribuída
* Não há múltiplos comandos

Não use quando:

* Existem várias ações
* A lógica é complexa
* A leitura fica comprometida

---

# 🔄 Comparação Rápida

| Caso                               | Melhor Escolha |
| ---------------------------------- | -------------- |
| Decisão simples com retorno direto | Ternário       |
| Lógica complexa                    | if-else        |
| Múltiplos blocos de código         | if-else        |

---

# ⚙️ Compilação

```bash
javac condTernario.java
java condTernario
```

---

# 🚀 Panorama Atual do Seu Progresso

Você já domina:

* Operadores aritméticos
* Expressões lógicas
* `if-else`
* `switch`
* Atribuições cumulativas
* Operador ternário

O próximo salto natural agora é:

🔁 Estruturas de repetição:

* `while`
* `do-while`
* `for`
* Controle com `break` e `continue`
