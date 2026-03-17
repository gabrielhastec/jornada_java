
# 📘 Aula 27 – Generics

## 🎯 Objetivo

Permitir a criação de **classes, interfaces e métodos parametrizados por tipo**, garantindo:

* ✔ **Type safety (segurança de tipo)**
* ✔ **Reutilização de código**
* ✔ **Eliminação de casts desnecessários**

---

# 🧠 1. O problema antes dos Generics

Antes do Java 5, coleções trabalhavam com `Object`:

```java
List lista = new ArrayList();
lista.add("Texto");

String valor = (String) lista.get(0); // cast obrigatório
```

⚠️ Problemas:

* risco de `ClassCastException`
* código menos legível
* erros só aparecem em runtime

---

# ✅ 2. O que são Generics

Generics permitem definir um **tipo como parâmetro**:

```java
List<String> lista = new ArrayList<>();
```

Agora:

* não precisa de cast
* erro acontece em **tempo de compilação**

---

# 📦 3. Classe Genérica

## Estrutura básica

```java
public class Caixa<T> {
    private T conteudo;

    public void colocar(T conteudo) {
        this.conteudo = conteudo;
    }

    public T retirar() {
        return conteudo;
    }
}
```

---

## Uso

```java
Caixa<String> caixaString = new Caixa<>();
caixaString.colocar("Olá");

String valor = caixaString.retirar();
```

Outro tipo:

```java
Caixa<Integer> caixaInt = new Caixa<>();
caixaInt.colocar(123);
```

---

# 🔧 4. Métodos Genéricos

Você pode criar métodos que funcionam com qualquer tipo.

```java
public class Util {

    public static <T> T getUltimoElemento(List<T> lista) {
        if (lista.isEmpty()) return null;
        return lista.get(lista.size() - 1);
    }
}
```

---

## Uso

```java
List<Double> numeros = Arrays.asList(1.1, 2.2, 3.3);

Double ultimo = Util.getUltimoElemento(numeros);
System.out.println(ultimo);
```

---

# 🧩 5. Wildcards (Curingas)

Wildcards são usados quando **não sabemos exatamente o tipo**.

---

## `?` (qualquer tipo)

```java
public static void imprimirLista(List<?> lista) {
    for (Object obj : lista) {
        System.out.println(obj);
    }
}
```

✔ Aceita qualquer lista
❌ Não permite adicionar elementos (exceto `null`)

---

## `? extends T` (limite superior)

Aceita `T` ou subclasses de `T`.

```java
public static double somarNumeros(List<? extends Number> lista) {
    double soma = 0;

    for (Number n : lista) {
        soma += n.doubleValue();
    }

    return soma;
}
```

✔ Pode **ler**
❌ Não pode adicionar

---

## `? super T` (limite inferior)

Aceita `T` ou superclasses de `T`.

```java
public static void adicionarInteiros(List<? super Integer> lista) {
    lista.add(10);
    lista.add(20);
}
```

✔ Pode **adicionar**
❌ Leitura é limitada (Object)

---

# ⚠️ Regra importante (PECS)

**P**roducer → `extends`
**C**onsumer → `super`

👉 *"Producer Extends, Consumer Super"*

---

# ⚠️ 6. Limitações dos Generics

## ❌ Não funciona com tipos primitivos

```java
List<int> lista; // ERRO
```

✔ Use wrapper:

```java
List<Integer> lista;
```

---

## ❌ Não pode instanciar tipo genérico diretamente

```java
T obj = new T(); // ERRO
```

---

## ❌ Type Erasure

Em tempo de execução, o Java remove o tipo genérico.

```java
List<String> -> List
```

Isso significa:

* não há reflexão direta de tipos genéricos
* compatibilidade com versões antigas

---

# 💡 7. Boas Práticas

✔ Use nomes padrão:

| Tipo          | Convenção |
| ------------- | --------- |
| Tipo genérico | `T`       |
| Número        | `N`       |
| Chave         | `K`       |
| Valor         | `V`       |

---

✔ Prefira generics sempre:

```java
List<Usuario> usuarios = new ArrayList<>();
```

---

✔ Evite raw types:

```java
List lista = new ArrayList(); // ruim
```

---

# 💻 Código Completo Profissional

```java
import java.util.*;

// ===============================
// CLASSE GENÉRICA
// ===============================
class Caixa<T> {
    private T conteudo;

    public void colocar(T conteudo) {
        this.conteudo = conteudo;
    }

    public T retirar() {
        return conteudo;
    }
}

// ===============================
// UTILITÁRIOS GENÉRICOS
// ===============================
class Util {

    public static <T> T getUltimoElemento(List<T> lista) {
        if (lista == null || lista.isEmpty()) return null;
        return lista.get(lista.size() - 1);
    }

    public static void imprimirLista(List<?> lista) {
        for (Object obj : lista) {
            System.out.println(obj);
        }
    }

    public static double somarNumeros(List<? extends Number> lista) {
        double soma = 0;
        for (Number n : lista) {
            soma += n.doubleValue();
        }
        return soma;
    }

    public static void adicionarInteiros(List<? super Integer> lista) {
        lista.add(10);
        lista.add(20);
    }
}

// ===============================
// MAIN
// ===============================
public class ExemploGenerics {

    public static void main(String[] args) {

        // ===============================
        // CAIXA GENÉRICA
        // ===============================
        Caixa<String> caixaString = new Caixa<>();
        caixaString.colocar("Olá Generics");
        System.out.println("Caixa String: " + caixaString.retirar());

        Caixa<Integer> caixaInt = new Caixa<>();
        caixaInt.colocar(123);
        System.out.println("Caixa Integer: " + caixaInt.retirar());


        // ===============================
        // MÉTODO GENÉRICO
        // ===============================
        List<Double> lista = Arrays.asList(1.1, 2.2, 3.3);

        Double ultimo = Util.getUltimoElemento(lista);
        System.out.println("Último elemento: " + ultimo);


        // ===============================
        // WILDCARDS
        // ===============================
        Util.imprimirLista(lista);

        double soma = Util.somarNumeros(lista);
        System.out.println("Soma: " + soma);


        List<Number> numeros = new ArrayList<>();
        Util.adicionarInteiros(numeros);
        System.out.println("Após adicionar: " + numeros);
    }
}
```

---

# 📊 Saída Esperada

```text
Caixa String: Olá Generics
Caixa Integer: 123
Último elemento: 3.3

1.1
2.2
3.3

Soma: 6.6
Após adicionar: [10, 20]
```

---

# 📌 Conclusão

Generics são essenciais porque:

* evitam erros em runtime
* aumentam reutilização
* deixam o código mais limpo e seguro

👉 Na prática, você vai usar Generics principalmente com:

```java
List<Usuario>
Map<String, Produto>
Set<Integer>
```

---
