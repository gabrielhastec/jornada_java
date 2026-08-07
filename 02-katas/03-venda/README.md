# Kata 03 — Registro de venda

**Enunciado:** ler código, quantidade e valor unitário de duas peças; calcular e mostrar o valor total a pagar.

**Conceitos praticados:** múltiplas entradas, cálculo com variáveis intermediárias, saída formatada.

## Como rodar

```bash
javac -d out src/Venda.java && java -cp out Venda
```

## Dívida conhecida / próxima evolução

- [ ] Duas peças estão declaradas em variáveis separadas (`idProduto1`, `idProduto2`...) — com três peças o código dobra. É o caso clássico que pede **array/coleção + classe `ItemVenda`** (Fase POO, aula P1: quando criar classe)
- [ ] Valor unitário como `int` não aceita centavos

## O que este kata me ensinou

- Quando as variáveis começam a ganhar sufixo numérico (`1`, `2`, `3`), o código está pedindo uma estrutura de dados
