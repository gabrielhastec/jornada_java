# Kata 06 — Calculadora

**Enunciado:** calculadora de console com as quatro operações, tratando divisão por zero.

**Conceitos praticados:** classe de modelo, `switch`, exceção customizada (`DivisaoPorZeroException`), menu de console.

## Como rodar

```bash
javac -d out $(find src -name "*.java") && java -cp out application.Main
```

## Dívida conhecida / próxima evolução

- [ ] **Erro de modelagem para investigar:** `public class Calculadora extends DivisaoPorZeroException`. Uma calculadora **não é** uma exceção — herança usada como atalho para "ter acesso" ao tipo. Serve de exemplo perfeito para a aula de **herança × composição** (Fase POO, aula P3): pergunta-guia — *a frase "Calculadora é uma DivisaoPorZeroException" faz sentido em português?*
- [ ] A operação é escolhida por um `int dgVerificador` — um `enum Operacao` deixaria o código autoexplicativo (Fase POO, aula P5: enum com comportamento)
- [ ] `DivisaoPorZeroException` está no pacote `utils` (Fase POO, aula P7: exceção não mora em `utils`)
- [ ] Sem testes: divisão por zero é o caso de teste mais óbvio que existe (Fase POO, aula P10)

## O que este kata me ensinou

- Que exceção customizada comunica a regra melhor do que retornar `-1` ou imprimir mensagem no meio do cálculo
