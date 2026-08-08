# Trilha de estudos — revisão, POO e sistema de ponta a ponta

**Carga:** ~10h/semana · **Duração estimada:** ~33 semanas (elástica — prazo é estimativa, não compromisso)
**Método de cada aula:** [`METODO.md`](METODO.md) · **Diário:** [`PROGRESSO.md`](PROGRESSO.md) · **Ponto de partida:** [`AUDITORIA.md`](AUDITORIA.md)

---

## O princípio que organiza tudo: um sistema que cresce a cada aula

Este é o modelo que funcionou para você em JavaScript, adaptado: **cada aula acrescenta uma funcionalidade ao mesmo sistema**. No fim da trilha você não tem 30 exercícios soltos — tem **um sistema completo**, construído por você, que continua evoluindo com features novas.

O sistema é o **[Sistema de Gestão da Loja](../03-projetos/00-loja-console/)**, e ele já começou: a aula 31 tem `domain/Produto`, `repository/ProdutoRepository`, `service/ProdutoService` e `ui/ProdutoConsoleUI`. É esse código que vira a base.

```
Fase R    console cru, cadastro de produto
   ↓      + estoque, preço protegido, cliente, venda, pagamento, relatórios
Fase POO  sistema de loja completo em Java puro, com regras de negócio de verdade
   ↓      + HTTP, banco de dados, migrations
Fase WEB  o MESMO domínio exposto como API REST (vira o 01-catalogo-api)
   ↓      + autenticação, permissão, integrações
Fase PRO  sistema pronto para produção
```

**Por que esse domínio:** loja tem tudo que um sistema real tem — dinheiro (que não pode errar um centavo), estoque (que não pode ficar negativo), regras que mudam (descontos, formas de pagamento), relatórios e histórico. E é o mesmo domínio do [`01-catalogo-api`](../03-projetos/01-catalogo-api/), então nada é jogado fora na virada para web.

## Duas regras que valem para toda aula

**1. Nada é exigido antes de ser ensinado.** Toda aula abre declarando o que você precisa já ter visto. Se aparecer um recurso novo no meio (`Optional`, `record`, `Map`), ele é explicado ali, na hora, com exemplo — nunca usado como se você já soubesse.

**2. Toda aula responde "onde eu uso isso".** Cada conceito vem com: onde ele aparece num sistema real (qual camada, qual arquivo), o que ele resolve no seu dia a dia como desenvolvedor, e como isso cai em prova técnica.

---

# Fase R — Revisão (semanas 1–5, ~50h)

> **Por que começar aqui:** a [auditoria](AUDITORIA.md) encontrou **20 de 40 pastas que não compilam** e uma aula que ensina o oposto do conceito correto (aula 19, encapsulamento). Não dá para construir em cima disso. E como é revisão, o ritmo é rápido: o objetivo não é reaprender `if`, é **consertar, entender por que quebrou, e fixar a convenção**.

| Semana | Tema | O que você faz | Achados da auditoria resolvidos |
|---|---|---|---|
| **R1** | Convenções da linguagem e o sistema de arquivos | Corrige os 22 arquivos com nome ≠ classe; entende por que o Windows escondeu o erro e por que isso quebra o build no Linux | 1, 2 |
| **R2** | Base rápida: tipos, operadores, condicionais, laços, métodos | Roda e confere as aulas 01–17 já corrigidas; refaz 3 exercícios pequenos de lógica sem consultar | — |
| **R3** | Dinheiro, precisão e o tipo certo para cada coisa | Entende por que `double` erra centavo; troca por `BigDecimal` nas aulas 18–22 e no kata 02 | 3 |
| **R4** | Fronteira entre domínio e interface | Tira os `System.out` de dentro das entidades e serviços (11 arquivos): o domínio decide, a `ui` mostra | 5 |
| **R5** | O sistema nasce | Move o código da aula 31 para `03-projetos/00-loja-console/`, já com as correções acima. **A partir daqui, toda aula acrescenta algo aqui dentro** | — |

**Entregável da fase:** todas as 40 pastas compilando, e o sistema da loja rodando com cadastro e listagem de produtos, com preço em `BigDecimal` e sem regra de negócio imprimindo em tela.

**Checkpoint:** você explica, sem consultar, por que `variaveisJava.java` com `public class VariaveisJava` não compila, e por que `0.1 + 0.2 != 0.3`.

---

# Fase POO — Orientação a objetos com propósito (semanas 6–15, ~100h)

> **A fase mais importante da trilha**, porque é a sua dificuldade declarada. Cada semana responde a uma pergunta de **decisão** (não de sintaxe: você já sabe escrever classe) e entrega uma funcionalidade nova no sistema da loja.

| Sem. | Pergunta que a aula responde | Conceito | Feature que entra no sistema |
|---|---|---|---|
| **P1** | Como saio do requisito escrito e chego nas classes? E **quando não** criar classe? | Modelagem: entidade × objeto de valor × serviço | `Produto` remodelado + objeto de valor `Dinheiro` |
| **P2** | Como impedir que o objeto entre em estado inválido — por qualquer caminho? | Invariante, construtor que recusa, *Tell Don't Ask*, imutabilidade | Estoque que nunca fica negativo; `adicionarEstoque`/`baixarEstoque` no próprio `Produto` |
| **P3** | Quando herdar e quando compor? Por que herdar por reuso dá errado? | Herança × composição, `sealed`, o teste da frase "é um" | `Cliente` PF e PJ (e a decisão de **não** usar herança para tipo de produto) |
| **P4** | Como trocar uma regra sem alterar quem usa? | Interface como ponto de extensão, **Strategy**, injeção pelo construtor | Formas de pagamento (dinheiro, cartão, Pix) e política de desconto |
| **P5** | Como representar um conjunto fixo de estados com segurança? | `enum` com estado e comportamento, máquina de estados | `StatusVenda` (RASCUNHO → PAGA → ENVIADA → CANCELADA) com transições válidas |
| **P6** | Qual estrutura de dados para cada situação, e quanto custa? | `List` × `Set` × `Map`, custo de busca, `equals`/`hashCode` | Carrinho de compras e catálogo indexado por código |
| **P7** | Como o sistema avisa que algo previsto deu errado? | Exceção de negócio × técnica, checked × unchecked, onde tratar | Hierarquia de exceções da loja + tratamento único na `ui` |
| **P8** | Como escrever um repositório que serve para qualquer entidade? | Generics, `<T extends ...>`, wildcard | `Repositorio<T>` genérico substituindo os repositórios repetidos |
| **P9** | Como extrair informação de uma coleção sem laço aninhado? | `Stream`, `Optional`, `Collectors.groupingBy`, `Comparator` | Relatórios: faturamento por categoria, top 5 produtos, ticket médio |
| **P10** | Como eu **provo** que a regra funciona — inclusive nos casos ruins? | JUnit 5, `assertThrows`, arrange-act-assert, o que **não** testar | Testes das regras críticas: estoque negativo, pagamento inválido, transição de status |

**Entregável da fase:** sistema de loja em Java puro, em camadas, com regras de negócio protegidas, relatórios e testes — rodando no console e pronto para ganhar uma casca web.

**Checkpoint:** você recebe um requisito novo ("a loja quer vender combo com desconto progressivo") e consegue dizer, **antes de codar**, quais classes cria, quais altera, e por quê.

---

# Fase WEB — O mesmo sistema como API REST (semanas 16–23, ~80h)

> Nada é reescrito do zero: o domínio construído na Fase POO ganha uma camada HTTP e um banco de dados. É a transição que a maioria dos cursos pula — e é onde seu [`01-catalogo-api`](../03-projetos/01-catalogo-api/) entra.

| Sem. | Tema | O problema real que motiva |
|---|---|---|
| **W1** | HTTP de verdade: métodos, status, cabeçalhos, idempotência | Um POST repetido por falha de rede criou o pedido duas vezes |
| **W2** | Spring Boot e injeção de dependência | Trocar a forma de pagamento exigiria alterar 12 arquivos |
| **W3** | DTO × entidade, validação na borda | A API vazou campo interno porque devolvia a entidade direto |
| **W4** | Banco de dados e ORM (JPA/Hibernate) | Listar 100 produtos disparou 101 consultas ([N+1](conceitos/orm.md)) |
| **W5** | Migrations com Flyway | O deploy quebrou: a coluna existia na máquina do dev, não em produção |
| **W6** | Erro como contrato da API | Cada endpoint devolvia erro num formato diferente; front não sabia tratar |
| **W7** | Testes de integração com Testcontainers | A correção passou nos testes e quebrou no banco real |
| **W8** | Documentação (OpenAPI) e deploy | "Como eu chamo essa API?" era respondido no chat, toda vez |

**Entregável:** a loja no ar, com URL pública, documentação navegável e banco versionado.

---

# Fase PRO — Segurança, integração e escala (semanas 24–29, ~60h)

Cada tema entra primeiro como laboratório isolado em [`05-laboratorios/`](../05-laboratorios/), depois no sistema.

| Sem. | Tema | Pergunta que responde |
|---|---|---|
| **X1** | Autenticação (senha, sessão × token, JWT) | Como o sistema sabe quem está do outro lado? |
| **X2** | Autorização e RBAC | Como impedir que o estagiário apague a venda de outro cliente? |
| **X3** | Multi-tenant | Como duas lojas usam o mesmo sistema sem uma ver os dados da outra? |
| **X4** | Integrações externas (timeout, retry, circuit breaker) | O gateway de pagamento ficou lento — por que minha API caiu junto? |
| **X5** | Cache e filas | O relatório da home lê 2 milhões de linhas a cada acesso |
| **X6** | Concorrência, transação e observabilidade | Duas vendas simultâneas do último item em estoque: quem leva? |

---

# Fase ARQ — Arquitetura e borda (semanas 30–33 e contínuo)

| Sem. | Tema |
|---|---|
| **A1** | A borda: nginx como proxy reverso e balanceador, rate limit, TLS, o que é *edge* (CDN, gateway, edge compute) |
| **A2** | Fronteiras: monolito modular × microsserviços, DDD tático, arquitetura hexagonal aplicada ao sistema da loja |
| **A3** | CI/CD com GitHub Actions: build, teste, imagem, deploy, rollback |
| **A4** | System design: estimar capacidade, desenhar, defender trade-offs |

**Capstone:** [Rinha de Backend](https://github.com/zanfranceschi/rinha-de-backend-2026) e/ou [CodeCrafters](https://codecrafters.io/) "build your own HTTP server" em Java puro.

---

## Trilha paralela (todas as semanas, sem exceção)

| Quando | O quê | Por quê |
|---|---|---|
| 3× por semana, 45min | Resolução de problemas: [Exercism Java](https://exercism.org/tracks/java) → LeetCode easy | Mantém o músculo de lógica, que é metade da prova técnica |
| Sábado, 1h | Caça ao bug + escrever no [`PROGRESSO.md`](PROGRESSO.md) | Ler código alheio e achar defeito é a habilidade mais cobrada |
| A cada 4 semanas | Simulado: 1 desafio do [backend-br/desafios](https://github.com/backend-br/desafios), cronometrado, **sem IA** | Treina decidir sob pressão com requisito incompleto |

---

## Materiais

**Livros, na ordem em que vão fazer diferença:**
1. *Effective Java* (Bloch) — a partir da Fase POO, um item por semana
2. *Refactoring* (Fowler) — o músculo de melhorar código existente
3. *Domain-Driven Design Distilled* (Vernon) — vocabulário de modelagem
4. *Designing Data-Intensive Applications* (Kleppmann) — Fase ARQ, o livro do arquiteto
5. *System Design Interview* (Alex Xu) — treino de entrevista

**Prática e referência:** [Exercism](https://exercism.org/tracks/java) · [backend-br/desafios](https://github.com/backend-br/desafios) · [roadmap.sh/backend](https://roadmap.sh/backend/project-ideas) · [CodeCrafters](https://codecrafters.io/) · [Spring Guides](https://spring.io/guides) · [Baeldung](https://www.baeldung.com/) · [refactoring.guru (pt-br)](https://refactoring.guru/pt-br)

---

## Índice de aulas escritas

| Aula | Fase | Arquivo |
|---|---|---|
| R1 — Convenções e o build que não roda | R | [`trilha/fase-r/aula-r1-convencoes.md`](trilha/fase-r/aula-r1-convencoes.md) |
| R3 — Dinheiro não é `double` | R | [`trilha/fase-r/aula-r3-dinheiro.md`](trilha/fase-r/aula-r3-dinheiro.md) |
| R4 — Onde o domínio termina e a tela começa | R | [`trilha/fase-r/aula-r4-fronteira-dominio-ui.md`](trilha/fase-r/aula-r4-fronteira-dominio-ui.md) |
| Caça ao bug (kata 09) | R | [`trilha/fase-0/aula-01-caca-ao-bug.md`](trilha/fase-0/aula-01-caca-ao-bug.md) |

As demais são escritas conforme você avança — uma aula por vez, para que ela reflita o que você acabou de aprender e o que travou.
