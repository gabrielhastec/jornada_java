# 04 — Desafios técnicos

Desafios de mercado resolvidos **cronometrados e sem IA**. Esta pasta é o simulado de prova técnica.

## Por que assim

Numa vaga de desenvolvedor Java júnior, o código em si é o menos avaliado. O que se mede é: você entende o requisito? consegue decidir com informação incompleta? acha o bug? explica a escolha? Isso não se treina assistindo aula — se treina sob relógio, sozinho.

## As regras

1. **Timebox declarado antes de começar** (normalmente 2 a 3 horas). Acabou o tempo, entrega como está.
2. **Sem IA gerando código.** Documentação oficial, Stack Overflow e minhas próprias anotações são permitidos — é o que teria numa prova real.
3. **Anotar as dúvidas em vez de travar.** Requisito ambíguo? Escolho uma interpretação, registro a suposição no README e sigo. Isso é exatamente o que se espera de um profissional.
4. **Revisão depois**, com IA em modo revisor: o que quebraria em produção, o que eu não considerei.
5. **README obrigatório** com: interpretação do requisito, suposições assumidas, decisões, o que ficou de fora e por quê.

## Fontes

| Fonte | O que é | Uso |
|---|---|---|
| [backend-br/desafios](https://github.com/backend-br/desafios) | Coleção brasileira de desafios de backend (encurtador de URL, senha segura, criptografia, pontos por GPS, empréstimos) | **Simulado principal**, a cada 4 semanas |
| [roadmap.sh/backend/project-ideas](https://roadmap.sh/backend/project-ideas) | 20 ideias de projeto, do simples ao avançado | Escolha dos projetos guiados |
| [Rinha de Backend](https://github.com/zanfranceschi/rinha-de-backend-2026) | Competição de backend sob restrição de CPU e memória, com nginx e réplicas | Capstone da Fase 4 |
| [CodeCrafters](https://codecrafters.io/) | Reconstruir Redis, Git, SQLite e servidor HTTP do zero (trilha Java) | Aprofundamento contínuo |
| [Exercism — Java](https://exercism.org/tracks/java) | Katas com mentoria humana | Rotina semanal |

## Formato de cada desafio

```
NN-nome-do-desafio/
├── README.md    enunciado (link), timebox, suposições, decisões, o que faltou
└── solucao/     o código como foi entregue no tempo, sem polimento posterior
```

Se o desafio veio de um repositório público, o fluxo é: **fork → branch → resolver → PR no meu próprio fork**, e aqui fica o link. Repositório de terceiro não se comita dentro do meu.

## Histórico

| Data | Desafio | Timebox | Resultado | Revisão |
|---|---|---|---|---|
| — | primeiro simulado previsto para a Semana 4 da [trilha](../docs/TRILHA.md) | — | — | — |
