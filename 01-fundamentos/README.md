# 01 — Fundamentos

31 aulas de base da linguagem, cada uma com README próprio e código executável. Este é o **registro da minha base** — foi estudado organizado por recurso da linguagem, e é por isso que a partir da [nova trilha](../docs/TRILHA.md) o estudo passou a ser organizado por problema.

> Conteúdo mantido como está, inclusive com os erros. Ele é refatorado quando vira exercício de uma aula nova — e aí a comparação antes/depois entra no portfólio.

## Bloco 1 — Sintaxe e fluxo (aulas 01–16)

| # | Aula | Assunto |
|---|---|---|
| 01 | [Introdução](01-introducao/) | primeiro programa, estrutura de uma classe |
| 02 | [Operadores aritméticos](02-operadores-aritmeticos/) | soma, subtração, divisão inteira, resto |
| 03 | [Variáveis](03-variaveis/) | declaração, tipos, escopo |
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

## Bloco 2 — Orientação a objetos (aulas 17–23)

| # | Aula | Assunto |
|---|---|---|
| 17 | [Classes e objetos](17-classes-e-objetos/) | atributos, métodos, instância |
| 18 | [Encapsulamento e modificadores](18-encapsulamento-e-modificadores/) | `private`, `public`, getters e setters |
| 19 | [Construtores](19-construtores/) | inicialização e sobrecarga |
| 20 | [Objetos](20-objetos/) | referência, passagem de parâmetro |
| 21 | [Herança](21-heranca/) | `extends`, reuso e especialização |
| 22 | [Polimorfismo](22-polimorfismo/) | sobrescrita e ligação tardia |
| 23 | [Interfaces](23-interfaces/) | contrato e implementação |

> **Os assuntos que travaram** — e que a [Fase POO da trilha](../docs/TRILHA.md) retoma pelo lado do problema, não da teoria: quando criar uma classe, quando herdar e quando compor, e por que encapsular não é gerar getter e setter para tudo.

## Bloco 3 — Estruturas e recursos da linguagem (aulas 24–31)

| # | Aula | Assunto |
|---|---|---|
| 24 | [Arrays — básico](24-arrays-basico/) | declaração, índice, percurso |
| 25 | [Arrays — avançado](25-arrays-avancado/) | matriz, laço aninhado, array de objetos |
| 26 | [Collections](26-collections/) | `List`, `Set`, `Map` |
| 27 | [Generics](27-generics/) | tipo parametrizado, *type safety* |
| 28 | [Exceções](28-excecoes/) | `try/catch/finally`, checked × unchecked, exceção customizada |
| 29 | [Enums](29-enums/) | constantes com estado e comportamento |
| 30 | [Tipos primitivos](30-tipos-primitivos/) | sufixos, wrappers, autoboxing |
| 31 | [Operadores de incremento](31-operadores-de-incremento/) | `++`, `--`, pré e pós |

## Como rodar

```bash
cd 28-excecoes && javac -d out $(find src -name "*.java") && java -cp out application.Programa
```
