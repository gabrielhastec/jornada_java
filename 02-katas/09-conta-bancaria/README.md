# Kata 09 — Conta bancária

**Enunciado:** cadastrar clientes, calcular limite de crédito a partir de perfil (idade, ocupação, salário) e executar operações de conta: depósito, saque, transferência e extrato.

**Conceitos praticados:** classes e objetos, enum (`Ocupacao`), camada de serviço, exceções customizadas, `Stream` + `Optional` para busca, menu de console.

## Como rodar

```bash
javac -d out $(find src -name "*.java") && java -cp out application.App
```

## Estrutura

```
src/
├── application/App.java        entrada da aplicação
├── entities/Cliente.java       dados do cliente e saldo
├── entities/Ocupacao.java      enum de ocupações
├── service/BancoService.java   operações de conta
├── service/CadastroService.java
├── service/ValidadorCredito.java
├── utils/Exceptions.java       exceções (a reorganizar)
└── utils/Menu.java             interface de console
```

## Dívida conhecida / próxima evolução

Este kata é o código-alvo da **[Aula 01 — Caça ao bug](../../docs/trilha/fase-0/aula-01-caca-ao-bug.md)**. Três problemas identificados e ainda **não corrigidos** (de propósito — são o exercício):

- [ ] `BancoService.buscarCliente` compara `String` com `==` em vez de `.equals()` → a busca falha quando o id vem do `Scanner` (Fase R, aula de caça ao bug)
- [ ] Exceções aninhadas dentro da classe `utils.Exceptions` → devem virar um pacote `exceptions`, uma classe por arquivo, com decisão explícita entre checked e unchecked (Fase R, aula de caça ao bug)
- [ ] `Cliente.setSaldo` público e regra de saldo morando no serviço → a invariante "saldo não fica negativo" precisa morar dentro da entidade (Fase R, caça ao bug / Fase POO, aula P2)
- [ ] `double` para representar dinheiro → migrar para `BigDecimal` (Fase R, aula R3)
- [ ] Sem testes: as regras de saque e transferência não têm prova automatizada (Fase POO, aula P10)

## O que este kata me ensinou

- Buscar em coleção com `Stream` + `orElseThrow` em vez de laço com flag
- Separar cadastro (`CadastroService`) de operação (`BancoService`)
- _(preencher depois da Aula 01: o que descobri sobre `==` vs `equals`)_
