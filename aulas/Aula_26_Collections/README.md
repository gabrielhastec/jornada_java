
# 📘 Aula 26 – Collections Framework (List, Set, Map)

## 🎯 Objetivo

Conhecer o **Collections Framework**, conjunto de estruturas de dados do Java que substituem arrays quando precisamos de:

* tamanho dinâmico
* mais operações prontas
* melhor organização de dados
* estruturas mais adequadas para cada caso

Principais interfaces:

* `List`
* `Set`
* `Map`

---

# 🧠 1. O que é o Collections Framework

É um conjunto de **interfaces e classes prontas para manipular coleções de objetos**.

Hierarquia simplificada:

```text
Collection
   ├── List
   │     ├── ArrayList
   │     └── LinkedList
   │
   └── Set
         ├── HashSet
         └── TreeSet

Map (estrutura separada)
   ├── HashMap
   └── TreeMap
```

⚠️ Observação importante:

`Map` **não herda de Collection**, pois trabalha com **pares chave/valor**.

---

# 2️⃣ List – Coleção Ordenada

Lista mantém:

* ordem de inserção
* acesso por índice
* permite duplicatas

### Implementações comuns

| Classe       | Característica                |
| ------------ | ----------------------------- |
| `ArrayList`  | baseada em array (mais usada) |
| `LinkedList` | baseada em lista encadeada    |

---

## Exemplo

```java
List<String> lista = new ArrayList<>();

lista.add("Java");
lista.add("Python");
lista.add("Java"); // duplicata permitida

System.out.println(lista);
```

Saída:

```text
[Java, Python, Java]
```

Acesso por índice:

```java
System.out.println(lista.get(1));
```

Resultado:

```text
Python
```

---

# 3️⃣ Set – Conjunto de Elementos Únicos

Características:

* não permite duplicatas
* normalmente não mantém ordem

Principais implementações:

| Classe    | Característica           |
| --------- | ------------------------ |
| `HashSet` | sem ordem                |
| `TreeSet` | ordenado automaticamente |

---

## Exemplo

```java
Set<String> conjunto = new HashSet<>();

conjunto.add("Java");
conjunto.add("Python");
conjunto.add("Java"); // ignorado

System.out.println(conjunto);
```

Saída possível:

```text
[Java, Python]
```

⚠️ A ordem pode variar.

---

# 4️⃣ Map – Estrutura Chave / Valor

Um `Map` funciona como um **dicionário**.

Cada elemento possui:

* chave
* valor

Principais implementações:

| Classe    | Característica      |
| --------- | ------------------- |
| `HashMap` | rápido, sem ordem   |
| `TreeMap` | ordenado pela chave |

---

## Exemplo

```java
Map<Integer, String> mapa = new HashMap<>();

mapa.put(1, "João");
mapa.put(2, "Maria");
mapa.put(1, "José"); // substitui valor

System.out.println(mapa);
```

Saída:

```text
{1=José, 2=Maria}
```

Acesso:

```java
System.out.println(mapa.get(2));
```

Resultado:

```text
Maria
```

---

# 5️⃣ Percorrendo Coleções

## Enhanced for

```java
for (String lang : lista) {
    System.out.println(lang);
}
```

---

## Iterator

Usado quando precisamos remover elementos durante a iteração.

```java
Iterator<String> it = lista.iterator();

while (it.hasNext()) {
    System.out.println(it.next());
}
```

---

## forEach com Lambda (Java 8+)

```java
lista.forEach(System.out::println);
```

Isso usa **referência de método**.

Equivalente a:

```java
lista.forEach(x -> System.out.println(x));
```

---

# 💻 Código da Aula

Arquivos:
- `src/entities/Aluno.java`: nome, curso, nota.
- `src/entities/Turma.java`: guarda `List<Aluno>` e expõe metodos usando `Set` e `Map`.
- `src/application/Programa.java`: executa o exemplo.

Trechos principais:

```java
// List (ordem + duplicados)
List<Aluno> alunos = turma.getAlunos();
System.out.println(alunos.get(1)); // acesso por indice

// Set (valores unicos)
Set<String> cursos = turma.cursosDistintos(); // HashSet internamente

// Map (chave/valor)
Map<String, Integer> contagem = turma.contagemPorCurso(); // curso -> quantidade
Map<String, Aluno> melhores = turma.melhorPorCurso();     // curso -> melhor nota
```

---

## Saida esperada (resumida)

```
LIST (ordem de insercao)
Indice 0 -> Ana (Java) - nota 8.5
Indice 1 -> Bruno (Python) - nota 7.9
Indice 2 -> Carla (Java) - nota 9.1
Indice 3 -> Diego (Java) - nota 8.7
Indice 4 -> Elisa (Python) - nota 8.2
Indice 5 -> Bruno (Python) - nota 7.9

SET (cursos unicos)
Java
Python

MAP (contagem por curso)
Java => 3
Python => 3

MAP (melhor nota por curso)
Java => Carla (Java) - nota 9.1
Python => Elisa (Python) - nota 8.2

Melhor aluno da turma: Carla (Java) - nota 9.1
```

---

## Como rodar

Na pasta `src`:

```
javac application/Programa.java entities/*.java
java application.Programa
```

---

# 📌 Comparação Geral

| Estrutura | Permite duplicata | Ordem   | Acesso por índice |
| --------- | ----------------- | ------- | ----------------- |
| List      | ✔                 | ✔      | ✔                |
| Set       | ✘                 | depende | ✘                |
| Map       | chave única       | depende | por chave         |

---

# 📌 Conclusão

Collections são superiores a arrays quando precisamos de:

* tamanho dinâmico
* manipulação frequente
* estruturas específicas (fila, conjunto, mapa)

Na prática, em sistemas Java reais:

* `ArrayList`
* `HashSet`
* `HashMap`

são as coleções **mais utilizadas**.
