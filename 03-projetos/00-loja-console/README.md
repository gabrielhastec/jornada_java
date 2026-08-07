# Projeto 00 — Sistema de Gestão da Loja (console)

**O sistema que cresce a cada aula.** Cada semana da [trilha](../../docs/TRILHA.md) acrescenta uma funcionalidade aqui dentro. No fim da Fase POO, isto é um sistema de loja completo em Java puro; na Fase WEB, este mesmo domínio ganha uma casca HTTP e vira o [`01-catalogo-api`](../01-catalogo-api/).

> **Status:** 🌱 nasce na aula R5, a partir do código das aulas 30 e 31 já corrigido nas aulas R1–R4.

## Por que este projeto existe

Estudar por tópico solto (uma aula de `ArrayList`, uma de exceções) ensina sintaxe, mas não ensina **quando usar**. Aqui é o contrário: primeiro aparece uma necessidade do sistema ("o carrinho precisa achar o produto pelo código rapidamente"), e o recurso da linguagem entra como resposta.

É o mesmo modelo que funcionou na trilha de JavaScript: ao final do curso, existe um sistema pronto para o portfólio — e não uma pasta de exercícios.

## O domínio

Uma loja de bairro que quer informatizar: cadastro de produtos e estoque, clientes, vendas, formas de pagamento, descontos e relatórios.

**Por que esse domínio foi escolhido:** tem dinheiro (que não pode errar centavo), tem estoque (que não pode ficar negativo), tem regra que muda com o tempo (desconto, forma de pagamento) e tem histórico para relatar. É o conjunto de problemas que aparece em qualquer sistema comercial real — e é o mesmo domínio do projeto web da Fase WEB, então nada aqui é jogado fora.

## Roteiro de funcionalidades

Cada linha é uma aula. A coluna "conceito" mostra o que a aula ensina; a coluna "funcionalidade" mostra o que entra no sistema.

| Aula | Conceito | Funcionalidade que entra |
|---|---|---|
| **R5** | Camadas, organização de pacotes | Base: cadastrar e listar produtos, já com `BigDecimal` e sem `System.out` no domínio |
| **P1** | Modelagem: entidade × objeto de valor | `Produto` remodelado, objeto de valor `Dinheiro` |
| **P2** | Invariantes e encapsulamento real | Estoque que nunca fica negativo; `baixarEstoque`/`repor` dentro do `Produto` |
| **P3** | Herança × composição | `Cliente` pessoa física e jurídica |
| **P4** | Interface e Strategy | Formas de pagamento (dinheiro, cartão, Pix) e políticas de desconto |
| **P5** | Enum com comportamento | `StatusVenda` com transições válidas (RASCUNHO → PAGA → ENVIADA → CANCELADA) |
| **P6** | Coleções e `equals`/`hashCode` | Carrinho de compras e catálogo indexado por código |
| **P7** | Exceções de negócio | Hierarquia de exceções da loja, tratadas num ponto só |
| **P8** | Generics | `Repositorio<T>` genérico no lugar dos repositórios repetidos |
| **P9** | Streams e Optional | Relatórios: faturamento por categoria, top 5 produtos, ticket médio |
| **P10** | Testes com JUnit 5 | Testes das regras críticas de estoque, pagamento e status |
| **Fase WEB** | HTTP, Spring, banco | O mesmo domínio exposto como API REST |

## Estrutura

```
00-loja-console/
├── README.md
└── src/
    ├── domain/        entidades e objetos de valor — nao conhecem tela nem banco
    ├── service/       regras que coordenam mais de uma entidade
    ├── repository/    guarda e recupera (por enquanto, em memoria)
    ├── ui/            menus e impressao no console
    └── Main.java      ponto de entrada
```

A dependência sempre aponta para dentro: `ui` → `service` → `domain`. O `domain` não conhece ninguém.

## Como rodar

```bash
javac -d out $(find src -name "*.java") && java -cp out Main
```

## Regras deste projeto

1. **Todo código aqui é escrito por mim.** É o projeto de aprendizado — IA em modo instrutor e revisor, nunca gerando o código (ver [`METODO.md`](../../docs/METODO.md)).
2. **Cada funcionalidade entra com o conceito que a motivou.** Nada de usar `Stream` na aula P2 só porque é mais bonito: o recurso entra quando a aula dele chega.
3. **Nada é reescrito do zero.** A cada aula, o código anterior é refatorado — e é justamente ver o sistema melhorar que mostra a evolução.
4. **Toda decisão relevante vira ADR** em [`docs/adr/`](../../docs/adr/).

## Diário de evolução

| Data | Aula | O que entrou |
|---|---|---|
| — | R5 | _(a preencher quando o sistema nascer)_ |
