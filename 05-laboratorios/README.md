# 05 — Laboratórios

Experimentos curtos (1 a 2 horas), **uma peça de infraestrutura por vez**, isolada de qualquer projeto.

## Por que esta pasta existe

Descobri nginx, RBAC, multi-tenant, ORM e protocolos de borda construindo sistema, não estudando — porque curso e faculdade não chegam nesse nível. O problema de aprender esses assuntos direto dentro de um projeto é que, quando algo quebra, você não sabe se foi a peça nova ou o resto do sistema.

Aqui cada peça é montada sozinha, no menor cenário possível, até eu entender **o que ela faz e o que acontece quando ela falha**. Só depois ela entra num projeto de [`03-projetos/`](../03-projetos/).

## Regra de um laboratório

1. **Uma pergunta só.** "O que o nginx faz quando uma das duas instâncias cai?" — não "aprender nginx".
2. **Menor cenário que responde a pergunta.** Um `docker-compose.yml`, duas instâncias, um `curl`.
3. **Quebrar de propósito.** Derrubar o container, estourar o limite, mandar entrada inválida. Só se entende uma peça vendo-a falhar.
4. **README com o resultado medido**, não com a teoria copiada: o que eu esperava, o que aconteceu, o número que apareceu.
5. Se o laboratório rendeu, ele vira ficha em [`docs/conceitos/`](../docs/conceitos/).

## Fila de laboratórios

| Lab | Pergunta que responde | Quando (trilha) |
|---|---|---|
| `docker-postgres` | Como subir um banco descartável e conectar nele? | Fase WEB, aula W4 |
| `orm-e-n-mais-1` | Quantas queries o JPA dispara de verdade? Como provocar e matar o N+1? | Fase WEB, aula W4 |
| `flyway-migrations` | O que acontece se dois devs criarem a migration `V2` ao mesmo tempo? | Fase WEB, aula W5 |
| `jwt-na-mao` | O que tem dentro de um JWT? Dá para ler sem a chave? (sim) | Fase PRO, aula X1 |
| `rbac-basico` | Papel × permissão: onde a checagem tem que estar para não ser burlável? | Fase PRO, aula X2 |
| `multi-tenant` | Esquecer o filtro de `tenant_id` em uma consulta vaza dado de quem? | Fase PRO, aula X3 |
| `retry-e-circuit-breaker` | O que acontece com minha API quando a API do parceiro fica lenta? | Fase PRO, aula X4 |
| `redis-cache` | Qual o ganho medido, e como o cache serve dado velho? | Fase PRO, aula X5 |
| `nginx-load-balancer` | Como o tráfego se distribui entre 2 instâncias? E se uma cair? | Fase ARQ, aula A1 |

## Estrutura de cada laboratório

```
NN-nome/
├── README.md          pergunta, hipótese, o que aconteceu, número medido
├── docker-compose.yml quando aplicável
└── (código mínimo)
```
