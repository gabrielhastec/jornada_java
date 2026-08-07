# Kata 08 — Registro escolar

**Enunciado:** cadastrar alunos e professores, lançar notas por atividade, calcular média e situação do aluno.

**Conceitos praticados:** herança (`MembroEscolar` → `Aluno`/`Professor`), exceções customizadas em pacote próprio, camada de serviço, `Stream` + `Optional` para busca, array de notas.

## Como rodar

```bash
javac -d out $(find src -name "*.java") && java -cp out application.App
```

## Decisões que tomei

| Decisão | Por quê |
|---|---|
| `MembroEscolar` como superclasse | Aluno e professor compartilham nome e identificação |
| Exceções em pacote `exceptions`, uma por arquivo | Erro de negócio faz parte do contrato do domínio — este kata acertou o que o kata 09 errou |
| `IllegalArgumentException` para quantidade errada de notas | Erro de programação (contrato violado), não regra de negócio |

## Dívida conhecida / próxima evolução

- [ ] `double[] notas` de tamanho fixo 4 — uma coleção com significado (`Map<Atividade, Nota>`) seria mais expressiva (Fase POO, aula P6)
- [ ] A herança `MembroEscolar` é reuso ou contrato? Reavaliar na aula de **herança × composição** (Fase POO, aula P3)
- [ ] Sem testes: média com nota inválida e aluno inexistente são os casos óbvios (Fase POO, aula P10)

## O que este kata me ensinou

- Diferença prática entre erro de **negócio** (`AlunoNaoEncontradoException`) e erro de **programação** (`IllegalArgumentException`) — os dois existem no mesmo serviço, com propósitos diferentes
