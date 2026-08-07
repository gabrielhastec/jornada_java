
# 💰 Exercício 04 – Sistema de Folha Salarial (POO + Polimorfismo + Interfaces)

## 📌 Objetivo

Desenvolver um sistema de folha salarial aplicando:

* Abstração
* Herança
* Polimorfismo
* Interfaces
* Composição
* Generics com múltiplos bounds (`<T extends Classe & Interface>`)

O sistema permite cadastrar funcionários **CLT** e **PJ**, calcular salário bruto, descontos, salário líquido, benefícios e gerar um **holerite formatado**.

---

## 🏗️ Arquitetura do Projeto

O projeto está organizado em pacotes com separação clara de responsabilidades:

```
src
 ├── application   → Classe Main (ponto de entrada)
 ├── entities      → Modelo de domínio
 ├── interfaces    → Contratos (regras tributárias)
 ├── service       → Regras de negócio
 └── utils         → Interação com usuário
```

---

## 🧠 Conceitos Aplicados

### 🔹 1. Abstração

A classe abstrata:

```java
Funcionario
```

Define atributos e comportamentos comuns:

* Nome
* Salário base
* Horas extras
* Benefícios
* Cálculo de salário bruto
* Regra de hora extra (50%)

E delega o cálculo do salário líquido às subclasses.

---

### 🔹 2. Herança + Polimorfismo

Classes concretas:

* `FuncionarioCLT`
* `FuncionarioPJ`

Cada uma implementa suas próprias regras tributárias.

---

### 🔹 3. Interface (Contrato Tributário)

```java
Tributavel
```

Define:

```java
double calcularDesconto();
double calcularSalarioLiquido();
String getTipoContrato();
```

Isso garante que qualquer tipo de funcionário saiba calcular seu próprio desconto.

---

### 🔹 4. Composição

A classe:

```java
Beneficios
```

É usada dentro de `Funcionario`:

```java
private Beneficios beneficios;
```

Benefícios disponíveis:

* Vale Alimentação (R$ 600,00)
* Plano de Saúde (R$ 300,00)

Cada benefício pode ser ativado ou desativado.

---

### 🔹 5. Generics com Múltiplos Bounds

No `FolhaService`:

```java
public <T extends Funcionario & Tributavel> void gerarHolerite(T funcionario)
```

Isso garante que o objeto:

* Seja um `Funcionario`
* E também implemente `Tributavel`

Demonstrando uso avançado de generics.

---

## 📊 Regras de Negócio

### CLT

* Desconto de INSS: **8%**
* Pode ter benefícios
* Salário líquido = bruto - desconto

### PJ

* Sem desconto na fonte
* Não possui benefícios via folha
* Recebe salário bruto integral

---

### Hora Extra

* Valor hora = salário base / 180
* Hora extra = 50% adicional

---

### Salário Mínimo

O sistema garante que o salário líquido nunca fique abaixo de:

```
R$ 1412,00
```

Se necessário, aplica ajuste automático.

---

## 🖥️ Execução

### 1️⃣ Compilar

Se estiver usando VS Code:

* Clique com botão direito em `Main.java`
* Execute `Run Java`

Ou via terminal:

```bash
javac application/Main.java
java application.Main
```

---

## 📌 Exemplo de Saída

```
╔══════════════════════════════════════╗
║           HOLERITE MENSAL            ║
╠══════════════════════════════════════╣
║  Funcionário : João                  ║
║  Contrato    : CLT                   ║
╠══════════════════════════════════════╣
║  Salário Base      : R$     3000.00  ║
║  Horas Extras (10h): R$      250.00  ║
║  Salário Bruto     : R$     3250.00  ║
╠══════════════════════════════════════╣
║  Desconto INSS(8%) : R$      260.00  ║
║  Salário Líquido   : R$     2990.00  ║
╠══════════════════════════════════════╣
║  REMUNERAÇÃO TOTAL : R$     3590.00  ║
╚══════════════════════════════════════╝
```

---

## 🎯 Objetivos Técnicos Alcançados

✔ Modelagem orientada a objetos
✔ Separação de responsabilidades
✔ Baixo acoplamento
✔ Uso correto de composição
✔ Aplicação de interface como contrato
✔ Uso avançado de generics
✔ Estrutura modular em pacotes

---

## 🚀 Possíveis Melhorias Futuras

* Persistência em banco de dados
* Exportação de holerite em PDF
* Interface gráfica (JavaFX ou Swing)
* Testes unitários (JUnit)
* Implementação de Strategy Pattern para regras tributárias
* Cálculo progressivo de INSS

---

Exercício acadêmico focado em prática de **Programação Orientada a Objetos em Java**.
