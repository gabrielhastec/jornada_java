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
| [`03-projetos/`](03-projetos/) | Sistemas de ponta a ponta, em cenários diferentes, cada um com seu build, banco, testes e deploy | O portfólio de verdade |
| [`04-desafios/`](04-desafios/) | Desafios técnicos de mercado resolvidos com tempo cronometrado e sem IA | Simulação de prova técnica |
| [`05-laboratorios/`](05-laboratorios/) | Experimentos curtos e isolados: nginx, JWT, Redis, multi-tenant, filas | Aprender uma peça de infraestrutura por vez, antes de usá-la num projeto |
| [`docs/`](docs/) | Trilha de estudos, glossário, fichas de conceito e decisões de arquitetura (ADRs) | O "porquê" de tudo que está aqui |

---

## Projetos

Projetos em cenários diferentes. Cada um tem um motor próprio: um é guiado pela trilha, um por um curso, e um é escolha minha do começo ao fim. O índice comentado está em [`03-projetos/`](03-projetos/).

| Projeto | Domínio | O que demonstra | Motor | Status |
|---|---|---|---|---|
| [01 — Loja](03-projetos/01-loja/) | Varejo → e-commerce | **O sistema que cresce a cada aula**: modelagem, invariantes, Strategy, coleções, exceções, generics, testes, e a API endurecida para produção | Trilha | 🌱 nasce na aula R5 |
| [02 — Task Manager](03-projetos/02-taskmanager/) | Produtividade | Java moderno (`record`, `enum`), Spring Boot 4, Gradle, entidade com comportamento | Curso Santander/DIO | 🚧 domínio iniciado |
| [03 — (a definir)](03-projetos/03-produto-a-definir/) | Produto próprio | Autonomia: escolher o problema, modelar e entregar — [3 propostas na mesa](03-projetos/03-produto-a-definir/) | Meu | 💡 decisão pendente |

> Os temas que antes estavam listados como projetos separados (pagamentos, integrações, carga) não sumiram: eles entram como **fases dos projetos 01 e 03** e como experimentos isolados em [`05-laboratorios/`](05-laboratorios/). Um sistema levado longe prova mais que cinco começados.

---

## Trilha de estudos

O plano completo está em **[`docs/TRILHA.md`](docs/TRILHA.md)**. Ele começa por uma **revisão auditada de todo o conteúdo que já existe** ([`docs/AUDITORIA.md`](docs/AUDITORIA.md)) e usa um princípio único: cada aula acrescenta uma funcionalidade ao mesmo sistema.
O método de cada aula (e as regras de uso de IA no estudo) está em **[`docs/METODO.md`](docs/METODO.md)**.
O diário, com o que travou e o que foi decidido a cada semana, está em **[`docs/PROGRESSO.md`](docs/PROGRESSO.md)**.

| Fase | Foco | Situação |
|---|---|---|
| R — Revisão | Corrigir o que a auditoria encontrou, base rápida, dinheiro e camadas | 🚧 em andamento |
| POO — Orientação a objetos com propósito | Modelagem, invariantes, composição, Strategy, coleções, exceções, generics, testes | ⏳ |
| WEB — A API endurecida para produção | HTTP a sério, DTO, ORM, migrations, Docker, deploy | ⏳ |
| PRO — Segurança, integração e escala | JWT, RBAC, multi-tenant, cache, filas, concorrência, observabilidade | ⏳ |
| ARQ — Arquitetura e borda | nginx, edge, DDD tático, hexagonal, CI/CD, system design | ⏳ |

---

## Como rodar o código

**Fundamentos e katas** (Java puro, sem build tool — abra a pasta na IDE ou compile na mão):

```bash
cd 02-katas/09-conta-bancaria && javac -d out $(find src -name "*.java") && java -cp out application.App
```

**Projetos** (Spring Boot — Maven no 01, Gradle no 02):

```bash
cd 03-projetos/01-loja && ./mvnw spring-boot:run
```

```bash
cd 03-projetos/02-taskmanager && ./gradlew bootRun
```

---

## Contato

- GitHub: [@gabrielhastec](https://github.com/gabrielhastec)
- LinkedIn: gabrielhastec
