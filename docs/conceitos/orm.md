# ORM — Object-Relational Mapping

## 1. Que problema real fez isso existir

Você tem uma tabela `product` com colunas `id`, `name`, `price`, `created_at`. E tem uma classe `Product` com os atributos correspondentes. Toda vez que quer salvar, precisa escrever isto:

```java
String sql = "INSERT INTO product (name, description, price) VALUES (?, ?, ?)";
try (Connection conn = dataSource.getConnection();
     PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    ps.setString(1, product.getName());
    ps.setString(2, product.getDescription());
    ps.setBigDecimal(3, product.getPrice());
    ps.executeUpdate();
    try (ResultSet keys = ps.getGeneratedKeys()) {
        if (keys.next()) product.setId(keys.getLong(1));
    }
}
```

E o mesmo trabalho, invertido, para ler. Multiplique por 30 tabelas, com relacionamento entre elas. O problema não é a dificuldade — é a **repetição e o erro silencioso**: trocar a ordem de `ps.setString(1, ...)` e `ps.setString(2, ...)` compila, sobe e grava descrição no lugar do nome.

Esse descompasso entre o mundo de objetos (herança, referência, grafo) e o mundo relacional (tabela, linha, chave estrangeira) tem nome: *object-relational impedance mismatch*.

## 2. O que se fazia antes

JDBC puro, como acima — e ainda se faz, quando a consulta é complexa. Depois vieram camadas intermediárias: template de JDBC (Spring `JdbcTemplate`), mapeadores explícitos (MyBatis), e por fim os ORMs completos (Hibernate, EclipseLink).

## 3. O que é, em uma frase

**ORM é uma camada que traduz automaticamente entre objetos e linhas de tabela** — você manipula objetos, ela gera o SQL.

Em Java: **JPA** é a especificação (o contrato, as anotações `@Entity`, `@Id`, `@ManyToOne`) e **Hibernate** é a implementação que faz o trabalho. Spring Data JPA é uma camada acima que gera até o repositório para você.

```java
@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
}

// e a persistência inteira vira:
productRepository.save(product);
```

## 4. Onde isso aparece num sistema

- **Camada:** repositório/persistência — a fronteira entre o domínio e o banco
- **Arquivos:** classes anotadas com `@Entity`; interfaces `extends JpaRepository<Product, Long>`; `application.yml` com `spring.jpa.*`
- **Quem manda no schema:** **não é o ORM.** É o [Flyway](../GLOSSARIO.md). Em projeto sério, `spring.jpa.hibernate.ddl-auto: validate` — o Hibernate só confere se o schema bate com as entidades; quem cria coluna é a migration versionada.
- **Numa vaga:** "experiência com JPA/Hibernate" aparece em praticamente toda vaga Java backend. O que separa júnior de pleno é saber o item 5 abaixo.

## 5. Como eu erro isso na prática

| Erro | O que acontece | Como evitar |
|---|---|---|
| **N+1** | Listar 100 pedidos dispara 1 + 100 consultas porque cada `pedido.getCliente()` vai ao banco | Ligar o log de SQL e **contar as queries**; usar `JOIN FETCH` ou `@EntityGraph` |
| **`ddl-auto: update` em produção** | O Hibernate altera o schema sozinho; um dia ele decide dropar algo | `validate` + migrations Flyway |
| **`FetchType.EAGER` em tudo** | Buscar um produto arrasta meio banco junto | `LAZY` por padrão, e busca explícita quando precisar |
| **Entidade virando DTO** | A entidade sai direto no JSON: expõe campo interno e, com `LAZY`, estoura `LazyInitializationException` | Entidade nunca cruza a borda da API — converta para DTO |
| **`equals`/`hashCode` gerados com o `id`** | Antes de salvar o `id` é `null`; dentro de um `Set` o objeto "some" | Usar chave de negócio, ou seguir a recomendação da própria doc do Hibernate |
| **Achar que ORM dispensa saber SQL** | Consulta de relatório fica 40× mais lenta e você não sabe ler o plano de execução | ORM é para o CRUD do dia a dia; relatório complexo se escreve em SQL |

**A regra que resume:** o ORM economiza o trabalho chato, mas **não** te livra de entender o banco. Quem usa ORM sem saber SQL escreve sistema lento e não sabe por quê.

## 6. Como praticar

Laboratório sugerido (`05-laboratorios/orm-e-n-mais-1/`):

1. Suba um Postgres com Docker e crie duas tabelas com relacionamento (`pedido` e `cliente`).
2. Popule com 200 pedidos.
3. Escreva a listagem **sem** `JOIN FETCH`, ligue `logging.level.org.hibernate.SQL: DEBUG` e conte as queries no console. Anote o número.
4. Reescreva com `JOIN FETCH`. Conte de novo. Anote os dois números no README do laboratório.
5. Escreva a mesma consulta em SQL puro e compare o tempo.

Você só entendeu N+1 quando conseguiu **provocá-lo de propósito**.

## Material

- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/)
- [Hibernate ORM User Guide](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html)
- Vlad Mihalcea — [blog sobre performance com Hibernate](https://vladmihalcea.com/blog/) (referência para o assunto)
