
# 📘 Aula 07 – Classe Math (Operações Matemáticas)

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Utilizar métodos da classe `Math`
* ✅ Calcular raiz quadrada
* ✅ Calcular potência
* ✅ Obter valor absoluto
* ✅ Aplicar esses conceitos no cálculo do **Delta (Bhaskara)**

Essa aula introduz o uso de métodos utilitários da biblioteca padrão do Java.

---

# 🧠 Conceitos Fundamentais

## 🔹 1. O que é a classe `Math`?

A classe `Math` pertence ao pacote `java.lang`.

📌 Importante:

* Não precisa importar
* Todos os métodos são `static`
* Pode ser utilizada diretamente com `Math.metodo()`

Exemplo:

```java
Math.sqrt(9);
```

---

# 🔹 2. Principais Métodos Utilizados

## 📌 `Math.sqrt(x)`

Retorna a raiz quadrada de um número.

```java
Math.sqrt(9) // 3.0
```

⚠️ Retorna `double`.

---

## 📌 `Math.pow(base, expoente)`

Calcula potência.

```java
Math.pow(2, 3) // 8.0
```

Sempre retorna `double`.

---

## 📌 `Math.abs(valor)`

Retorna o valor absoluto (remove sinal negativo).

```java
Math.abs(-5) // 5
```

---

# 📐 Aplicação Prática – Delta (Bhaskara)

Fórmula do delta:

```
Δ = b² - 4ac
```

Implementação em Java:

```java
double delta = Math.pow(b, 2) - 4 * a * c;
```

Passos da avaliação:

1. Calcula `b²`
2. Calcula `4 * a * c`
3. Realiza a subtração

---

# 💻 Código da Aula

```java
public class extraMath {
    public static void main(String[] args) {

        double x = 3.0, y = 4.0, z = -5.0;
        int a = 25;

        System.out.println("Raiz quadrada de " + x + " = " + Math.sqrt(x));
        System.out.println(x + " elevado a " + y + " = " + Math.pow(x, y));
        System.out.println("Valor absoluto de " + z + " = " + Math.abs(z));

        double b = 10.0, c = 5.0;
        double delta = Math.pow(b, 2) - 4 * a * c;

        System.out.println("Delta = " + delta);
    }
}
```

---

# 🧩 Análise Técnica

## 🔹 Por que `Math.pow` retorna `double`?

Mesmo que os valores sejam inteiros, o retorno será sempre `double`.

Exemplo:

```java
Math.pow(2, 3) // 8.0
```

Isso ocorre porque operações matemáticas podem gerar números decimais.

---

## 🔹 Tipos Misturados

Na expressão:

```java
4 * a * c
```

Temos:

* `4` → int
* `a` → int
* `c` → double

O Java realiza **promoção automática** para `double`.

Resultado final: `double`.

---

# ⚠️ Cuidados Importantes

❌ Não usar `^` para potência
Em Java, `^` é operador bitwise XOR.

Errado:

```java
b ^ 2
```

Correto:

```java
Math.pow(b, 2)
```

---

# 📌 Outros Métodos Úteis da Classe Math

Mesmo não utilizados nesta aula, vale conhecer:

| Método           | Função                |
| ---------------- | --------------------- |
| `Math.max(a, b)` | Retorna maior valor   |
| `Math.min(a, b)` | Retorna menor valor   |
| `Math.round(x)`  | Arredonda             |
| `Math.ceil(x)`   | Arredonda para cima   |
| `Math.floor(x)`  | Arredonda para baixo  |
| `Math.random()`  | Gera número aleatório |

---

# ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

### 🔹 Compilar

```bash
javac extraMath.java
```

### 🔹 Executar

```bash
java extraMath
```

---

# 🚀 Evolução Esperada

Após esta aula você já consegue:

* Utilizar métodos utilitários da API padrão
* Resolver cálculos matemáticos estruturados
* Aplicar fórmulas matemáticas no código
* Entender promoção automática de tipos
* Evitar erro comum com operador `^`

Esse conhecimento será utilizado em:

* Algoritmos matemáticos
* Sistemas financeiros
* Estatística básica
* Jogos
* Problemas de vestibular e concursos
