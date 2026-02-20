
# 📘 Aula 17 – Classes e Objetos

## 🎯 Objetivo

* ✅ Entender o que é uma **classe**
* ✅ Entender o que é um **objeto**
* ✅ Declarar **atributos**
* ✅ Declarar **métodos**
* ✅ Criar objetos com `new`
* ✅ Acessar membros com o operador `.`

---

# 🧠 Conceito Fundamental

## 🔹 Classe

Uma **classe** é um molde (modelo) que define:

* Características → **atributos**
* Comportamentos → **métodos**

Exemplo conceitual:

> Classe = Planta de uma casa
> Objeto = Casa construída a partir da planta

---

## 🔹 Objeto

Um **objeto** é uma instância concreta da classe.

Cada objeto possui:

* Seus próprios valores de atributos
* Acesso aos métodos definidos na classe

---

# 🏗 Estrutura de uma Classe

```java
public class NomeClasse {

    // atributos
    tipo nomeAtributo;

    // métodos
    tipoRetorno nomeMetodo() {
    }
}
```

---

# 📂 Arquivo: `ContaBancaria.java`

```java
public class ContaBancaria {

    // Atributos (variáveis de instância)
    String titular;
    int numero;
    double saldo;

    // Método
    void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor +
                " realizado. Saldo atual: R$" + saldo);
    }

    void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor +
                    " realizado. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    void exibirInfo() {
        System.out.println("Titular: " + titular +
                " | Conta: " + numero +
                " | Saldo: R$" + saldo);
    }
}
```

---

# 📂 Arquivo: `Main.java`

```java
public class Main {

    public static void main(String[] args) {

        // Criando objeto (instância)
        ContaBancaria conta1 = new ContaBancaria();

        conta1.titular = "João";
        conta1.numero = 123;
        conta1.saldo = 1000.0;

        conta1.exibirInfo();
        conta1.depositar(500);
        conta1.sacar(200);
        conta1.sacar(2000);
    }
}
```

---

# 🔍 Análise Técnica

## 🔹 Instanciação

```java
ContaBancaria conta1 = new ContaBancaria();
```

* `ContaBancaria` → tipo
* `conta1` → referência
* `new` → cria o objeto na memória (heap)
* `()` → chama o construtor padrão

---

## 🔹 Acesso a membros (`.`)

```java
conta1.titular = "João";
conta1.depositar(500);
```

O operador `.` acessa:

* Atributos
* Métodos

---

# 🧩 Conceitos Importantes

## 🔹 Atributos

Também chamados de:

* Variáveis de instância
* Estado do objeto

Cada objeto possui seus próprios valores.

---

## 🔹 Métodos

Representam comportamentos.

Podem:

* Alterar atributos
* Executar regras
* Retornar valores

---

# 🔬 Modelo Mental de Memória

```
Stack:
conta1 → referência

Heap:
Objeto ContaBancaria
  titular = "João"
  numero = 123
  saldo = 1000.0
```

---

# ⚠️ Observação Importante

Nesta aula os atributos estão públicos (acessíveis diretamente).
Isso é didático.

Em código profissional usamos:

* `private`
* Encapsulamento
* Getters e Setters

Isso será visto nas próximas aulas.

---

# 📊 Saída Esperada

```
Titular: João | Conta: 123 | Saldo: R$1000.0
Depósito de R$500 realizado. Saldo atual: R$1500.0
Saque de R$200 realizado. Saldo atual: R$1300.0
Saldo insuficiente.
```

---

# 🚀 O que Você Acabou de Aprender

Você agora entende:

* O que é classe
* O que é objeto
* Instanciação
* Atributos
* Métodos
* Referências
* Operador `.`

Você entrou oficialmente na POO.
