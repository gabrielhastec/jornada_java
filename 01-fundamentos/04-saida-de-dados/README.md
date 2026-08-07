
# 📘 Aula 04 – Saída de Dados Formatada

## 🎯 Objetivo da Aula

Nesta aula você aprenderá a:

* ✅ Exibir dados no console de diferentes formas
* ✅ Utilizar `System.out.print` e `System.out.println` corretamente
* ✅ Trabalhar com `System.out.printf`
* ✅ Aplicar especificadores de formatação (`%d`, `%f`, `%s`, `%n`)
* ✅ Configurar o `Locale` para padronizar saída numérica

A formatação correta é fundamental para gerar saídas organizadas e profissionais.

---

# 🧠 Conceitos Fundamentais

## 🔹 1. `print` vs `println`

### `System.out.print()`

* Imprime na mesma linha
* Não realiza quebra automática

```java
System.out.print("Olá");
System.out.print(" Mundo");
```

Saída:

```
Olá Mundo
```

---

### `System.out.println()`

* Imprime e realiza quebra de linha

```java
System.out.println("Olá");
System.out.println("Mundo");
```

Saída:

```
Olá
Mundo
```

---

# 🔹 2. Saída Formatada com `printf`

O método `printf` permite controlar exatamente como os dados serão exibidos.

Sintaxe geral:

```java
System.out.printf("texto formatado", variaveis);
```

---

## 📌 Especificadores de Formatação

| Especificador | Tipo Esperado      | Descrição                   |
| ------------- | ------------------ | --------------------------- |
| `%d`          | inteiro (`int`)    | Número inteiro              |
| `%f`          | decimal (`double`) | Número com ponto flutuante  |
| `%.2f`        | decimal            | Número com 2 casas decimais |
| `%s`          | String             | Texto                       |
| `%n`          | —                  | Quebra de linha portátil    |

---

### 🔎 Exemplo

```java
System.out.printf("Nome: %s%nIdade: %d%nSalário: %.2f%n", nome, idade, salario);
```

Saída:

```
Nome: Maria
Idade: 25
Salário: 2500.50
```

---

# 🔹 3. Controle de Casas Decimais

```java
%.2f
```

Significa:

* `%` → início da formatação
* `.2` → duas casas decimais
* `f` → número decimal

Exemplo:

```java
double valor = 10.45678;
System.out.printf("%.2f", valor);
```

Saída:

```
10.46
```

O valor é arredondado automaticamente.

---

# 🌎 4. Uso de `Locale`

Por padrão, no Brasil o separador decimal é vírgula.

Para forçar o uso do **ponto decimal**, utilizamos:

```java
Locale.setDefault(Locale.US);
```

Isso garante que:

```
2500.50
```

E não:

```
2500,50
```

⚠️ Importante para:

* Sistemas financeiros
* Integrações com APIs
* Padrões internacionais

---

# 💻 Código da Aula

```java
import java.util.Locale;

public class saidaDados {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        int idade = 25;
        double salario = 2500.50;
        String nome = "Maria";

        System.out.print("Olá");
        System.out.print(" Mundo");
        System.out.println();

        System.out.println("Nome: " + nome + 
                           ", Idade: " + idade + 
                           ", Salário: " + salario);

        System.out.printf(
            "Nome: %s%nIdade: %d%nSalário: %.2f%n",
            nome, idade, salario
        );
    }
}
```

---

# 🧩 Comparação: Concatenação vs Formatação

### 🔹 Concatenação

```java
"Nome: " + nome + ", Idade: " + idade
```

✔ Simples
❌ Pode ficar visualmente desorganizado

---

### 🔹 `printf`

```java
"Nome: %s, Idade: %d"
```

✔ Mais organizado
✔ Melhor controle
✔ Mais utilizado em sistemas reais

---

# ⚠️ Erros Comuns

❌ Esquecer de passar variável correspondente ao especificador
❌ Usar `%d` para `double`
❌ Esquecer `Locale` quando necessário
❌ Usar `\n` ao invés de `%n` (menos portátil)

---

# ⚙️ Como Compilar e Executar

Dentro da pasta `src`:

### 🔹 Compilar

```bash
javac saidaDados.java
```

### 🔹 Executar

```bash
java saidaDados
```

---

# 🚀 Evolução Esperada

Após esta aula você já consegue:

* Produzir saídas organizadas
* Controlar casas decimais
* Criar relatórios simples no console
* Aplicar padrão internacional de números
* Escrever código mais profissional

Esse conhecimento será essencial para:

* Entrada de dados
* Processamento financeiro
* Exercícios matemáticos
* Projetos reais
