
# 📘 Aula 19 – Construtores e Sobrecarga

## 🎯 Objetivos

* Garantir **estado válido no momento da criação**
* Utilizar corretamente a palavra-chave `this`
* Aplicar **sobrecarga** (overloading) em construtores e métodos
* Entender o conceito de **assinatura de método**

---

# 🧠 1. Construtores

## 📌 Definição

Construtor é um método especial que:

* Possui **mesmo nome da classe**
* **Não possui tipo de retorno**
* É executado automaticamente ao usar `new`

```java
Funcionario f = new Funcionario();
```

---

## 🔹 Construtor Padrão

```java
public Funcionario() {
    this.nome = "Sem nome";
    this.cargo = "Não definido";
    this.salario = 0.0;
}
```

Garante que o objeto nunca seja criado com atributos nulos ou lixo de memória.

---

## 🔹 Construtor Parametrizado

```java
public Funcionario(String nome, String cargo) {
    this.nome = nome;
    this.cargo = cargo;
    this.salario = 0.0;
}
```

Permite obrigar informações essenciais na criação.

---

## 🔹 Construtor Completo

```java
public Funcionario(String nome, String cargo, double salario) {
    this.nome = nome;
    this.cargo = cargo;
    this.salario = salario;
}
```

Entrega total controle ao chamador.

---

# 🧩 Palavra-chave `this`

## 📌 Funções principais:

### 1️⃣ Referenciar o atributo do objeto atual

```java
this.salario = salario;
```

Diferencia:

* `this.salario` → atributo
* `salario` → parâmetro

---

### 2️⃣ (Avançado) Chamar outro construtor

Não foi usado no exemplo, mas poderia ser:

```java
public Funcionario(String nome, String cargo) {
    this(nome, cargo, 0.0);
}
```

Isso evita repetição de código.

---

# 🔁 2. Sobrecarga (Overloading)

## 📌 Conceito

Sobrecarga ocorre quando:

* Métodos têm **mesmo nome**
* Mas **assinaturas diferentes**

### Assinatura = nome + lista de parâmetros

O retorno **não faz parte** da assinatura.

---

## 🔹 Sobrecarga de Construtores

```java
Funcionario()
Funcionario(String, String)
Funcionario(String, String, double)
```

Mesmo nome, parâmetros diferentes.

---

## 🔹 Sobrecarga de Métodos

```java
public void aumentarSalario(double percentual)
public void aumentarSalario(double valorFixo, boolean fixo)
```

O compilador decide qual método chamar com base na assinatura.

---

# 📂 Classe `Funcionario`

```java
public class Funcionario {

    private String nome;
    private String cargo;
    private double salario;

    public Funcionario() {
        this.nome = "Sem nome";
        this.cargo = "Não definido";
        this.salario = 0.0;
    }

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = 0.0;
    }

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void aumentarSalario(double percentual) {
        this.salario += this.salario * percentual / 100;
    }

    public void aumentarSalario(double valorFixo, boolean fixo) {
        this.salario += valorFixo;
    }

    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public double getSalario() { return salario; }

    public void exibirInfo() {
        System.out.printf(
            "Funcionário: %s | Cargo: %s | Salário: R$%.2f%n",
            nome, cargo, salario
        );
    }
}
```

---

# 📂 Classe `Main`

```java
public class Main {

    public static void main(String[] args) {

        Funcionario f1 = new Funcionario();
        Funcionario f2 = new Funcionario("Maria", "Analista");
        Funcionario f3 = new Funcionario("João", "Gerente", 5000.0);

        f1.exibirInfo();
        f2.exibirInfo();
        f3.exibirInfo();

        f3.aumentarSalario(10.0);        // percentual
        f3.exibirInfo();

        f3.aumentarSalario(300.0, true); // valor fixo
        f3.exibirInfo();
    }
}
```

---

# 📊 Saída Esperada (parcial)

```
Funcionário: João | Cargo: Gerente | Salário: R$5000.00
Funcionário: João | Cargo: Gerente | Salário: R$5500.00
Funcionário: João | Cargo: Gerente | Salário: R$5800.00
```

---

# ⚙️ Observação Técnica Importante

O uso de:

```java
public void aumentarSalario(double valorFixo, boolean fixo)
```

Apenas para diferenciar assinatura não é elegante.

Alternativa mais limpa:

```java
public void aumentarSalarioValorFixo(double valor)
```

Sobrecarga deve representar **variações conceituais reais**, não apenas diferenças artificiais.

---

# 🧠 Benefícios de Construtores

✔ Estado inicial consistente
✔ Imutabilidade parcial possível
✔ Redução de erros
✔ Modelagem mais profissional

---

# 📌 Benefícios da Sobrecarga

✔ API mais flexível
✔ Melhor legibilidade
✔ Polimorfismo em tempo de compilação
✔ Código mais expressivo
