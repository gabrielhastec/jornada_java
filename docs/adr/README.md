# ADR — Architecture Decision Records

Um ADR é um documento curto (1 página) que registra **uma decisão técnica**, as alternativas que foram descartadas e as consequências que a decisão traz.

## Por que isso existe aqui

Numa entrevista, ninguém pergunta "você sabe Spring?". Perguntam "**por que** você escolheu isso?". Quem só tem código não tem resposta; quem tem ADR responde em 30 segundos, com as alternativas na ponta da língua.

Além disso: daqui a seis meses eu não vou lembrar por que escolhi `BigDecimal` em vez de `double`, ou por que o multi-tenant é por coluna e não por schema. O ADR lembra por mim.

## Regras

- Um arquivo por decisão: `ADR-NNN-titulo-curto.md`
- ADR não se apaga nem se reescreve. Mudou de ideia? Escreve um novo ADR com status `Substitui o ADR-00X`.
- Só vale a pena para decisão que **fecha portas**: escolha de banco, de estratégia de autenticação, de forma de isolar tenant. Nomear variável não é ADR.

## Índice

| ADR | Decisão | Status |
|---|---|---|
| [ADR-001](ADR-001-reorganizacao-do-repositorio.md) | Reorganizar o repositório em 5 trilhas | Aceito |

Modelo em branco: [`ADR-000-template.md`](ADR-000-template.md)
