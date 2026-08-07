# Kata 02 — Salário por hora

**Enunciado:** ler o número do funcionário, as horas trabalhadas e o valor por hora; calcular e exibir o salário com duas casas decimais.

**Conceitos praticados:** `Scanner`, tipos numéricos, formatação de saída com duas casas decimais.

## Como rodar

```bash
javac -d out src/Salario.java && java -cp out Salario
```

## Dívida conhecida / próxima evolução

- [ ] `valor por hora` está declarado como `int` — impede salário-hora com centavos (ex.: R$ 18,50)
- [ ] Dinheiro em ponto flutuante: migrar para `BigDecimal` (Fase R, aula R3)
- [ ] Não há validação de horas negativas

## O que este kata me ensinou

- Formatar número para exibição (`%.2f`) é apresentação, não cálculo — as duas coisas não se misturam
