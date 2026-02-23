
# 📘 Aula 23 – Interfaces

## 🎯 Objetivo

* Definir contratos independentes de implementação
* Permitir múltiplas implementações
* Entender `implements`
* Diferenciar interface de classe abstrata
* Compreender `default methods` (Java 8+)

---

# 1️⃣ Conceito Central

Uma interface define:

> O que deve ser feito, mas não como deve ser feito.

Ela representa um **contrato de comportamento**.

---

# 📂 Interface `Imprimivel`

```java
public interface Imprimivel {
    void imprimir(); 
}
```

Características:

* Métodos são implicitamente `public abstract`
* Não possui estado (atributos de instância)
* Não pode ser instanciada
* Define obrigação de implementação

---

# 2️⃣ Implementação com `implements`

## 📂 Classe `Relatorio`

```java
public class Relatorio implements Imprimivel {

    private String texto;

    public Relatorio(String texto) {
        this.texto = texto;
    }

    @Override
    public void imprimir() {
        System.out.println("=== RELATÓRIO ===");
        System.out.println(texto);
    }
}
```

Aqui:

* A classe assina o contrato
* É obrigada a implementar `imprimir()`

---

## 📂 Classe `Grafico`

```java
public class Grafico implements Imprimivel {

    private int[][] dados;

    public Grafico(int[][] dados) {
        this.dados = dados;
    }

    @Override
    public void imprimir() {
        System.out.println("=== GRÁFICO ===");
        for (int[] linha : dados) {
            for (int valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}
```

Mesmo contrato, implementações completamente diferentes.

---

# 3️⃣ Polimorfismo com Interface

```java
Imprimivel r = new Relatorio("Vendas do mês: R$ 10.000");
Imprimivel g = new Grafico(new int[][]{{1,2},{3,4}});
```

Tipo da variável → `Imprimivel`
Tipo real do objeto → `Relatorio` / `Grafico`

Chamada:

```java
r.imprimir();
g.imprimir();
```

Ligação dinâmica ocorre da mesma forma que em herança.

---

# 4️⃣ Fluxo Conceitual

Hierarquia estrutural:

```
Object
   ↑
Relatorio ---- implements ---- Imprimivel
Grafico   ---- implements ---- Imprimivel
```

Observe:

* Interface não entra na cadeia de herança como superclasse concreta.
* Ela define contrato paralelo.

---

# 5️⃣ Classe Abstrata vs Interface

| Classe Abstrata            | Interface                    |
| -------------------------- | ---------------------------- |
| Pode ter estado            | Não possui estado            |
| Pode ter métodos concretos | Apenas contrato (até Java 8) |
| Herança única              | Implementação múltipla       |
| Representa “é-um”          | Representa “é-capaz-de”      |

Exemplo semântico:

* `ContaEspecial` é uma `Conta` → herança
* `Relatorio` é imprimível → interface

Interface modela capacidade, não identidade.

---

# 6️⃣ Múltiplas Interfaces

Java não permite herança múltipla de classes, mas permite:

```java
public class Documento implements Imprimivel, Serializable, Comparable<Documento>
```

Isso é fundamental para arquitetura desacoplada.

---

# 7️⃣ Métodos `default` (Java 8+)

Desde Java 8, interfaces podem ter implementação padrão:

```java
public interface Imprimivel {

    void imprimir();

    default void imprimirCabecalho() {
        System.out.println("Sistema de Impressão");
    }
}
```

Isso permite:

* Evoluir interfaces sem quebrar implementações antigas
* Fornecer comportamento padrão reutilizável

---

# 8️⃣ Benefício Arquitetural Real

Com interface, você pode escrever código totalmente desacoplado:

```java
public static void imprimirDocumento(Imprimivel item) {
    item.imprimir();
}
```

Sem depender de:

* Relatorio
* Grafico
* Futuras implementações

Isso é base para:

* Inversão de Dependência (SOLID)
* Arquitetura limpa
* Testabilidade (mocks)
