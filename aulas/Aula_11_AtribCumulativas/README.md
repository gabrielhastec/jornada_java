
# 📘 Aula 11 – Atribuições Cumulativas

## 🎯 Objetivos

Nesta aula você aprenderá a:

* ✅ Simplificar atualizações de variáveis
* ✅ Utilizar operadores cumulativos (`+=`, `-=`, `*=`, `/=`)
* ✅ Aplicar esses operadores em regras reais
* ✅ Entender a equivalência semântica entre formas longas e curtas

---

# 🧠 Conceito Fundamental

Operadores de atribuição cumulativa permitem atualizar uma variável usando seu próprio valor atual.

Forma tradicional:

```java
a = a + b;
```

Forma simplificada:

```java
a += b;
```

Ambas produzem o mesmo resultado.

---

# 🔹 Operadores Disponíveis

| Operador | Equivalente |
| -------- | ----------- |
| `+=`     | `a = a + b` |
| `-=`     | `a = a - b` |
| `*=`     | `a = a * b` |
| `/=`     | `a = a / b` |
| `%=`     | `a = a % b` |

---

# 🔍 Por que usar?

✔ Código mais limpo
✔ Menos repetição de variável
✔ Mais legibilidade
✔ Padrão usado profissionalmente

---

# 💻 Exemplo Prático – Conta Telefônica

### 📌 Regra

* Plano base: R$ 50,00
* Até 100 minutos: incluso
* Cada minuto excedente: R$ 2,00

---

## Código da Aula

```java
import java.util.Scanner;

public class atribCumulativas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int minutos = sc.nextInt();
        double conta = 50.0;

        if (minutos > 100) {
            conta += (minutos - 100) * 2.0; // atribuição cumulativa
        }

        System.out.printf("Valor a pagar: R$ %.2f%n", conta);

        sc.close();
    }
}
```

---

# 🧩 Análise Técnica

Trecho principal:

```java
conta += (minutos - 100) * 2.0;
```

Equivalente a:

```java
conta = conta + (minutos - 100) * 2.0;
```

### Fluxo lógico:

1. Calcula os minutos excedentes
2. Multiplica pelo valor por minuto
3. Soma ao valor base
4. Atualiza `conta`

---

# 📊 Exemplo de Execução

### Entrada:

```
120
```

### Cálculo:

```
Excedente = 120 - 100 = 20
Adicional = 20 * 2 = 40
Total = 50 + 40 = 90
```

### Saída:

```
Valor a pagar: R$ 90.00
```

---

# ⚠️ Cuidados Importantes

## 🔹 1. Tipos Compatíveis

Operadores cumulativos respeitam conversão implícita de tipos.

Exemplo válido:

```java
double total = 10;
total += 2; // ok
```

Mas cuidado com divisão inteira:

```java
int x = 5;
x /= 2;  // resultado = 2 (não 2.5)
```

Porque é divisão inteira.

---

## 🔹 2. Evitar Ambiguidade

Prefira clareza:

```java
saldo -= taxa;
```

É mais expressivo que:

```java
saldo = saldo - taxa;
```

---

# 🔄 Integração com Aulas Anteriores

Essa aula combina:

* Variáveis (Aula 03)
* Operadores aritméticos (Aula 07)
* Expressões lógicas (Aula 09)
* Condicionais (Aula 10)
* Entrada de dados (`Scanner`)

Você já está combinando múltiplos conceitos.

---

# 🚀 Próximo Passo Natural

Agora você tem ferramentas para:

* Criar acumuladores
* Trabalhar com contadores
* Preparar terreno para laços (`while`, `for`)

A progressão lógica será:

1. 🔁 Estrutura de repetição `while`
2. 🔁 Estrutura de repetição `for`
3. 🧮 Operadores de incremento (`++` e `--`)
4. 📊 Exercícios integrando tudo
