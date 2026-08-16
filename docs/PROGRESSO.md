# Diário de progresso

Registro semanal. Serve para três coisas: ver evolução quando bater a sensação de estagnação, ter o que contar numa entrevista ("me fala de um problema difícil que você resolveu"), e me obrigar a verbalizar o que aprendi.

**Formato de cada entrada:**

```markdown
## Semana N (dd/mm a dd/mm) — Tema

**O que estudei:**
**Onde travei:** (o mais importante — trave registrada é trave que não volta)
**Como destravei:**
**Decisão tomada:** (se houve, virou ADR? qual?)
**Entregue:** (link do commit/PR)
**Explico sem olhar o código?** sim / ainda não
```

---

## Semana 1 (06/08 a 12/08) — Fase 0: higiene de repositório e reorganização

**O que estudei:**
- O que nunca se versiona: binário compilado (`bin/`, `target/`, `*.class`), config de IDE (`.idea/`, `*.iml`), segredo (`.env`).
- `git mv` renomeia preservando o histórico do arquivo — renomear pasta não apaga o passado.
- Um `.gitignore` que ignora o próprio `.gitignore` faz com que a regra não chegue em quem clona o repositório.

**Onde travei:** _(preencher)_

**Como destravei:** _(preencher)_

**Decisão tomada:**
- reorganização em 5 trilhas → [`ADR-001`](adr/ADR-001-reorganizacao-do-repositorio.md)
- três projetos independentes, e Spring desde o primeiro dia no projeto 01 → [`ADR-002`](adr/ADR-002-tres-projetos-e-spring-desde-o-inicio.md)

**Entregue:**
- Repositório reorganizado: `01-fundamentos`, `02-katas`, `03-projetos`, `04-desafios`, `05-laboratorios`, `docs`
- `.gitignore` corrigido, 9 arquivos `.class` removidos do controle de versão
- `03-projetos/01-catalogo-api` voltou a buildar (tinha `mvnw` e `src`, mas **não tinha `pom.xml`** — por isso nunca compilou)
- Trilha de estudos escrita: [`TRILHA.md`](TRILHA.md) e [`METODO.md`](METODO.md)

**Entregue (08/08):**
- Aula 03 reescrita como **Variáveis e tipos de dados**, absorvendo a antiga aula 30; métodos de `String` consolidados na aula 16
- Nova **aula 17 — Métodos e modularização**, preenchendo o salto que existia entre o `main` e as classes
- Fundamentos renumerados: antigas 17–29 viraram 18–30 ([de-para](AUDITORIA.md#de-para-da-renumeração-de-08082026))
- `03-projetos/` realinhado: `01-loja`, `02-taskmanager`, `03-produto-a-definir`, cada um com README próprio e um [índice](../03-projetos/) comentado
- Três propostas escritas para o projeto 03 — decisão pendente

**Explico sem olhar o código?** _(preencher)_

---

## Auditoria do conteúdo existente (06/08)

Antes de montar a trilha nova, todo o conteúdo foi auditado — compilação de todas as 40 pastas, varredura de padrões e leitura do código sinalizado. Resultado completo em [`AUDITORIA.md`](AUDITORIA.md).

**O placar que interessa:**

| Métrica | Antes da Fase R | Meta |
|---|---|---|
| Pastas que compilam | **20 de 40** | 40 de 40 |
| Arquivos com nome ≠ classe | 22 | 0 |
| Pastas com dinheiro em `double` | 15 | 0 nas que têm regra de negócio |
| Domínio imprimindo no console | 11 arquivos | 0 nas 3 aulas priorizadas |

**A causa da maior parte:** o commit que padronizou os nomes das classes para `PascalCase` não renomeou os arquivos, e o Windows escondeu o erro por ser *case-insensitive*.

**O que a auditoria diz de bom:** nenhum `catch` vazio, nenhum recurso vazando, nenhum algoritmo errado. Os problemas são de convenção e de modelagem — e em vários pontos (aula 31, katas 05 e 08) o padrão correto **já está aplicado**, o que mostra que o conhecimento chegou depois e o conteúdo antigo nunca foi revisitado.

---

## Próximos passos

| Semana | Aula | Arquivo |
|---|---|---|
| 1 | R1 — Convenções e o build que não roda | [`trilha/fase-r/aula-r1-convencoes.md`](trilha/fase-r/aula-r1-convencoes.md) |
| 2 | R2 — Base rápida (aulas 01–16) + caça ao bug | [`trilha/fase-0/aula-01-caca-ao-bug.md`](trilha/fase-0/aula-01-caca-ao-bug.md) |
| 3 | R3 — Dinheiro não é `double` | [`trilha/fase-r/aula-r3-dinheiro.md`](trilha/fase-r/aula-r3-dinheiro.md) |
| 4 | R4 — Onde o domínio termina e a tela começa | [`trilha/fase-r/aula-r4-fronteira-dominio-ui.md`](trilha/fase-r/aula-r4-fronteira-dominio-ui.md) |
| 5 | R5 — O sistema nasce | [`01-loja`](../03-projetos/01-loja/) |
