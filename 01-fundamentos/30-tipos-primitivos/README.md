# 📘 Aula 30 – Tipos Primitivos Completos

## 🎯 Objetivo

Dominar o uso dos **tipos primitivos** do Java, compreendendo sua estrutura na memória e a relação com as **Wrapper Classes** de forma:

* ✔ eficiente (uso de memória)
* ✔ segura (evitando overflow e nulls)
* ✔ profissional (uso de wrappers e sufixos)

Além disso, aprender a:

* diferenciar cada um dos 8 tipos
* utilizar Autoboxing e Unboxing
* escolher o tipo correto para cada cenário

---

# 🧠 1. O que são Tipos Primitivos

Diferente de objetos, tipos primitivos são **valores puros** armazenados diretamente na memória (stack), o que os torna extremamente rápidos e leves.

---

## ❌ Problema da Escolha Errada

```java
// Gastar 64 bits para um valor que só vai até 10?
long idade = 10L; 
```

Problemas:
* desperdício de memória em larga escala
* código menos semântico

---

## ✅ Solução Ideal

```java
byte idade = 10; // Ocupa apenas 8 bits
```

✔ economia de recursos
✔ clareza na intenção do dado

---

# 🏷️ 2. Os 8 Tipos Primitivos

| Tipo | Tamanho | Faixa de Valores |
| :--- | :--- | :--- |
| **byte** | 8 bits | -128 a 127 |
| **short** | 16 bits | -32.768 a 32.767 |
| **int** | 32 bits | -2.147.483.648 a 2.147.483.647 |
| **long** | 64 bits | -9.223.372.036.854.775.808 a ... |
| **float** | 32 bits | ~6-7 casas decimais |
| **double** | 64 bits | ~15 casas decimais |
| **char** | 16 bits | único caractere (Unicode) |
| **boolean** | 1 bit* | `true` ou `false` |

---

# 🧩 3. Wrapper Classes

Cada primitivo possui uma **Classe Wrapper** correspondente, permitindo que tipos básicos sejam tratados como objetos (necessário para Collections).

| Primitivo | Wrapper |
| :--- | :--- |
| `int` | `Integer` |
| `char` | `Character` |
| `double` | `Double` |
| `boolean` | `Boolean` |

---

# 🔄 4. Autoboxing e Unboxing

O Java converte automaticamente entre primitivo e objeto:

```java
// Autoboxing (int -> Integer)
Integer x = 10; 

// Unboxing (Integer -> int)
int y = x; 
```

---

# 💻 Código

```java
public class TiposPrimitivos {

    public static void main(String[] args) {

        // ===============================
        // INTEIROS E SUFIXOS
        // ===============================
        byte b = 100;
        short s = 30000;
        int i = 1_000_000; // Underscore melhora a leitura
        long l = 9_000_000_000L; // L obrigatório para literais long

        System.out.println("Inteiros: " + b + ", " + s + ", " + i + ", " + l);

        // ===============================
        // PONTO FLUTUANTE
        // ===============================
        float f = 3.14f; // f obrigatório para float
        double d = 3.141592653589793;

        System.out.println("Decimais: float=" + f + ", double=" + d);

        // ===============================
        // CHAR E BOOLEAN
        // ===============================
        char letra = 'A';
        char unicode = '\u0041'; // Letra 'A' via código hexadecimal
        boolean ativo = true;

        System.out.println("Char: " + letra + " | Boolean: " + ativo);

        // ===============================
        // WRAPPERS E CONSTANTES
        // ===============================
        System.out.println("\nLimites do Tipo Inteiro:");
        System.out.println("Máximo: " + Integer.MAX_VALUE);
        System.out.println("Mínimo: " + Integer.MIN_VALUE);
    }
}
```

---

# 📊 Saída Esperada

```text
Inteiros: 100, 30000, 1000000, 9000000000
Decimais: float=3.14, double=3.141592653589793
Char: A | Boolean: true

Limites do Tipo Inteiro:
Máximo: 2147483647
Mínimo: -2147483648
```

---

# ⚠️ 5. Erros Comuns

### Esquecer Sufixos
```java
float f = 3.14;   // ❌ Erro: Java assume double por padrão
long l = 5000000000; // ❌ Erro: Java assume int por padrão (fora do limite)
```

### NullPointerException com Wrappers
```java
Integer x = null;
int y = x; // ❌ Erro em execução: unboxing de null!
```

---

# ⚙️ 6. Como Compilar e Executar

1. Abra o terminal na pasta do arquivo.
2. Compile: `javac TiposPrimitivos.java`
3. Execute: `java TiposPrimitivos`

---

# 📌 Conclusão

Nesta aula você aprendeu:

✔ A utilizar todos os 8 tipos primitivos
✔ A importância dos sufixos `L` e `f`
✔ Como as Wrapper Classes funcionam
✔ A evitar erros de Autoboxing e Unboxing
