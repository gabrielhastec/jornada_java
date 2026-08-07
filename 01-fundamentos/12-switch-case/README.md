
# 📘 Aula 12 – Switch-case

## 🎯 Objetivos

Nesta aula você aprenderá a:

* ✅ Substituir múltiplos `if-else`
* ✅ Selecionar entre várias opções
* ✅ Utilizar `switch`
* ✅ Aplicar `break`
* ✅ Trabalhar com `default`

---

# 🧠 Quando usar `switch`?

Use `switch` quando:

* Você está comparando **uma única variável**
* Contra **múltiplos valores fixos**
* E as condições são de **igualdade**

Exemplo típico:

```java
if (dia == 1) { ... }
else if (dia == 2) { ... }
else if (dia == 3) { ... }
```

Pode ser substituído por `switch`.

---

# 🔹 Sintaxe Básica

```java
switch (variavel) {
    case valor1:
        // código
        break;
    case valor2:
        // código
        break;
    default:
        // caso padrão
}
```

---

# 💻 Código da Aula

```java
import java.util.Scanner;

public class switchCase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dia = sc.nextInt();
        String diaSemana;

        switch (dia) {
            case 1: diaSemana = "Domingo"; break;
            case 2: diaSemana = "Segunda"; break;
            case 3: diaSemana = "Terça"; break;
            case 4: diaSemana = "Quarta"; break;
            case 5: diaSemana = "Quinta"; break;
            case 6: diaSemana = "Sexta"; break;
            case 7: diaSemana = "Sábado"; break;
            default: diaSemana = "Inválido";
        }

        System.out.println("Dia da semana: " + diaSemana);

        sc.close();
    }
}
```

---

# 🔍 Análise Técnica

### 📌 `switch (dia)`

O valor da variável `dia` será comparado com cada `case`.

---

### 📌 `case`

Cada `case` representa um possível valor.

Se houver correspondência:

* O código é executado
* O `break` encerra o bloco

---

### 📌 `break`

⚠ Fundamental.

Sem `break`, ocorre o fenômeno chamado **fall-through**.

Exemplo:

```java
case 1:
    System.out.println("Domingo");
case 2:
    System.out.println("Segunda");
```

Se `dia = 1`, imprimirá:

```
Domingo
Segunda
```

Porque não houve interrupção.

---

### 📌 `default`

Executado quando nenhum `case` corresponde.

É equivalente ao `else`.

---

# 📊 Fluxo de Execução

1. Avalia o valor do `switch`
2. Procura `case` correspondente
3. Executa bloco
4. Para no `break`
5. Se não encontrar → executa `default`

---

# 🔎 Comparação: `if-else` vs `switch`

| Situação                          | Melhor escolha |   |           |
| --------------------------------- | -------------- | - | --------- |
| Comparação de igualdade simples   | `switch`       |   |           |
| Comparações com `>`, `<`, `&&`, ` |                | ` | `if-else` |
| Muitas alternativas fixas         | `switch`       |   |           |
| Regras complexas                  | `if-else`      |   |           |

---

# 🧩 Tipos Aceitos no `switch`

No Java moderno, o `switch` aceita:

* `int`
* `byte`
* `short`
* `char`
* `String`
* `enum`

Não aceita:

* `double`
* `float`
* `boolean`

---

# 🧠 Observação Avançada (Java 14+)

Existe também a versão moderna do `switch`:

```java
String diaSemana = switch (dia) {
    case 1 -> "Domingo";
    case 2 -> "Segunda";
    default -> "Inválido";
};
```

Mais limpa, sem necessidade de `break`.

---

# ⚙️ Compilação

```bash
javac switchCase.java
java switchCase
```

---

# 🚀 Evolução Natural

Agora você domina:

* Expressões lógicas
* Condicionais
* Atribuições cumulativas
* Seleção múltipla
