
# 📘 Aula 20 – Composição de Objetos

## 🎯 Objetivo

* Modelar relacionamentos **tem-um**
* Criar atributos que são **referências a outros objetos**
* Entender dependência entre classes
* Produzir modelagem mais realista

---

# 🧠 Conceito Central

Composição ocorre quando:

> Uma classe possui outra classe como atributo.

Exemplo real:

* Um **Funcionário tem um Departamento**
* Um **Pedido tem um Cliente**
* Um **Carro tem um Motor**

Isso é modelagem de domínio.

---

# 📂 Classe `Departamento`

```java
public class Departamento {

    private String nome;

    public Departamento(String nome) {
        this.nome = nome;
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }
}
```

Classe simples que representa uma entidade independente.

---

# 📂 Classe `Funcionario`

```java
public class Funcionario {

    private String nome;
    private Departamento departamento; // composição

    public Funcionario(String nome, Departamento departamento) {
        this.nome = nome;
        this.departamento = departamento;
    }

    public void exibirInfo() {
        System.out.println(
            "Funcionário: " + nome +
            ", Departamento: " + departamento.getNome()
        );
    }
}
```

Aqui está a composição:

```java
private Departamento departamento;
```

O atributo **não é primitivo** — é uma referência para outro objeto.

---

# 📂 Classe `Main`

```java
public class Main {

    public static void main(String[] args) {

        Departamento dept = new Departamento("TI");

        Funcionario func = new Funcionario("Ana", dept);

        func.exibirInfo();
    }
}
```

---

# 🔎 Fluxo de Execução

1. Cria-se um objeto `Departamento`
2. Esse objeto é passado ao criar o `Funcionario`
3. O funcionário passa a “ter um” departamento
4. `exibirInfo()` acessa o objeto interno

Saída:

```
Funcionário: Ana, Departamento: TI
```

---

# 🧩 Análise Técnica

## 🔹 O que está acontecendo na memória?

`Funcionario` não copia o departamento.

Ele guarda uma **referência** ao mesmo objeto:

```
Funcionario ----> Departamento
```

Se você alterar o departamento:

```java
dept.setNome("RH");
```

O funcionário refletirá essa mudança automaticamente.

---

# 🧠 Composição vs Herança

| Composição                     | Herança             |
| ------------------------------ | ------------------- |
| Tem-um                         | É-um                |
| Mais flexível                  | Mais rígida         |
| Baixo acoplamento              | Alto acoplamento    |
| Preferida na maioria dos casos | Uso mais específico |

Princípio importante:

> “Prefira composição à herança.”

---

# 🏗 Modelagem Realista

Sistema empresarial real:

* Empresa tem Departamentos
* Departamento tem Funcionários
* Funcionário tem Endereço
* Pedido tem Itens
* Item tem Produto

Composição permite montar estruturas complexas de forma modular.

---

# ⚙️ Vantagens

✔ Organização clara do domínio
✔ Reuso de classes
✔ Baixo acoplamento
✔ Fácil manutenção
✔ Maior flexibilidade

---

# 🧠 Evolução Conceitual

Você já viu:

1. Classe e objeto
2. Encapsulamento
3. Construtores e sobrecarga
4. Composição
