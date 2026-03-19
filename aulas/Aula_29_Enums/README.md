
# 📘 Aula 29 – Enumerações (Enums)

## 🎯 Objetivo

Utilizar **enumerações (enums)** para representar conjuntos fixos de constantes de forma:

* ✔ segura (type-safe)
* ✔ organizada
* ✔ orientada a objetos

Além disso, aprender que enums podem:

* possuir atributos
* ter métodos
* encapsular regras de negócio

---

# 🧠 1. O que é um Enum

Um `enum` é um tipo especial de classe que representa um **conjunto fixo de valores constantes**.

---

## ❌ Problema sem Enum

```java
String status = "APROVADO";
```

Problemas:

* risco de erro de digitação
* falta de validação
* difícil manutenção

---

## ✅ Solução com Enum

```java
Status status = Status.APROVADO;
```

✔ mais seguro
✔ mais legível
✔ validado pelo compilador

---

# 🏷️ 2. Declaração de Enum

```java
public enum DiaSemana {
    SEGUNDA,
    TERCA,
    QUARTA
}
```

Uso:

```java
DiaSemana hoje = DiaSemana.SEGUNDA;
```

---

# 🧩 3. Enum com Atributos e Construtor

Enums podem ter **estado interno**, como uma classe comum.

```java
SEGUNDA("Segunda-feira", 1)
```

---

## Estrutura

```java
private String nomeCompleto;
private int numero;
```

Construtor:

```java
DiaSemana(String nomeCompleto, int numero) {
    this.nomeCompleto = nomeCompleto;
    this.numero = numero;
}
```

⚠️ O construtor de enum é **sempre privado (implícito)**.

---

# 🔧 4. Métodos em Enum

Você pode adicionar comportamento:

```java
public boolean isDiaUtil() {
    return this != SABADO && this != DOMINGO;
}
```

---

# 🔄 5. Métodos Importantes

## `values()`

Retorna todos os valores:

```java
for (DiaSemana dia : DiaSemana.values()) {
    System.out.println(dia);
}
```

---

## `valueOf(String)`

Converte String → Enum:

```java
DiaSemana dia = DiaSemana.valueOf("DOMINGO");
```

⚠️ Sensível a maiúsculas/minúsculas.

---

# 💻 Código

```java
// ===============================
// ENUM
// ===============================
public enum DiaSemana {

    SEGUNDA("Segunda-feira", 1),
    TERCA("Terça-feira", 2),
    QUARTA("Quarta-feira", 3),
    QUINTA("Quinta-feira", 4),
    SEXTA("Sexta-feira", 5),
    SABADO("Sábado", 6),
    DOMINGO("Domingo", 7);

    private String nomeCompleto;
    private int numero;

    // Construtor
    DiaSemana(String nomeCompleto, int numero) {
        this.nomeCompleto = nomeCompleto;
        this.numero = numero;
    }

    // Getters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public int getNumero() {
        return numero;
    }

    // Regra de negócio
    public boolean isDiaUtil() {
        return this != SABADO && this != DOMINGO;
    }
}
```

---

## 🧪 Classe Principal

```java
public class ExemploEnum {

    public static void main(String[] args) {

        // ===============================
        // USO SIMPLES
        // ===============================
        DiaSemana hoje = DiaSemana.SEXTA;

        System.out.println("Hoje é " + hoje.getNomeCompleto());
        System.out.println("Número do dia: " + hoje.getNumero());
        System.out.println("É dia útil? " + hoje.isDiaUtil());


        // ===============================
        // PERCORRENDO ENUM
        // ===============================
        System.out.println("\nTodos os dias:");

        for (DiaSemana dia : DiaSemana.values()) {
            System.out.println(dia + " - " + dia.getNomeCompleto());
        }


        // ===============================
        // CONVERSÃO STRING → ENUM
        // ===============================
        DiaSemana domingo = DiaSemana.valueOf("DOMINGO");

        System.out.println("\nDia convertido:");
        System.out.println(domingo.getNomeCompleto());


        // ===============================
        // USO EM CONDIÇÕES (SWITCH)
        // ===============================
        switch (hoje) {
            case SEGUNDA:
                System.out.println("Início da semana");
                break;
            case SEXTA:
                System.out.println("Sextou!");
                break;
            default:
                System.out.println("Dia comum");
        }
    }
}
```

---

# 📊 Saída Esperada

```text
Hoje é Sexta-feira
Número do dia: 5
É dia útil? true

Todos os dias:
SEGUNDA - Segunda-feira
TERCA - Terça-feira
...

Dia convertido:
Domingo

Sextou!
```

---

# ⚙️ 6. Casos de Uso Reais

Enums são muito usados em sistemas reais para:

* status de pedidos (`PENDENTE`, `PAGO`, `CANCELADO`)
* tipos de usuário (`ADMIN`, `CLIENTE`)
* níveis de acesso
* estados de máquina
* dias da semana (como no exemplo)

---

# ⚠️ 7. Boas Práticas

✔ Use enums para valores fixos
✔ Evite usar `String` para representar estados
✔ Adicione comportamento (não deixe enum “burro”)
✔ Prefira enums em regras de negócio

---

# 🧠 Insight Importante

Enums no Java são **muito mais que constantes**.

Eles são:

👉 **classes completas, com comportamento e estado**

---

# 📌 Conclusão

Você aprendeu:

✔ Criar enums
✔ Adicionar atributos e métodos
✔ Usar values() e valueOf()
✔ Aplicar lógica dentro do enum

---
