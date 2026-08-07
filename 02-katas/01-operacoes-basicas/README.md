# Kata 01 — Operações básicas

**Enunciado:** ler dois valores inteiros e mostrar a soma com mensagem explicativa.

**Conceitos praticados:** entrada de dados com `Scanner`, variáveis, operador aritmético, saída formatada.

## Como rodar

```bash
javac -d out src/OperBasica.java && java -cp out OperBasica
```

## Dívida conhecida / próxima evolução

- [ ] O programa não avisa o que deve ser digitado antes de ler — falta prompt
- [ ] Entrada não numérica derruba a aplicação com `InputMismatchException` (Fase POO, aula P7: exceções e validação)

## O que este kata me ensinou

- Que `Scanner` precisa ser fechado, e por que ler `int` e depois `String` exige cuidado com o `\n` pendente
