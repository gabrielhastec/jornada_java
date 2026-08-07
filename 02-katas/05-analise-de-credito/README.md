# Kata 05 — Análise de crédito

**Enunciado:** avaliar clientes por critérios (idade, ocupação, renda), somar pontuação, classificar risco e definir limite de crédito.

**Conceitos praticados:** interface como ponto de extensão (`Avaliavel`), padrão **Strategy**, enum (`NivelRisco`, `Ocupacao`), separação em camadas (`entities`, `service`, `interfaces`), constantes de regra de negócio.

## Como rodar

```bash
javac -d out $(find src -name "*.java") && java -cp out application.Main
```

## Decisões que tomei

| Decisão | Por quê |
|---|---|
| Cada critério é uma classe que implementa `Avaliavel` | Adicionar um critério novo não exige alterar o `AnalisadorCredito` |
| Limites e scores como `static final` no serviço | Regra de negócio explícita, não número mágico espalhado |

> Este é o kata mais bem estruturado do repositório — é a base da aula de **Strategy** (Fase POO, aula P4), onde o exercício será adicionar um critério novo (ex.: tempo de relacionamento) **sem tocar** no `AnalisadorCredito`.

## Dívida conhecida / próxima evolução

- [ ] A lista de critérios é montada dentro do próprio serviço — poderia ser recebida pelo construtor (injeção de dependência na mão, Fase POO, aula P4)
- [ ] Valores monetários em `double` (Fase R, aula R3)
- [ ] Sem testes: cada faixa de score merece um caso de teste (Fase POO, aula P10)

## O que este kata me ensinou

- Que interface serve para trocar comportamento sem alterar quem usa — e que isso é o mesmo mecanismo por trás de `PaymentGateway`, `NotificationSender` e afins em sistema real
