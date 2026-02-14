
# 📘 Aula 14 – Estruturas de Repetição

## 🎯 Objetivos

Nesta aula você aprenderá a:

* ✅ Repetir blocos de código
* ✅ Utilizar `for`, `while` e `do-while`
* ✅ Escolher a estrutura adequada
* ✅ Aplicar em cenários reais

---

# 🧠 Conceito Fundamental

Uma estrutura de repetição executa um bloco de código **enquanto uma condição for verdadeira**.

Cada repetição é chamada de **iteração**.

---

# 🔹 1. `for` – Quando o número de iterações é conhecido

Ideal quando você sabe exatamente quantas vezes o bloco deve executar.

### 📌 Sintaxe

```java
for (inicialização; condição; incremento) {
    // código
}
```

### 📌 Código da Aula

```java
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```

### 🔍 Fluxo

1. Inicializa `i = 0`
2. Verifica `i < 5`
3. Executa bloco
4. Incrementa `i`
5. Repete até condição ser falsa

### 📊 Saída

```
i = 0
i = 1
i = 2
i = 3
i = 4
```

---

# 🔹 2. `while` – Quando a condição é verificada antes

Usado quando **não sabemos exatamente o número de repetições**.

### 📌 Sintaxe

```java
while (condicao) {
    // código
}
```

### 📌 Código da Aula

```java
int estoque = 3;

while (estoque > 0) {
    System.out.println("Vendendo... estoque: " + estoque--);
}
```

### 🔍 Fluxo

1. Verifica `estoque > 0`
2. Executa bloco
3. Decrementa `estoque`
4. Repete até zerar

### 📊 Saída

```
Vendendo... estoque: 3
Vendendo... estoque: 2
Vendendo... estoque: 1
```

---

# 🔹 3. `do-while` – Executa pelo menos uma vez

Diferença fundamental:

A condição é verificada **depois** da execução.

### 📌 Sintaxe

```java
do {
    // código
} while (condicao);
```

### 📌 Código da Aula

```java
Scanner sc = new Scanner(System.in);
String senha;

do {
    System.out.print("Digite a senha: ");
    senha = sc.nextLine();
} while (!senha.equals("12345"));

System.out.println("Acesso liberado.");
```

### 🔍 Aplicação

* Validação de senha
* Menu interativo
* Entrada obrigatória

Mesmo que o usuário digite certo na primeira tentativa, o bloco executa ao menos uma vez.

---

# 🧩 Comparação Direta

| Estrutura  | Quando usar                    |
| ---------- | ------------------------------ |
| `for`      | Número de repetições conhecido |
| `while`    | Repetição baseada em condição  |
| `do-while` | Deve executar ao menos uma vez |

---

# ⚠️ Erros Comuns

## ❌ Loop infinito

```java
while (true) {
}
```

Sem condição de parada, trava o programa.

---

## ❌ Esquecer atualização da variável

```java
int x = 0;
while (x < 5) {
    System.out.println(x);
}
```

Nunca altera `x` → loop infinito.

---

## ❌ Comparar `String` com `==`

Correto:

```java
senha.equals("12345")
```

Nunca use:

```java
senha == "12345"
```

---

# 🧠 Padrões Profissionais

### 🔹 Acumulador

```java
int soma = 0;

for (int i = 1; i <= 10; i++) {
    soma += i;
}
```

---

### 🔹 Contador

```java
int contador = 0;

while (condicao) {
    contador++;
}
```

---

# 💡 Casos Reais

* Processar pedidos em lote
* Atualizar estoque
* Validar entrada do usuário
* Percorrer listas
* Gerar relatórios

---

# ⚙️ Compilação

```bash
javac repeticao.java
java repeticao
```

---

# 🚀 Panorama do Seu Progresso

Você agora domina:

* Decisões (`if`, `switch`, ternário)
* Atualizações de estado
* Repetições controladas
* Entrada de dados

Isso já permite construir pequenos sistemas interativos.
