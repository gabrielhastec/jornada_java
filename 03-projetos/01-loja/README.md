# Projeto 01 — Loja

**O sistema que cresce a cada aula.** Cada semana da [trilha](../../docs/TRILHA.md) acrescenta uma funcionalidade aqui dentro. Começa como um CRUD de produtos e termina como um e-commerce com carrinho, pagamento, estoque protegido e relatórios.

> **Status:** 🌱 esqueleto Spring Boot de pé (`com.loja.api`, JPA + H2). O sistema nasce de verdade na **aula R5**, quando o domínio corrigido nas aulas R1–R4 entra aqui.

**Stack:** Java 21 · Spring Boot 4.1 · Maven · JPA/Hibernate · H2 (depois PostgreSQL)

## Por que este projeto existe

Estudar por tópico solto (uma aula de `ArrayList`, uma de exceções) ensina sintaxe, mas não ensina **quando usar**. Aqui é o contrário: primeiro aparece uma necessidade do sistema — *"o carrinho precisa achar o produto pelo código sem varrer a lista inteira"* — e o recurso da linguagem entra como resposta.

Ao final da trilha o resultado não é uma pasta com 30 exercícios soltos, e sim **um sistema completo**, que continua evoluindo depois que a trilha acaba.

## O domínio

Uma loja que quer vender online: catálogo de produtos e estoque, clientes, carrinho, pedido, formas de pagamento, descontos e relatórios.

**Por que esse domínio:** tem dinheiro (que não pode errar um centavo), tem estoque (que não pode ficar negativo), tem regra que muda com o tempo (desconto, forma de pagamento) e tem histórico para relatar. É o conjunto de problemas que aparece em qualquer sistema comercial real.

## A decisão que define este projeto: Spring desde o primeiro dia

O CRUD já nasce como **API REST**, e não como programa de console. A consequência precisa ficar explícita, porque ela contraria o caminho mais comum de curso:

**O framework fica na borda. O domínio é Java puro.**

```
HTTP  →  controller  →  service  →  domain        ← Java puro, sem anotação de framework
                            ↓
                       repository  →  banco
```

`Produto`, `Dinheiro`, `StatusPedido` e as regras de negócio são classes Java comuns: sem `@Entity`, sem `@Autowired`, sem `import org.springframework`. Elas são testáveis sem subir a aplicação, e continuariam funcionando se o Spring fosse trocado amanhã.

**Por que isso importa aqui:** a Fase POO da trilha ensina modelagem, invariante, composição e polimorfismo. Se esses conceitos forem aprendidos misturados com anotação de framework, o que fica é "decorei onde põe a anotação" — que é exatamente o problema que esta trilha existe para resolver. Mantendo o domínio limpo, dá para aprender POO de verdade **e** ter um sistema que roda e responde HTTP no mesmo dia.

> ⚠️ **O que existe hoje contraria essa regra.** `domain/model/Usuario` é uma `@Entity` JPA com Lombok — ou seja, o domínio conhece o banco. Isso é normal em projeto Spring pequeno e é uma escolha defensável, mas é uma escolha: na aula **P1** essa fronteira é discutida e decidida de forma consciente (entidade de domínio × entidade de persistência), e a decisão vira ADR.

## Roteiro de funcionalidades

Cada linha é uma aula da [trilha](../../docs/TRILHA.md). A coluna "conceito" mostra o que a aula ensina; a coluna "funcionalidade" mostra o que entra no sistema.

### Fase R — o sistema nasce

| Aula | Conceito | Funcionalidade que entra |
|---|---|---|
| **R5** | Spring Boot mínimo, camadas, injeção de dependência | `POST /produtos` e `GET /produtos` funcionando, com `Produto` em Java puro, preço em `BigDecimal` e nenhum `System.out` no domínio |

### Fase POO — a regra de negócio aparece

| Aula | Conceito | Funcionalidade que entra |
|---|---|---|
| **P1** | Entidade × objeto de valor × serviço | `Produto` remodelado, objeto de valor `Dinheiro`, e a decisão sobre domínio × entidade JPA |
| **P2** | Invariante, construtor que recusa, *Tell Don't Ask* | Estoque que nunca fica negativo; `baixarEstoque`/`repor` dentro do próprio `Produto` |
| **P3** | Herança × composição, o teste da frase "é um" | `Cliente` pessoa física e jurídica |
| **P4** | Interface como ponto de extensão, **Strategy** | Formas de pagamento (dinheiro, cartão, Pix) e política de desconto |
| **P5** | `enum` com estado e comportamento | `StatusPedido` com transições válidas (RASCUNHO → PAGO → ENVIADO → CANCELADO) |
| **P6** | `List` × `Set` × `Map`, `equals`/`hashCode` | Carrinho de compras e catálogo indexado por código |
| **P7** | Exceção de negócio × técnica | Hierarquia de exceções da loja + `@RestControllerAdvice` traduzindo para HTTP |
| **P8** | Generics | `Repositorio<T>` genérico no lugar dos repositórios repetidos |
| **P9** | `Stream`, `Optional`, `Collectors` | Relatórios: faturamento por categoria, top 5 produtos, ticket médio |
| **P10** | JUnit 5, `assertThrows` | Testes das regras críticas: estoque negativo, pagamento inválido, transição de status |

### Fase WEB — a API endurece para produção

| Aula | Conceito | Funcionalidade que entra |
|---|---|---|
| **W1** | HTTP a sério: métodos, status, idempotência | Endpoints revisados; `POST` repetido para de duplicar pedido |
| **W2** | Spring Boot a fundo: DI, escopos, configuração | O que a R5 usou por necessidade, agora entendido por inteiro |
| **W3** | DTO × entidade, validação na borda | A API para de devolver a entidade crua; `@Valid` na entrada |
| **W4** | Banco e ORM (JPA/Hibernate) | PostgreSQL no lugar do H2; o [N+1](../../docs/conceitos/orm.md) caçado e corrigido |
| **W5** | Migrations com Flyway | Esquema versionado, `V1__create-table-produto.sql` |
| **W6** | Erro como contrato da API | Formato único de erro em todos os endpoints |
| **W7** | Testes de integração com Testcontainers | Regras provadas contra um Postgres de verdade |
| **W8** | OpenAPI e deploy | Documentação navegável e a loja no ar com URL pública |

## Estrutura

```
01-loja/
├── pom.xml
├── docker-compose.yml              Postgres de desenvolvimento (usado a partir da W4)
├── api.http                        requisicoes prontas para testar a API
├── README.md
└── src/
    ├── main/java/com/loja/api/
    │   ├── ApiApplication.java     ponto de entrada
    │   ├── domain/                 entidades, objetos de valor e regras — o coracao
    │   ├── repository/             portas de persistencia (Spring Data)
    │   ├── service/                casos de uso que coordenam o dominio
    │   ├── controller/             borda HTTP
    │   ├── dto/                    o que entra e sai da API
    │   └── exception/              excecoes de negocio e o tratamento unico
    ├── main/resources/
    │   ├── application.properties          perfil padrao — H2 em memoria
    │   ├── application-postgres.yml        perfil "postgres" — inativo ate a W4
    │   └── db/migration/                   esquema versionado (Flyway, a partir da W5)
    └── test/java/com/loja/api/
```

A dependência sempre aponta para dentro: `controller` → `service` → `domain`. O `domain` não conhece ninguém.

## Infraestrutura recuperada

`docker-compose.yml`, `api.http`, `application-postgres.yml` e `db/migration/V1__create-table-product.sql` vieram do antigo `catalogo-api` (commit `ea0bd29`), adaptados de `catalogo` para `loja`.

Eles estão aqui **desligados de propósito**: a aplicação continua subindo com H2, e o perfil `postgres` só entra na aula **W4**, quando o `pom.xml` ganhar o driver do PostgreSQL e o Flyway. O arquivo explica no cabeçalho o que falta.

> O `ProductController` daquele projeto **não** foi trazido: escrevê-lo é o exercício da aula R5. Se quiser consultá-lo: `git show ea0bd29:03-projetos/01-catalogo-api/src/main/java/com/jornada/api/controllers/ProductController.java`

## Como rodar

```bash
cd 03-projetos/01-loja && ./mvnw spring-boot:run
```

Console do H2 (enquanto o banco for em memória): `http://localhost:8080/h2-console`

A partir da W4, com Postgres:

```bash
cd 03-projetos/01-loja && docker compose up -d && ./mvnw spring-boot:run -Dspring-boot.run.profiles=postgres
```

## Regras deste projeto

1. **Todo código aqui é escrito por mim.** IA em modo instrutor e revisor, nunca gerando o código — ver [`METODO.md`](../../docs/METODO.md).
2. **Cada funcionalidade entra com o conceito que a motivou.** Nada de usar `Stream` na aula P2 só porque é mais bonito: o recurso entra quando a aula dele chega.
3. **Nada é reescrito do zero.** A cada aula, o código anterior é refatorado.
4. **O domínio não importa `org.springframework`.** Quando precisar quebrar essa regra, quebra — mas por escrito, num [ADR](../../docs/adr/).
5. **Dinheiro é `BigDecimal`.** Sem exceção.

## Diário de evolução

| Data | Aula | O que entrou |
|---|---|---|
| — | R5 | _(a preencher quando o sistema nascer)_ |
