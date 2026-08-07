
# 📘 Aula 21 – Herança

## 🎯 Objetivo

* Reutilizar código com `extends`
* Acessar membros da superclasse com `super`
* Aplicar sobrescrita com `@Override`
* Entender a hierarquia iniciando em `Object`

---

# 🧠 Conceito Fundamental

Herança representa:

> Uma classe especializada que **é um tipo mais específico** de outra.

Exemplo do domínio bancário:

* `ContaEspecial` **é uma** `Conta`
* Logo, pode reutilizar seus comportamentos e especializá-los

---

# 🔹 Palavra-chave `extends`

```java
public class ContaEspecial extends Conta
```

Significa:

* `ContaEspecial` herda atributos e métodos públicos/protegidos de `Conta`.

---

# 📂 Classe `Conta` (Superclasse)

```java
public class Conta {

    protected String titular;
    protected double saldo;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void exibirSaldo() {
        System.out.println("Titular: " + titular + " | Saldo: R$" + saldo);
    }
}
```

### 🔎 Observação técnica

Os atributos são `protected`.

Isso permite:

* Acesso direto na subclasse
* Não acesso externo (fora da hierarquia)

Em sistemas reais, preferimos `private` + getters/setters (melhor encapsulamento).

---

# 📂 Classe `ContaEspecial` (Subclasse)

```java
public class ContaEspecial extends Conta {

    private double limite;

    public ContaEspecial(String titular, double saldoInicial, double limite) {
        super(titular, saldoInicial); // chama o construtor da superclasse
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
        } else {
            System.out.println("Limite insuficiente.");
        }
    }

    public double getLimite() {
        return limite;
    }
}
```

---

# 🧩 Palavra-chave `super`

```java
super(titular, saldoInicial);
```

Ela:

* Chama o construtor da classe pai
* Deve ser a primeira linha do construtor
* Garante inicialização correta da parte herdada

---

# 🔁 Sobrescrita (Override)

```java
@Override
public void sacar(double valor)
```

Sobrescrever significa:

> Reimplementar um método herdado mantendo a mesma assinatura.

Regras:

* Mesmo nome
* Mesma lista de parâmetros
* Mesmo tipo de retorno
* Não pode reduzir visibilidade

`@Override` não é obrigatório, mas é altamente recomendado — o compilador valida a assinatura.

---

# 📂 Classe `Main`

```java
public class Main {

    public static void main(String[] args) {

        Conta c = new Conta("João", 1000);
        c.sacar(1100); // saldo insuficiente

        ContaEspecial ce = new ContaEspecial("Maria", 1000, 500);
        ce.sacar(1200); // usa o limite
        ce.exibirSaldo();
    }
}
```

Saída esperada:

```
Saldo insuficiente.
Titular: Maria | Saldo: R$-200.0
```

---

# 🧠 O Que Está Acontecendo Conceitualmente?

### Estrutura hierárquica:

```
Object
   ↓
Conta
   ↓
ContaEspecial
```

Toda classe em Java herda implicitamente de `Object`.

Exemplos de métodos herdados de `Object`:

* `toString()`
* `equals()`
* `hashCode()`
* `getClass()`

---

# ⚙️ Herança vs Composição

Você acabou de estudar ambos.

| Herança           | Composição        |
| ----------------- | ----------------- |
| É-um              | Tem-um            |
| Especialização    | Agregação         |
| Mais rígida       | Mais flexível     |
| Forte acoplamento | Baixo acoplamento |

Boa prática arquitetural:

> Use herança apenas quando houver relação semântica clara de especialização.

---

# 🔎 Análise Arquitetural do Exemplo

`ContaEspecial` altera a regra de saque.

Isso é legítimo porque:

* Continua sendo uma conta
* Apenas amplia a regra de saldo

Mas cuidado:

Se subclasses começarem a modificar demais o comportamento da superclasse, pode haver violação do **Princípio da Substituição de Liskov (LSP)**.
