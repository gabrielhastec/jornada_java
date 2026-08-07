# Jornada Java — do fundamento à arquitetura de sistemas

Repositório público da minha formação em engenharia de software com Java. Não é um repositório de "aulas copiadas": cada pasta aqui existe para provar uma habilidade específica — modelar um domínio, construir uma API que aguenta produção, achar um bug em código alheio, defender uma decisão de arquitetura.

**Objetivo:** atuar como engenheiro de software backend e, no médio prazo, como arquiteto de soluções — sabendo construir e defender um sistema de ponta a ponta, não apenas escrever classes.

**Stack atual:** Java 21 · Spring Boot · Maven · PostgreSQL · Flyway · Docker · Git

---

## Como este repositório é organizado

| Trilha | O que é | Para que serve |
|---|---|---|
| [`01-fundamentos/`](01-fundamentos/) | 31 aulas de base da linguagem, do `System.out.println` a generics e exceções | Registro da base. Cada aula tem README próprio |
| [`02-katas/`](02-katas/) | 9 exercícios com domínio de negócio (folha de pagamento, análise de crédito, caixa eletrônico, conta bancária) | Onde os conceitos viram regra de negócio |
| [`03-projetos/`](03-projetos/) | Sistemas de ponta a ponta, cada um com seu build, banco, testes e deploy | O portfólio de verdade |
| [`04-desafios/`](04-desafios/) | Desafios técnicos de mercado resolvidos com tempo cronometrado e sem IA | Simulação de prova técnica |
| [`05-laboratorios/`](05-laboratorios/) | Experimentos curtos e isolados: nginx, JWT, Redis, multi-tenant, filas | Aprender uma peça de infraestrutura por vez, antes de usá-la num projeto |
| [`docs/`](docs/) | Trilha de estudos, glossário, fichas de conceito e decisões de arquitetura (ADRs) | O "porquê" de tudo que está aqui |

---

## Projetos

| Projeto | Domínio | O que demonstra | Status |
|---|---|---|---|
| [00 — Sistema da Loja (console)](03-projetos/00-loja-console/) | Varejo | **O sistema que cresce a cada aula**: modelagem, invariantes, Strategy, coleções, exceções, generics, testes | 🌱 nasce na aula R5 |
| [01 — Catálogo API](03-projetos/01-catalogo-api/) | E-commerce | O mesmo domínio como API REST: JPA/Hibernate, Flyway, PostgreSQL, Docker, erro padronizado, OpenAPI | 🚧 branch `feat/catalogo-api` |
| 02 — Gestão de equipes | SaaS B2B | Autenticação JWT, RBAC, multi-tenant, isolamento de dados | ⏳ planejado |
| 03 — Núcleo de pagamentos | Financeiro | Idempotência, concorrência, transações, auditoria, testes de regra de negócio | ⏳ planejado |
| 04 — Integrador + notificações | Integração | API externa, retry/circuit breaker, cache (Redis), fila (RabbitMQ), agendamento | ⏳ planejado |
| 05 — Capstone de carga | Performance | nginx como load balancer, réplicas, limite de CPU/memória, medição sob carga | ⏳ planejado |

---

## Trilha de estudos

O plano completo está em **[`docs/TRILHA.md`](docs/TRILHA.md)**. Ele começa por uma **revisão auditada de todo o conteúdo que já existe** ([`docs/AUDITORIA.md`](docs/AUDITORIA.md)) e usa um princípio único: cada aula acrescenta uma funcionalidade ao mesmo sistema.
O método de cada aula (e as regras de uso de IA no estudo) está em **[`docs/METODO.md`](docs/METODO.md)**.
O diário, com o que travou e o que foi decidido a cada semana, está em **[`docs/PROGRESSO.md`](docs/PROGRESSO.md)**.

| Fase | Foco | Situação |
|---|---|---|
| R — Revisão | Corrigir o que a auditoria encontrou, base rápida, dinheiro e camadas | 🚧 em andamento |
| POO — Orientação a objetos com propósito | Modelagem, invariantes, composição, Strategy, coleções, exceções, generics, testes | ⏳ |
| WEB — O mesmo sistema como API | HTTP, Spring Boot, DTO, ORM, migrations, Docker, deploy | ⏳ |
| PRO — Segurança, integração e escala | JWT, RBAC, multi-tenant, cache, filas, concorrência, observabilidade | ⏳ |
| ARQ — Arquitetura e borda | nginx, edge, DDD tático, hexagonal, CI/CD, system design | ⏳ |

---

## Como rodar o código

**Fundamentos e katas** (Java puro, sem build tool — abra a pasta na IDE ou compile na mão):

```bash
cd 02-katas/09-conta-bancaria && javac -d out $(find src -name "*.java") && java -cp out application.App
```

**Projetos** (Maven + Docker):

```bash
cd 03-projetos/01-catalogo-api && docker compose up -d && mvn spring-boot:run
```

---

## Contato

- GitHub: [@gabrielhastec](https://github.com/gabrielhastec)
- LinkedIn: _(preencher)_
