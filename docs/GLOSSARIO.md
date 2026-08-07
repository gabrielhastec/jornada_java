# Glossário

Termos que aparecem em vaga, code review e reunião técnica — e que curso e faculdade quase nunca explicam. Cada verbete responde: **o que é**, **qual problema resolve** e **onde eu vou esbarrar nisso**.

Ordem alfabética. Verbetes com ficha completa em [`conceitos/`](conceitos/) estão linkados.

---

**ACID** — Garantias de uma transação de banco: Atomicidade (tudo ou nada), Consistência, Isolamento (uma transação não enxerga a metade da outra), Durabilidade. *Problema que resolve:* dinheiro sair de uma conta e não entrar na outra. *Onde vejo:* `@Transactional` no serviço.

**ADR (Architecture Decision Record)** — Documento curto que registra uma decisão de arquitetura, as alternativas consideradas e as consequências. *Problema:* daqui a 6 meses ninguém lembra por que escolheram Postgres. *Onde vejo:* pasta `docs/adr/` em repositórios maduros.

**API Gateway** — Porta única na frente de vários serviços: roteia, autentica, aplica rate limit, agrega respostas. *Problema:* cada cliente ter que conhecer 12 endereços internos. *Onde vejo:* Kong, AWS API Gateway, nginx fazendo esse papel.

**Bean Validation** — Validação declarativa por anotação (`@NotBlank`, `@Positive`, `@Email`). *Problema:* `if` de validação espalhado por todo canto. *Onde vejo:* no DTO de entrada de um controller Spring.

**Circuit breaker** — Componente que "abre o circuito" e para de chamar um serviço que está falhando, devolvendo erro rápido. *Problema:* um serviço lento segura todas as threads e derruba o seu sistema junto (falha em cascata). *Onde vejo:* Resilience4j.

**CI/CD** — Integração contínua (todo push roda build e testes) e entrega contínua (o que passa vai para produção automaticamente). *Problema:* "funciona na minha máquina" e deploy manual às sextas. *Onde vejo:* GitHub Actions, GitLab CI, Jenkins.

**CORS** — Regra do navegador que decide se um site pode chamar sua API de outro domínio. *Problema:* front em `app.exemplo.com` chamando API em `api.exemplo.com` sem virar buraco de segurança. *Onde vejo:* erro no console do navegador que **não** é bug do front — é config do backend.

**DTO (Data Transfer Object)** — Objeto que representa o que entra e sai da API, separado da entidade do banco. *Problema:* devolver a entidade direto expõe campo interno (hash de senha) e trava o schema do banco ao contrato público. *Onde vejo:* `ProductRequest` / `ProductResponse`.

**Edge (borda)** — A camada mais próxima do usuário, antes do seu servidor: CDN, proxy reverso, WAF, API gateway, edge compute. *Problema:* latência (o dado viaja meio mundo), tráfego malicioso e carga desnecessária chegando na aplicação. *Onde vejo:* Cloudflare, nginx na frente da app, `X-Forwarded-For` no header.

**Flyway / Liquibase** — Ferramenta de *migration*: versiona a evolução do schema do banco em arquivos numerados. *Problema:* a coluna existe na máquina do dev e não em produção. *Onde vejo:* `src/main/resources/db/migration/V1__create-table-product.sql`.

**Idempotência** — Propriedade de uma operação que, repetida com a mesma entrada, produz o mesmo resultado — sem duplicar efeito. *Problema:* o celular do cliente perdeu sinal, o app reenviou o POST, e a cobrança saiu duas vezes. *Onde vejo:* header `Idempotency-Key` em API de pagamento; `PUT` é idempotente, `POST` não é.

**JPA / Hibernate** — Especificação (JPA) e implementação (Hibernate) de [ORM](conceitos/orm.md) em Java. *Onde vejo:* `@Entity`, `@Id`, `JpaRepository`.

**JWT (JSON Web Token)** — Token assinado que carrega quem é o usuário e vale por tempo limitado. *Problema:* manter sessão sem o servidor guardar estado. *Cuidado:* é **assinado**, não criptografado — qualquer um lê o conteúdo. Nunca coloque dado sensível dentro.

**LGPD** — Lei brasileira de proteção de dados. *Problema prático para o dev:* log com CPF, e-mail e telefone em texto plano é vazamento. *Onde vejo:* mascaramento de dado em log, política de retenção, direito ao esquecimento.

**Migration** — Ver *Flyway*. Cada alteração de schema é um arquivo versionado, aplicado em ordem, igual em todos os ambientes.

**Monorepo** — Vários projetos no mesmo repositório, com ferramenta que entende as dependências entre eles (Nx, Turborepo, Bazel). *Problema:* mudança que atravessa front e back em 2 PRs diferentes que precisam subir juntos. *Onde vejo:* Nx num monorepo Angular + Node.

**N+1 (problema de consulta)** — Buscar 100 pedidos (1 consulta) e, para cada um, buscar o cliente (mais 100 consultas). *Problema:* a tela abre em 8 segundos e ninguém entende por quê. *Onde vejo:* JPA com relacionamento `LAZY` acessado dentro de laço; ligue o log de SQL e conte as queries.

**nginx** — Servidor web usado como *reverse proxy*: recebe a requisição do mundo, distribui entre instâncias da sua aplicação (load balancer), termina TLS, aplica rate limit, serve arquivo estático. *Problema:* uma instância só não aguenta, e você não quer expor sua aplicação direto na internet. *Onde vejo:* na frente de praticamente todo backend em produção.

**Observabilidade** — Conseguir responder "o que aconteceu com o pedido 4821 às 3h?" só com o que o sistema emite: logs estruturados, métricas e traces. *Problema:* debugar produção por adivinhação. *Onde vejo:* correlation id propagado entre serviços, Grafana, OpenTelemetry.

**OpenAPI / Swagger** — Especificação legível por máquina do contrato da sua API, que gera documentação e clientes. *Problema:* "como eu chamo esse endpoint?" respondido no chat, sempre. *Onde vejo:* `/swagger-ui.html` num projeto Spring.

**ORM** — Ver a ficha completa em [`conceitos/orm.md`](conceitos/orm.md).

**Problem Details (RFC 7807)** — Formato padrão de resposta de erro em API (`type`, `title`, `status`, `detail`). *Problema:* cada endpoint devolvendo erro num formato diferente. *Onde vejo:* `ProblemDetail` no Spring 6+.

**RBAC (Role-Based Access Control)** — Autorização por papel: o usuário tem papéis (`ADMIN`, `GERENTE`), papéis têm permissões, a permissão libera a operação. *Problema:* estagiário conseguir deletar nota fiscal. *Diferença para ABAC:* ABAC decide por atributo ("só o dono do registro"), RBAC decide por papel. *Onde vejo:* `@PreAuthorize("hasRole('ADMIN')")`.

**Rate limit** — Teto de requisições por cliente num intervalo. *Problema:* um cliente mal configurado (ou um ataque) consumindo todo o servidor. *Onde vejo:* nginx, API gateway, resposta HTTP 429.

**Retry com backoff** — Tentar de novo esperando um intervalo crescente. *Problema:* retry imediato e infinito transforma uma falha pequena em ataque contra o seu próprio serviço. *Cuidado:* só faça retry de operação **idempotente**.

**Testcontainers** — Biblioteca que sobe um banco real em Docker durante o teste. *Problema:* testar contra H2 em memória e quebrar em produção porque o Postgres se comporta diferente. *Onde vejo:* teste de integração de repositório.

**Tenant / multi-tenant** — Um mesmo sistema atendendo vários clientes (tenants) com dados isolados. *Estratégias:* banco por tenant, schema por tenant, ou coluna `tenant_id` em toda tabela. *Problema:* o cliente A ver o relatório do cliente B — o bug mais caro que existe em SaaS. *Onde vejo:* qualquer produto B2B.

**Transação / lock otimista × pessimista** — Otimista: assume que ninguém mais vai mexer e confere na hora de salvar (`@Version`). Pessimista: tranca a linha no banco. *Problema:* duas transferências simultâneas lendo o mesmo saldo e gravando valores diferentes (*race condition*).

**Webhook** — O serviço externo chama **você** quando algo acontece, em vez de você ficar perguntando. *Problema:* ficar consultando "o pagamento aprovou?" a cada 5 segundos. *Cuidado:* todo webhook precisa de validação de assinatura e tratamento idempotente — ele chega repetido.
