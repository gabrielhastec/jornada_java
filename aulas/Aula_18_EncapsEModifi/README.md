
# 📘 Aula 18 – Encapsulamento e Modificadores de Acesso

## 🎯 Objetivo

* ✅ Controlar acesso aos atributos
* ✅ Utilizar `private`
* ✅ Criar `getters` e `setters`
* ✅ Entender modificadores de acesso
* ✅ Aplicar validações internas
* ✅ Garantir integridade do objeto

---

# 🧠 Conceito Fundamental

Encapsulamento significa:

> Esconder os detalhes internos e permitir acesso controlado.

Em vez de permitir acesso direto aos atributos:

```java
produto.preco = -100;
```

Você protege com:

```java
private double preco;
```

E controla via métodos.

---

# 🔐 Modificadores de Acesso

| Modificador       | Acesso                                    |
| ----------------- | ----------------------------------------- |
| `public`          | Acessível de qualquer lugar               |
| `private`         | Acessível apenas dentro da própria classe |
| `protected`       | Mesmo pacote + subclasses                 |
| (sem modificador) | Apenas dentro do mesmo pacote             |

---

# 📂 Arquivo: `Produto.java`

```java
public class Produto {

    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido. Atribuído 0.0");
            this.preco = 0.0;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade inválida. Atribuído 0");
            this.quantidade = 0;
        }
    }

    public double valorEstoque() {
        return preco * quantidade;
    }
}
```

---

# 📂 Arquivo: `Main.java`

```java
public class Main {

    public static void main(String[] args) {

        Produto p = new Produto("Notebook", 2500.0, 10);

        System.out.println("Produto: " + p.getNome());
        System.out.println("Preço: R$" + p.getPreco());
        System.out.println("Quantidade: " + p.getQuantidade());
        System.out.println("Valor em estoque: R$" + p.valorEstoque());

        p.setPreco(-500);
        p.setQuantidade(-5);
    }
}
```

---

# 🔍 Análise Técnica

## 🔹 `private`

Impede acesso direto:

```java
p.preco = 100; // ERRO de compilação
```

Força o uso de métodos controlados.

---

## 🔹 Getters

Permitem leitura:

```java
public double getPreco() {
    return preco;
}
```

---

## 🔹 Setters

Permitem escrita controlada:

```java
public void setPreco(double preco) {
    if (preco >= 0) {
        this.preco = preco;
    }
}
```

Aqui aplicamos **validação de regra de negócio**.

---

## 🔹 Palavra-chave `this`

```java
this.preco = preco;
```

Diferencia:

* Atributo da classe (`this.preco`)
* Parâmetro do método (`preco`)

---

# 🧩 Benefícios do Encapsulamento

### ✅ Validação de dados

Evita estados inválidos.

### ✅ Manutenção

Mudanças internas não afetam código externo.

### ✅ Segurança

Protege atributos sensíveis.

### ✅ Organização

Centraliza regras dentro da própria classe.

---

# 📊 Saída Esperada

```
Produto: Notebook
Preço: R$2500.0
Quantidade: 10
Valor em estoque: R$25000.0
Preço inválido. Atribuído 0.0
Quantidade inválida. Atribuído 0
```

---

# 🧠 Evolução Conceitual

Sem encapsulamento:

```
Objeto vulnerável
```

Com encapsulamento:

```
Objeto consistente e protegido
```

Você está começando a escrever código com padrão profissional.
