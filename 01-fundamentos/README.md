# 01 — Fundamentos

31 aulas de base da linguagem, cada uma com README próprio e código executável. Este é o **registro da minha base** — foi estudado organizado por recurso da linguagem, e é por isso que a partir da [nova trilha](../docs/TRILHA.md) o estudo passou a ser organizado por problema.

> Conteúdo mantido como está, inclusive com os erros. Ele é refatorado quando vira exercício de uma aula nova — e aí a comparação antes/depois entra no portfólio.

## Bloco 1 — Sintaxe e fluxo (aulas 01–17)

| # | Aula | Assunto |
|---|---|---|
| 01 | [Introdução](01-introducao/) | primeiro programa, estrutura de uma classe |
| 02 | [Operadores aritméticos](02-operadores-aritmeticos/) | soma, subtração, divisão inteira, resto |
| 03 | [Variáveis e tipos de dados](03-variaveis/) | declaração, `final`, os 8 primitivos, sufixos, overflow, precisão |
| 04 | [Saída de dados](04-saida-de-dados/) | `print`, `println`, `printf`, formatação |
| 05 | [Processamento de dados](05-processamento-de-dados/) | expressões e atribuição |
| 06 | [Entrada de dados](06-entrada-de-dados/) | `Scanner` e leitura do teclado |
| 07 | [Classe Math](07-classe-math/) | funções matemáticas prontas |
| 08 | [Expressões de comparação](08-expressoes-de-comparacao/) | operadores relacionais |
| 09 | [Expressões lógicas](09-expressoes-logicas/) | `&&`, `||`, `!`, curto-circuito |
| 10 | [Estruturas condicionais](10-estruturas-condicionais/) | `if`, `else if`, `else` |
| 11 | [Atribuições cumulativas](11-atribuicoes-cumulativas/) | `+=`, `-=`, `*=`, `/=` |
| 12 | [Switch case](12-switch-case/) | seleção múltipla |
| 13 | [Operador ternário](13-operador-ternario/) | condição em expressão |
| 14 | [Estruturas de repetição](14-estruturas-de-repeticao/) | `while`, `do-while`, `for` |
| 15 | [Operadores bitwise](15-operadores-bitwise/) | operações bit a bit |
| 16 | [Manipulação de strings](16-manipulacao-de-strings/) | métodos de `String` |
| 17 | [Métodos e modularização](17-metodos/) | parâmetro, retorno, sobrecarga, escopo, `static` |

## Bloco 2 — Orientação a objetos (aulas 18–24)

| # | Aula | Assunto |
|---|---|---|
| 18 | [Classes e objetos](18-classes-e-objetos/) | atributos, métodos, instância |
| 19 | [Encapsulamento e modificadores](19-encapsulamento-e-modificadores/) | `private`, `public`, getters e setters |
| 20 | [Construtores](20-construtores/) | inicialização e sobrecarga |
| 21 | [Objetos](21-objetos/) | referência, passagem de parâmetro |
| 22 | [Herança](22-heranca/) | `extends`, reuso e especialização |
| 23 | [Polimorfismo](23-polimorfismo/) | sobrescrita e ligação tardia |
| 24 | [Interfaces](24-interfaces/) | contrato e implementação |

> **Os assuntos que travaram** — e que a [Fase POO da trilha](../docs/TRILHA.md) retoma pelo lado do problema, não da teoria: quando criar uma classe, quando herdar e quando compor, e por que encapsular não é gerar getter e setter para tudo.

## Bloco 3 — Estruturas e recursos da linguagem (aulas 25–31)

| # | Aula | Assunto |
|---|---|---|
| 25 | [Arrays — básico](25-arrays-basico/) | declaração, índice, percurso |
| 26 | [Arrays — avançado](26-arrays-avancado/) | matriz, laço aninhado, array de objetos |
| 27 | [Collections](27-collections/) | `List`, `Set`, `Map` |
| 28 | [Generics](28-generics/) | tipo parametrizado, *type safety* |
| 29 | [Exceções](29-excecoes/) | `try/catch/finally`, checked × unchecked, exceção customizada |
| 30 | [Enums](30-enums/) | constantes com estado e comportamento |
| 31 | [Operadores de incremento](31-operadores-de-incremento/) | `++`, `--`, pré e pós |

> **Renumeração de 07/08/2026.** A antiga aula 30 (tipos primitivos) foi absorvida pela [Aula 03](03-variaveis/), onde o assunto pertence — não fazia sentido discutir precisão de tipo depois de 29 aulas usando os tipos. A vaga virou a [Aula 17](17-metodos/), **métodos**, que era o buraco real da trilha: até então o estudo pulava do `main` direto para classes. Com isso, as aulas 17–29 antigas viraram 18–30. Referências com a numeração antiga na [auditoria](../docs/AUDITORIA.md) seguem válidas — há um de-para no fim daquele documento.

## Como rodar

```bash
cd 29-excecoes && javac -d out $(find src -name "*.java") && java -cp out application.Programa
```
