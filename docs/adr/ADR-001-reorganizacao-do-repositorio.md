# ADR-001 — Reorganizar o repositório em 5 trilhas

**Data:** 06/08/2026
**Status:** Aceito

## Contexto

O repositório era um acúmulo cronológico de aulas: `aulas/Aula_01..31`, `exercicios/Exer_01..09` e uma pasta `projetos/` que **nunca chegou a ser versionada**. Problemas concretos que isso causava:

- O único projeto de portfólio (`Crud-Produto`) tinha `mvnw`, `src` e `target`, mas **não tinha `pom.xml`** — ou seja, não compilava para ninguém, e nem aparecia no GitHub.
- Havia 9 arquivos `.class` versionados e um `.gitignore` que ignorava a si próprio e não ignorava `bin/` nem `target/`.
- Os nomes misturavam idioma, `CamelCase`, `snake_case`, acento e erro de digitação (`excepitions`, `Herancca`).
- Não havia nenhum lugar para registrar **por que** algo foi feito — só o código, sem o raciocínio.
- Assuntos que aparecem em vaga real (nginx, RBAC, multi-tenant, ORM, protocolos, borda) não tinham onde morar, porque não são "aula" nem "projeto".

## Decisão

O repositório passa a ter cinco trilhas com propósito distinto, mais uma pasta de documentação:

| Pasta | Propósito |
|---|---|
| `01-fundamentos/` | base da linguagem (o que era `aulas/`) |
| `02-katas/` | exercícios com domínio de negócio (o que era `exercicios/`) |
| `03-projetos/` | sistemas de ponta a ponta, cada um com build, banco e deploy próprios |
| `04-desafios/` | desafios técnicos de mercado, resolvidos cronometrados e sem IA |
| `05-laboratorios/` | experimentos curtos de uma peça de infraestrutura por vez |
| `docs/` | trilha, método, glossário, fichas de conceito e ADRs |

Nomes em `NN-kebab-case`, sem acento. Renomeações feitas com `git mv` para preservar o histórico.

## Alternativas consideradas

| Alternativa | Por que não |
|---|---|
| Separar em vários repositórios (estudos × portfólio) | Espalha o histórico e a evolução em vários lugares; um repositório único conta a história completa e é mais fácil de mostrar em entrevista |
| Manter a estrutura e só corrigir o `.gitignore` | Não resolve a falta de lugar para projetos, laboratórios e documentação — que é a raiz do problema |
| Converter tudo em um projeto Maven multi-módulo com JUnit obrigatório | O foco agora é aprender, não manter infraestrutura de build de 40 módulos. Maven e teste entram nos projetos, onde têm função real |

## Consequências

**Positivas:**
- O repositório passa a ser legível para um recrutador em menos de um minuto
- Existe lugar definido para os assuntos "que ninguém ensina" (`05-laboratorios/`, `docs/conceitos/`)
- O raciocínio por trás das escolhas fica registrado (`docs/adr/`), que é o que se cobra de quem quer atuar como arquiteto
- O projeto Spring voltou a compilar

**Negativas / custo aceito:**
- Todo link externo antigo para `aulas/Aula_XX` quebra (aceitável: o repositório é pessoal)
- Os arquivos `.iml` do IntelliJ ficaram apontando para caminhos antigos e precisam ser regenerados pela IDE
- Fundamentos e katas continuam sem build tool: rodam pela IDE ou por `javac` na mão

**O que me faria rever esta decisão:**
- Se um projeto de `03-projetos/` crescer a ponto de ter release e versionamento próprios, ele sai para um repositório dedicado e fica aqui só o link
