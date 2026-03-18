
# 📘 Aula 28 – Tratamento de Exceções

## 🎯 Objetivo

Lidar com erros em tempo de execução de forma **controlada e previsível**, evitando:

* falhas inesperadas
* encerramento abrupto da aplicação
* comportamento inconsistente

---

# 🧠 1. O que são exceções

Exceções são **eventos que interrompem o fluxo normal do programa**.

Exemplos comuns:

* divisão por zero
* acesso inválido a índice
* entrada inválida do usuário
* falhas de I/O

---

# 🌳 2. Hierarquia de Exceções

```text
Throwable
 ├── Error (problemas graves - não tratáveis)
 └── Exception
      ├── RuntimeException (unchecked)
      └── outras exceções (checked)
```

---

## Tipos principais

### 🔴 Checked Exceptions

* verificadas em tempo de compilação
* obrigam tratamento

Exemplo:

```java
IOException
SQLException
```

---

### 🟡 Unchecked Exceptions (Runtime)

* ocorrem em tempo de execução
* não obrigam tratamento

Exemplo:

```java
NullPointerException
ArithmeticException
IndexOutOfBoundsException
```

---

# 🧩 3. try, catch, finally

## Estrutura básica

```java
try {
    // código que pode gerar erro
} catch (TipoException e) {
    // tratamento
} finally {
    // sempre executa (opcional)
}
```

---

## Exemplo

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Erro: divisão por zero");
} finally {
    System.out.println("Finalizando operação");
}
```

---

# 🔀 4. Múltiplos catch e Multi-catch

## Múltiplos catches

```java
try {
    // código
} catch (ArithmeticException e) {
    System.out.println("Erro matemático");
} catch (NullPointerException e) {
    System.out.println("Objeto nulo");
}
```

---

## Multi-catch (Java 7+)

```java
try {
    // código
} catch (ArithmeticException | NullPointerException e) {
    System.out.println("Erro geral");
}
```

---

# 🚀 5. throw e throws

## 🔹 throw (lançar exceção manualmente)

```java
if (idade < 0) {
    throw new IllegalArgumentException("Idade inválida");
}
```

---

## 🔹 throws (propagar exceção)

```java
public static void lerArquivo() throws IOException {
    // código que pode lançar IOException
}
```

---

# 🏗️ 6. Criando Exceções Customizadas

Permite representar **regras de negócio específicas**.

---

## Exemplo

```java
class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
```

---

## Uso

```java
public static void sacar(double saldo, double valor) throws SaldoInsuficienteException {
    if (valor > saldo) {
        throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
    }
}
```

---

# 💻 Código

```java
import java.util.InputMismatchException;
import java.util.Scanner;

// ===============================
// EXCEÇÃO CUSTOMIZADA
// ===============================
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

// ===============================
// CLASSE DE NEGÓCIO
// ===============================
class ContaBancaria {

    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

// ===============================
// MAIN
// ===============================
public class ExemploExcecoes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===============================
        // ENTRADA DO USUÁRIO
        // ===============================
        try {
            System.out.print("Digite um número: ");
            int numero = sc.nextInt();
            System.out.println("Você digitou: " + numero);

        } catch (InputMismatchException e) {
            System.out.println("Erro: valor inválido (não é inteiro).");

        } finally {
            System.out.println("Finalizando leitura.");
            sc.close();
        }


        // ===============================
        // EXCEÇÃO DE RUNTIME
        // ===============================
        try {
            int resultado = dividir(10, 0);
            System.out.println(resultado);

        } catch (ArithmeticException e) {
            System.out.println("Erro ao dividir: " + e.getMessage());
        }


        // ===============================
        // EXCEÇÃO CUSTOMIZADA
        // ===============================
        ContaBancaria conta = new ContaBancaria(500);

        try {
            conta.sacar(600);

        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Saldo atual: " + conta.getSaldo());
    }


    // ===============================
    // MÉTODO COM EXCEÇÃO
    // ===============================
    public static int dividir(int a, int b) {
        return a / b;
    }
}
```

---

# 📊 Saída Esperada (exemplo)

```text
Digite um número: abc
Erro: valor inválido (não é inteiro).
Finalizando leitura.

Erro ao dividir: / by zero

Erro: Saldo insuficiente.
Saldo atual: 500.0
```

---

# ⚠️ 7. Boas Práticas

✔ Capture exceções específicas (evite `Exception` genérico)

```java
catch (IOException e) { }
```

---

✔ Nunca ignore exceções

```java
catch (Exception e) {
    e.printStackTrace();
}
```

---

✔ Use exceções para fluxo **excepcional**, não lógica comum

❌ errado:

```java
try {
    lista.get(10);
} catch (Exception e) {}
```

---

✔ Crie exceções customizadas para regras de negócio

---

✔ Sempre feche recursos (ou use `try-with-resources`)

```java
try (Scanner sc = new Scanner(System.in)) {
    // uso
}
```

---

# 📌 Conclusão

Tratamento de exceções permite:

* tornar o sistema resiliente
* melhorar a experiência do usuário
* facilitar debugging

---
