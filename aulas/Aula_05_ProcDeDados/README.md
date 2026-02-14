
# 📘 Aula 05 – Processamento de Dados e Casting

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Trabalhar com expressões aritméticas envolvendo variáveis
* ✅ Entender a ordem de avaliação das expressões
* ✅ Compreender conversão automática de tipos (promoção)
* ✅ Realizar conversão explícita (casting)
* ✅ Resolver um problema matemático aplicado (área de trapézio)

Essa aula marca a transição do uso simples de variáveis para **processamento real de dados**.

---

# 🧠 Conceitos Fundamentais

## 🔹 1. Expressões Aritméticas

Uma expressão aritmética combina:

* Variáveis
* Operadores
* Valores

Exemplo:

```java
int x2 = 2 * x1;
```

O Java avalia primeiro a multiplicação e depois realiza a atribuição.

---

## 🔹 2. Ordem de Avaliação (Precedência)

Java segue a precedência matemática padrão:

1. Parênteses `()`
2. Multiplicação e divisão `* /`
3. Soma e subtração `+ -`

Exemplo:

```java
double area = (b + B) / 2.0 * h;
```

Passo a passo:

1. Resolve `(b + B)`
2. Divide por `2.0`
3. Multiplica por `h`

---

# 🔹 3. Conversão de Tipos (Casting)

## 📌 Conversão Automática (Promoção)

Ocorre quando o Java converte automaticamente um tipo menor para um tipo maior.

Exemplo:

```java
int numero = 5;
double valor = numero;
```

O `int` é promovido automaticamente para `double`.

Hierarquia simplificada:

```
int → long → float → double
```

---

## 📌 Conversão Explícita (Cast)

Quando queremos converter manualmente, utilizamos:

```java
(tipo) valor
```

Exemplo:

```java
double resultado = (double) a1 / a2;
```

Aqui estamos forçando `a1` a se tornar `double` antes da divisão.

---

# ⚠️ Por que o Casting é Necessário?

Sem casting:

```java
int a1 = 5;
int a2 = 2;

double resultado = a1 / a2;
```

Resultado:

```
2.0
```

Porque a divisão ocorre entre dois `int`, gerando resultado inteiro.

Com casting:

```java
double resultado = (double) a1 / a2;
```

Resultado:

```
2.5
```

Agora a divisão ocorre em ponto flutuante.

---

# 📐 Exemplo Aplicado – Área de Trapézio

Fórmula matemática:

```
Área = (Base menor + Base maior) × Altura / 2
```

Implementação:

```java
double area = (b + B) / 2.0 * h;
```

Observação importante:

Usamos `2.0` (double) para garantir que a divisão seja decimal.

---

# 💻 Código da Aula

```java
public class procDeDados {
    public static void main(String[] args) {

        int x1 = 10;
        int x2 = 2 * x1;

        System.out.println(x1);
        System.out.println(x2);

        double b = 6.0, B = 8.0, h = 5.0;
        double area = (b + B) / 2.0 * h;

        System.out.println(area);

        int a1 = 5, a2 = 2;
        double resultado = (double) a1 / a2;

        System.out.println(resultado);
    }
}
```

---

# 🧩 Análise Técnica do Código

### 🔹 Parte 1 – Expressão simples

```java
int x2 = 2 * x1;
```

* Avaliação da multiplicação
* Resultado armazenado em `x2`

---

### 🔹 Parte 2 – Cálculo matemático

```java
double area = (b + B) / 2.0 * h;
```

Uso correto de:

* Parênteses
* Tipo `double`
* Ordem de precedência

---

### 🔹 Parte 3 – Casting

```java
(double) a1
```

* Força a conversão antes da divisão
* Evita perda de precisão

---

# ⚠️ Erros Comuns

❌ Esquecer de usar `2.0` em vez de `2`
❌ Achar que atribuir a `double` automaticamente resolve divisão inteira
❌ Fazer cast depois da divisão

Errado:

```java
double resultado = (double)(a1 / a2);
```

Aqui o erro permanece, pois a divisão já ocorreu como `int`.

---

# ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

### 🔹 Compilar

```bash
javac procDeDados.java
```

### 🔹 Executar

```bash
java procDeDados
```

---

# 🚀 Evolução Esperada

Após esta aula você já consegue:

* Processar dados matematicamente
* Entender precedência de operadores
* Aplicar casting corretamente
* Resolver problemas matemáticos simples
* Evitar erros clássicos de divisão inteira

Esses conceitos são fundamentais para:

* Sistemas financeiros
* Cálculos estatísticos
* Processamento de entrada do usuário
* Estruturas condicionais futuras
