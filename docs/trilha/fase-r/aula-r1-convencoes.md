# Aula R1 — Convenções da linguagem e o build que não roda

**Fase R · Semana 1 · ~2h**

**Pré-requisitos (o que você já viu e vai usar aqui):**
- Aulas 01 a 16 — sintaxe básica, classes com `main`
- Terminal: navegar com `cd` e listar com `ls`
- Git: `git status`, `git add`, `git commit`, `git mv`

**Nada além disso é exigido.** Todo comando novo aparece explicado.

---

## Bloco 1 — O problema

> Você entra num time. Primeira tarefa: uma correção pequena. Você escreve, testa na sua máquina (Windows), tudo funciona. Abre o Pull Request.
>
> Vinte minutos depois, o canal do time apita: **o build da esteira quebrou**. O servidor de integração roda Linux e cospe um erro que ninguém entende:
>
> ```
> error: class VariaveisJava is public, should be declared in a file named VariaveisJava.java
> ```
>
> Você roda de novo na sua máquina: **funciona**. E agora?

Isso não é hipótese. **Está acontecendo no seu repositório agora:** 20 das 40 pastas não compilam por esse motivo exato — 17 aulas e 3 katas. A [auditoria](../../AUDITORIA.md) tem a lista completa.

O motivo é bonito de entender, e a lição vale para a carreira inteira.

---

## Bloco 2 — O conceito

### 2.1 A regra da linguagem

Em Java existe uma regra que **não é opinião nem estilo, é obrigação do compilador**:

> Uma classe declarada `public` tem que estar em um arquivo com **exatamente** o mesmo nome dela, mais `.java`.

```java
// Arquivo: Produto.java
public class Produto { }        // OK

// Arquivo: produto.java
public class Produto { }        // ERRO DE COMPILACAO
```

**Por que a linguagem exige isso?** Porque o compilador e a JVM localizam uma classe **pelo caminho do arquivo**. Quando seu código diz `new Produto()`, a JVM vai procurar `Produto.class` no diretório correspondente ao pacote. Sem essa correspondência mecânica, encontrar classe exigiria varrer todos os arquivos do projeto.

### 2.2 O detalhe que escondeu o erro de você

No commit `7ff245f — Padronização do nome das classes para a convenção Java`, você fez a coisa certa: renomeou as classes de `variaveisJava` para `VariaveisJava`, seguindo a convenção Java (classe em `PascalCase`).

Só que o **arquivo** continuou `variaveisJava.java`. E o Windows não reclamou — porque o sistema de arquivos do Windows é **case-insensitive**: para ele, `variaveisJava.java` e `VariaveisJava.java` são o mesmo arquivo. Um `git mv variaveisJava.java VariaveisJava.java` nessa situação é ignorado silenciosamente.

Já o Linux (onde roda praticamente todo servidor e toda esteira de CI) é **case-sensitive**: `Produto.java` e `produto.java` são dois arquivos diferentes.

| | Windows / macOS (padrão) | Linux |
|---|---|---|
| `Produto.java` e `produto.java` | mesmo arquivo | arquivos diferentes |
| `import entities.Produto` achando `produto.java` | pode funcionar | **não acha** |

### 2.3 Compilar × executar: dois erros diferentes

Aproveitando a aula, um segundo conceito que vai te acompanhar sempre:

```java
public class Main {
    public static void Main(String[] args) { }   // M maiusculo
}
```

Isso **compila sem nenhum erro**. `Main(String[])` é um método estático válido. Mas ao rodar:

```
Error: Main method not found in class application.Main
```

Porque a JVM procura por um método chamado exatamente `main` (minúsculo). Ou seja:

- **Erro de compilação** — o compilador te avisa antes de rodar. Barato.
- **Erro de execução** — só aparece quando o programa roda. Caro.

Boa parte do trabalho de backend é justamente empurrar erros da segunda categoria para a primeira: tipos fortes, validação na entrada, testes automatizados. Guarde essa frase, ela volta em várias aulas.

Esse erro do `M` maiúsculo está na sua [aula 18](../../../01-fundamentos/18-encapsulamento-e-modificadores/).

---

## Bloco 3 — Onde isso aparece na sua vida de desenvolvedor

| Situação | O que acontece |
|---|---|
| **Time misto Windows + Mac + Linux** | Você comita `Usuario.java` e o colega importa `usuario.Usuario`; na máquina dele funciona, na esteira não |
| **Docker** | Você constrói a imagem a partir do seu código Windows; o container é Linux e o build falha na hora do `COPY` + compilação |
| **Deploy** | O jar não sobe porque uma classe não foi encontrada em runtime — `ClassNotFoundException` |
| **Code review** | Renomear arquivo com mudança só de maiúscula é um dos poucos casos em que o Git precisa de ajuda explícita; saber disso te marca como quem entende a ferramenta |

**Vale para outras linguagens:** o mesmo problema derruba projeto em JavaScript (`import Button from './button'` funciona no Windows, falha na Vercel), Python, Go. Aprender agora, em Java, resolve para todas.

---

## Bloco 4 — Implementação guiada

### Passo 1 — Ver o estrago com seus olhos

No terminal, na raiz do repositório:

```bash
javac -d /tmp/out $(find 01-fundamentos/03-variaveis/src -name "*.java")
```

Leia a mensagem inteira. Ela diz **o nome que o arquivo deveria ter**. O compilador quase sempre já entrega a resposta — o hábito de ler o erro até o fim vale mais que qualquer atalho.

### Passo 2 — Renomear em dois passos (a parte que o Windows complica)

Como o Windows considera os dois nomes iguais, o rename direto não funciona. A solução é passar por um nome intermediário:

```bash
cd 01-fundamentos/03-variaveis/src && git mv variaveisJava.java temp.java && git mv temp.java VariaveisJava.java
```

Confira que o Git registrou a mudança de verdade:

```bash
git status --short
```

Você deve ver o arquivo antigo saindo e o novo entrando. Se não aparecer nada, o rename não pegou — repita prestando atenção nos dois passos.

### Passo 3 — Compilar de novo

```bash
javac -d /tmp/out $(find 01-fundamentos/03-variaveis/src -name "*.java")
```

Sem saída = compilou. **Só passe para o próximo arquivo depois que este compilar.**

### Passo 4 — Repetir, e depois automatizar

Faça **os três primeiros na mão** (pastas 02, 03 e 04 de `01-fundamentos`). A partir do quarto, você já entendeu o mecanismo, e repetir 19 vezes na mão não ensina mais nada — ensina a odiar a tarefa.

Aí vale a pena parar e pensar em automatizar: o comando `find` lista os arquivos, `basename` extrai o nome, `grep` acha a classe pública dentro. Tente montar isso; se travar 30 minutos (regra do timebox), me chame e revisamos juntos o seu script.

> **Isso também é a aula:** saber quando fazer na mão (para entender) e quando automatizar (para não perder tempo) é uma decisão que você vai tomar todo dia como desenvolvedor.

### A lista completa do que precisa ser corrigido

**Fundamentos** — arquivo → classe declarada dentro:

| Pasta | Arquivo atual | Deve virar |
|---|---|---|
| 02-operadores-aritmeticos | `operArit.java` | `OperArit.java` |
| 03-variaveis | `variaveisJava.java` | `VariaveisJava.java` |
| 04-saida-de-dados | `saidaDados.java` | `SaidaDados.java` |
| 05-processamento-de-dados | `procDeDados.java` | `ProcDeDados.java` |
| 06-entrada-de-dados | `entradaDados.java` | `EntradaDados.java` |
| 07-classe-math | `extraMath.java` | `ExtraMath.java` |
| 08-expressoes-de-comparacao | `comparacao.java` | `Comparacao.java` |
| 09-expressoes-logicas | `expLogica.java` | `ExpLogica.java` |
| 10-estruturas-condicionais | `condicional.java` | `Condicional.java` |
| 11-atribuicoes-cumulativas | `atribCumulativas.java` | `AtribCumulativas.java` |
| 12-switch-case | `switchCase.java` | `SwitchCase.java` |
| 13-operador-ternario | `condTernario.java` | `CondTernario.java` |
| 14-estruturas-de-repeticao | `repeticao.java` | `Repeticao.java` |
| 15-operadores-bitwise | `bitwise.java` | `Bitwise.java` |
| 16-manipulacao-de-strings | `manString.java` | `ManString.java` |
| 17-classes-e-objetos | `application/main.java`, `entities/contaBancaria.java` | `Main.java`, `ContaBancaria.java` |
| 18-encapsulamento-e-modificadores | `application/main.java`, `entities/produto.java` | `Main.java`, `Produto.java` |

**Katas:** `01-operacoes-basicas/src/operBasica.java` → `OperBasica.java` · `02-salario/src/salario.java` → `Salario.java` · `03-venda/src/venda.java` → `Venda.java`

---

## Bloco 5 — A prova

Um comando que compila **todas** as pastas e mostra o placar. Rode antes de começar (para ver 20 falhas) e depois de terminar (para ver zero):

```bash
for d in 01-fundamentos/*/ 02-katas/*/; do srcs=$(find "$d" -name "*.java" -not -path "*versao-inicial*"); [ -z "$srcs" ] && continue; if javac -d /tmp/chk $srcs 2>/dev/null; then echo "OK   $d"; else echo "FALHA $d"; fi; done
```

Anote os dois placares no [`PROGRESSO.md`](../../PROGRESSO.md). Ver "20 falhas → 0 falhas" escrito por você é o tipo de evidência que sustenta a motivação num dia ruim.

> **Uso no dia a dia:** esse laço é uma versão caseira do que uma esteira de CI faz a cada push. Na Fase ARQ você vai transformar exatamente isso num GitHub Actions.

---

## Bloco 6 — Caça ao bug

**Tarefa:** a aula 18 tem o `main` com `M` maiúsculo. Corrija e prove que rodou.

**Critérios de aceite:**
1. `javac` compila a pasta inteira sem erro
2. `java -cp <saída> application.Main` **executa** e imprime as informações do produto
3. Você consegue responder: *por que o compilador não reclamou do `M` maiúsculo?*

> Repare na ordem: compilar **não** é o mesmo que funcionar. Muita gente para no "compilou" e chama de pronto.

---

## Bloco 7 — Registro

No [`PROGRESSO.md`](../../PROGRESSO.md), entrada da Semana 1:

- placar de compilação antes e depois
- a explicação, com suas palavras, de por que o Windows escondeu o problema
- se você automatizou a correção: qual foi a lógica do seu script
- a resposta do Bloco 6

**Teste do "explique de volta":** sem olhar este arquivo, explique a diferença entre erro de compilação e erro de execução, com um exemplo de cada. Se conseguir, a aula está fechada.

---

## Material de apoio

- [Oracle — Java Language Specification, §7.6 (regra do arquivo)](https://docs.oracle.com/javase/specs/jls/se21/html/jls-7.html#jls-7.6)
- [Convenções de nomenclatura Java](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html) — classe em `PascalCase`, método e variável em `camelCase`, constante em `UPPER_SNAKE_CASE`
- [Git — configuração `core.ignorecase`](https://git-scm.com/docs/git-config#Documentation/git-config.txt-coreignoreCase)

## Próxima aula

**R2 — Base rápida:** rodar as aulas 01 a 16 já corrigidas, conferindo se cada uma faz o que o README promete. É revisão de verdade: rápida, com o objetivo de encontrar o que está **errado**, não de reaprender `if`.
