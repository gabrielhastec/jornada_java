# Kata 07 — Caixa eletrônico

**Enunciado:** dado um valor de saque, entregar a menor quantidade possível de notas, recusando valores impossíveis para as cédulas disponíveis.

**Conceitos praticados:** algoritmo guloso (maior nota primeiro), array, entidades (`Nota`, `Saque`), camada de serviço, exceção customizada (`SaqueInvalidoException`).

## Como rodar

```bash
javac -d out $(find src -name "*.java") && java -cp out application.Main
```

## As duas versões (por que existem)

| Pasta | O que é |
|---|---|
| [`versao-inicial/`](versao-inicial/) | Primeira solução: tudo dentro de um `main`, procedural |
| [`src/`](src/) | Refatoração com POO: entidades, serviço e exceção separados |

Manter as duas é proposital: a comparação entre elas **é** o portfólio. Mostra evolução, não só resultado.

## Dívida conhecida / próxima evolução

- [ ] A classe da versão inicial se chama `caixaEletronico` (minúscula) — fora da convenção Java, que pede `PascalCase` para classes. Correção pendente como exercício
- [ ] As cédulas disponíveis estão fixas no código — poderiam ser configuráveis (o caixa real tem estoque de notas por denominação)
- [ ] Sem testes: valor não múltiplo da menor nota, valor zero e valor maior que o estoque são os casos óbvios (Fase POO, aula P10)

## O que este kata me ensinou

- Que o mesmo problema resolvido de duas formas mostra o que a POO agrega — e quando ela ainda não se paga
- Que o algoritmo guloso funciona para o sistema de cédulas brasileiro, mas **não** para qualquer conjunto de valores (pergunta para investigar: por quê?)
