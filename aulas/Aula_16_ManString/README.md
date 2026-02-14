
# 📘 Aula 16 – Manipulação de Strings (Métodos Úteis)

## 🎯 Objetivos

Nesta aula você aprenderá a:

* ✅ Entender o funcionamento interno da classe `String`
* ✅ Trabalhar com métodos essenciais
* ✅ Aplicar transformações e validações
* ✅ Entender o conceito de imutabilidade

---

# 🧠 Conceito Fundamental

## 🔹 Strings são **imutáveis**

Em Java, `String` é imutável.

Isso significa:

> Qualquer modificação gera um novo objeto `String`.

Exemplo:

```java
String original = "Java";
String nova = original.toUpperCase();
```

`original` continua sendo `"Java"`
`nova` será `"JAVA"`

---

# 💻 Código da Aula

```java
public class manString {

    public static void main(String[] args) {

        String original = "Java é uma linguagem de programação.";

        System.out.println("Original: " + original);
        System.out.println("Maiúsculas: " + original.toUpperCase());
        System.out.println("Minúsculas: " + original.toLowerCase());
        System.out.println("Replace 'programação' por 'desenvolvimento': " 
                + original.replace("programação", "desenvolvimento"));
        System.out.println("Contém 'Java'? " + original.contains("Java"));
        System.out.println("Começa com 'Java'? " + original.startsWith("Java"));
        System.out.println("Termina com 'programação.'? " 
                + original.endsWith("programação."));
        System.out.println("Comprimento: " + original.length());
        System.out.println("Índice de 'linguagem': " 
                + original.indexOf("linguagem"));

        String[] palavras = original.split(" ");
        System.out.println("Primeira palavra: " + palavras[0]);

        System.out.println("Caractere na posição 5: " 
                + original.charAt(5));

        System.out.println("É vazia? " + original.isEmpty());

        System.out.println("Substring (5 a 15): " 
                + original.substring(5, 15));

        System.out.println("Trim: '" + original.trim() + "'");
    }
}
```

---

# 🔍 Métodos Essenciais Explicados

---

## 🔹 `toUpperCase()` e `toLowerCase()`

Transformam letras:

```java
original.toUpperCase();
original.toLowerCase();
```

Uso comum:

* Padronização para comparação
* Normalização de dados

---

## 🔹 `replace()`

Substitui trechos:

```java
original.replace("programação", "desenvolvimento");
```

Não altera a string original.

---

## 🔹 `contains()`

Verifica se existe um trecho:

```java
original.contains("Java");
```

Retorna `boolean`.

---

## 🔹 `startsWith()` / `endsWith()`

Valida prefixo ou sufixo.

Muito usado para:

* Verificar extensões de arquivos
* Validar padrões

---

## 🔹 `length()`

Retorna quantidade de caracteres.

```java
original.length();
```

---

## 🔹 `indexOf()`

Retorna posição da primeira ocorrência.

```java
original.indexOf("linguagem");
```

Se não encontrar → retorna `-1`.

---

## 🔹 `split()`

Divide a string com base em um delimitador.

```java
String[] palavras = original.split(" ");
```

Retorna um array.

---

## 🔹 `charAt()`

Retorna caractere específico.

```java
original.charAt(5);
```

⚠ Índices começam em 0.

---

## 🔹 `isEmpty()`

Verifica se a string está vazia:

```java
original.isEmpty();
```

Diferença importante:

```java
""        // vazio
"   "     // NÃO está vazio (contém espaços)
```

---

## 🔹 `substring()`

Extrai parte da string.

```java
original.substring(5, 15);
```

Regra:

* Inclui índice inicial
* Exclui índice final

---

## 🔹 `trim()`

Remove espaços do início e do fim.

Muito usado para limpar entrada do usuário.

---

# ⚠️ Cuidados Importantes

## 🔹 Comparação de Strings

Nunca use:

```java
string1 == string2
```

Use:

```java
string1.equals(string2)
```

Ou, ignorando maiúsculas/minúsculas:

```java
string1.equalsIgnoreCase(string2)
```

---

## 🔹 IndexOutOfBoundsException

Evite acessar índice inexistente:

```java
original.charAt(100);
```

Sempre valide tamanho antes.

---

# 🧩 Aplicações Reais

* Validação de senha
* Processamento de CSV
* Tratamento de nomes
* Filtros de busca
* Parsing de dados
* APIs REST

---

# 🔬 Nível Técnico (Extra)

Internamente:

* `String` é baseada em array de caracteres
* É final (não pode ser herdada)
* Usa pool de strings para otimização
* Métodos criam novos objetos

Para manipulação intensa → usar `StringBuilder`.

---

# ⚙️ Compilação

```bash
javac manString.java
java manString
```

---

# 🚀 Panorama do Seu Progresso

Você agora domina:

* Estruturas de controle
* Operadores
* Repetição
* Manipulação de texto
* Operações de baixo nível

Você já tem base suficiente para:

* Trabalhar com arrays
* Criar pequenos sistemas completos
* Entrar em métodos e modularização
* Iniciar orientação a objetos
