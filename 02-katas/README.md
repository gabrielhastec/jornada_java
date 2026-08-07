# 02 — Katas

Exercícios com domínio de negócio. É aqui que os conceitos de [`01-fundamentos/`](../01-fundamentos/) deixam de ser sintaxe e viram **regra**: folha de pagamento, análise de crédito, caixa eletrônico, conta bancária.

Cada kata tem README com o enunciado, as decisões tomadas, o que ensinou e a **dívida conhecida** — o que está errado ou incompleto e em qual semana da [trilha](../docs/TRILHA.md) será resolvido. Dívida assumida por escrito é o que separa portfólio de bagunça.

| # | Kata | Conceitos centrais | Dívida aberta |
|---|---|---|---|
| 01 | [Operações básicas](01-operacoes-basicas/) | `Scanner`, variáveis, aritmética | validação de entrada |
| 02 | [Salário por hora](02-salario/) | tipos numéricos, formatação | dinheiro em `double` |
| 03 | [Registro de venda](03-venda/) | múltiplas entradas, cálculo | pede array + classe `ItemVenda` |
| 04 | [Folha de pagamento](04-folha-de-pagamento/) | herança, polimorfismo, interface `Tributavel` | rever herança × composição |
| 05 | [Análise de crédito](05-analise-de-credito/) | **Strategy**, interface, enum, camadas | injeção de dependência pelo construtor |
| 06 | [Calculadora](06-calculadora/) | exceção customizada, `switch` | herança errada: `Calculadora extends DivisaoPorZeroException` |
| 07 | [Caixa eletrônico](07-caixa-eletronico/) | algoritmo guloso, entidades, exceção | duas versões (procedural × POO) preservadas |
| 08 | [Registro escolar](08-registro-escolar/) | herança, exceções em pacote próprio, `Stream` | coleção com significado no lugar de `double[]` |
| 09 | [Conta bancária](09-conta-bancaria/) | serviços, exceções, `Optional` | **3 bugs abertos** — alvo da [Aula 01](../docs/trilha/fase-0/aula-01-caca-ao-bug.md) |

## Como rodar qualquer kata

```bash
cd 09-conta-bancaria && javac -d out $(find src -name "*.java") && java -cp out application.App
```

A classe de entrada varia (`application.App` ou `application.Main`) — está indicada no README de cada kata. `out/` é ignorado pelo Git.

## Template

Kata novo começa copiando [`docs/templates/README-kata.md`](../docs/templates/README-kata.md).
