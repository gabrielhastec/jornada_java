# Método de estudo

Este arquivo existe por causa de um diagnóstico honesto: eu sabia a sintaxe (`ArrayList`, `try/catch`, `interface`) mas não sabia **quando** usar nem **onde** aquilo aparece num sistema real. Isso não é falta de capacidade — é consequência de estudar organizado por recurso da linguagem em vez de por problema.

A partir daqui, toda aula segue a mesma estrutura.

---

## Duas garantias que toda aula dá

**1. Nada é exigido antes de ser ensinado.** Toda aula abre com um bloco de **pré-requisitos** listando o que você já viu e vai usar. Se um recurso novo precisar aparecer no meio do caminho (`BigDecimal`, `Optional`, `record`), ele é explicado ali mesmo, do zero, com exemplo — nunca usado como se você já soubesse. Se em algum momento uma aula quebrar essa regra, me avise: é falha da aula, não sua.

**2. Todo conceito responde "onde eu uso isso".** Cada aula tem um bloco fixo mostrando onde aquilo aparece num sistema real (qual camada, qual arquivo, qual anotação), o que muda no seu dia a dia como desenvolvedor, e como o assunto cai em prova técnica e code review.

## O sistema que cresce a cada aula

Da Fase R em diante, **cada aula acrescenta uma funcionalidade ao mesmo sistema**: o [Sistema de Gestão da Loja](../03-projetos/00-loja-console/). O conceito da aula não é praticado num exercício descartável — ele entra como feature de um sistema que continua existindo.

É o modelo que já funcionou para mim na trilha de JavaScript: ao final, o resultado não é uma pasta com 30 exercícios soltos, e sim **um sistema completo para o portfólio**, que continua evoluindo com features novas depois que a trilha acaba.

Ordem das coisas dentro de uma aula: primeiro aparece a **necessidade do sistema** ("o carrinho precisa achar o produto pelo código sem varrer a lista inteira"), depois entra o **recurso da linguagem** que resolve (`Map`). Nunca o contrário.

---

## Os 7 blocos de uma aula

### 1. O problema
Um cenário concreto de empresa, com gente e consequência. Não "vamos aprender exceções", e sim:

> São 3h da manhã. Um cliente tentou pagar e viu "erro inesperado". O suporte abre o log e encontra `NullPointerException` na linha 214. Ninguém sabe qual cliente era, qual valor, nem se o dinheiro saiu da conta.

O recurso da linguagem entra como **resposta a essa dor**, nunca antes dela.

### 2. O conceito
O que é, e principalmente: **o que se fazia antes de existir**. Sem o "antes", todo recurso parece regra arbitrária. Códigos de retorno antes de exceções. Arrays de tamanho fixo antes de coleções. `Object` e cast antes de generics. SQL na mão antes de ORM.

### 3. Onde isso aparece no sistema real
Em que camada mora, e qual framework já usa isso por baixo do capô:

- exceção de negócio → capturada no `@RestControllerAdvice` → vira HTTP 409 para o cliente da API
- `Optional` → é o retorno de `findById` do Spring Data
- `enum` → status de pedido persistido no banco e validado na borda
- interface → ponto onde você troca implementação sem tocar no serviço (Strategy, Repository)

### 4. Implementação guiada
O instrutor explica, mostra exemplo **em outro domínio** e revisa. **Eu digito o código.** Se eu não digitei, eu não aprendi.

### 5. A prova
Um teste automatizado ou um roteiro manual que prova que a regra funciona — inclusive nos casos ruins (valor negativo, id inexistente, saldo insuficiente). Teste aqui não é burocracia: é a forma de provar que a regra existe.

### 6. Caça ao bug / refatoração
Recebo código quebrado — frequentemente **o meu próprio código antigo** — e conserto explicando a causa raiz. É literalmente a habilidade que a prova técnica mede: ler código alheio, formar hipótese, confirmar, corrigir sem quebrar o resto.

### 7. Registro
5 linhas em [`PROGRESSO.md`](PROGRESSO.md): o que aprendi, onde travei, o que decidi. Se houve decisão de arquitetura, vira um [ADR](adr/). Explicar por escrito é o que separa "consegui fazer" de "sei o que fiz".

---

## Regras de uso de IA no estudo

Já entreguei projetos de ponta a ponta com IA e não senti que aprendi. O problema não é a ferramenta, é o modo de uso. Então:

| Modo | Quando | O que a IA faz |
|---|---|---|
| **Instrutor** | Fases 0 a 2 | Explica o conceito, mostra exemplo em outro domínio, tira dúvida. **Não escreve o código do exercício.** |
| **Revisor** | Sempre, depois que eu escrevi | Aponta o que quebraria em produção e por quê. Eu corrijo. |
| **Copiloto** | Fase 3 em diante, nunca em conceito novo | Gera infraestrutura repetitiva: docker-compose, configs, boilerplate. |

**Regra do "explique de volta":** um tópico só é concluído quando eu explico a decisão em voz alta, sem olhar o código. Se eu não consigo explicar, eu não terminei — copiei.

**Regra do timebox:** travei 30 minutos num problema? Registro a hipótese que tenho, aí peço ajuda. Antes disso, não. O músculo de destravar sozinho é o que a prova técnica mede.

---

## Ritmo semanal (10h)

| Dia | Tempo | Atividade |
|---|---|---|
| Seg / Qua / Sex | 2h | Aula nova (blocos 1 a 5) |
| Ter / Qui | 1h30 | Projeto em andamento — código meu, IA em modo revisor |
| Ter / Qui | 30min | Resolução de problemas (Exercism → LeetCode) |
| Sáb | 1h | Caça ao bug + escrever no `PROGRESSO.md` |

**A cada 4 semanas:** simulado de prova técnica. Um desafio de [backend-br/desafios](https://github.com/backend-br/desafios), 2 a 3 horas cronometradas, **sem IA**, seguido de revisão. É o que transforma "sei a matéria" em "sei atuar sob pressão".
