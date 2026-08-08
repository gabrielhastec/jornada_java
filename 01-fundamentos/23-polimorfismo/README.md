
# 📘 Aula 23 – Polimorfismo e Classes Abstratas

## 🎯 Objetivos

* Entender **polimorfismo por substituição**
* Compreender **ligação dinâmica (dynamic dispatch)**
* Modelar conceitos genéricos com `abstract`
* Forçar implementação obrigatória em subclasses

---

# 1️⃣ Polimorfismo

## 📌 Definição Técnica

Polimorfismo é a capacidade de:

> Uma referência de superclasse apontar para um objeto de subclasse.

Exemplo do seu código:

```java
Forma f1 = new Circulo("Vermelho", 3.0);
Forma f2 = new Retangulo("Azul", 4.0, 5.0);
```

Aqui:

* Tipo da variável → `Forma`
* Tipo real do objeto → `Circulo` / `Retangulo`

Isso é **upcasting implícito**.

---

# 2️⃣ Ligação Dinâmica (Dynamic Dispatch)

Quando você executa:

```java
f1.area();
```

O Java decide **em tempo de execução** qual método chamar.

Mesmo que a variável seja `Forma`, o método executado será:

* `Circulo.area()` se o objeto for `Circulo`
* `Retangulo.area()` se o objeto for `Retangulo`

Isso acontece porque métodos sobrescritos usam **ligação dinâmica**.

Importante:

* A decisão NÃO é feita em tempo de compilação
* É feita em tempo de execução

---

# 3️⃣ Classe Abstrata

```java
public abstract class Forma
```

Significa:

* Não pode ser instanciada
* Pode conter métodos concretos
* Pode conter métodos abstratos
* Pode possuir estado (atributos)

---

## 📌 Método Abstrato

```java
public abstract double area();
```

Características:

* Não possui implementação
* Obriga subclasses a implementarem
* Define um contrato mínimo

Se uma subclasse não implementar `area()`, ela também deverá ser abstrata.

---

# 4️⃣ Implementações Concretas

## 🔹 `Circulo`

```java
@Override
public double area() {
    return Math.PI * raio * raio;
}
```

Implementa a regra específica do domínio matemático.

---

## 🔹 `Retangulo`

```java
@Override
public double area() {
    return largura * altura;
}
```

Mesma assinatura, implementação diferente.

Isso é polimorfismo na prática.

---

# 5️⃣ Fluxo de Execução Interno

Quando o método é chamado:

```java
f1.area();
```

O runtime faz:

1. Verifica o tipo real do objeto
2. Procura a implementação mais específica na hierarquia
3. Executa essa versão

Hierarquia:

```
Object
   ↓
Forma (abstract)
   ↓
Circulo
Retangulo
```

---

# 6️⃣ Por Que Não Posso Instanciar Forma?

```java
Forma f = new Forma("Verde"); // erro
```

Porque:

* `Forma` é incompleta
* Possui método abstrato
* Não define comportamento total

Ela representa um conceito genérico, não um objeto concreto.

---

# 7️⃣ Benefício Arquitetural

Você pode escrever código genérico:

```java
public static void imprimirArea(Forma forma) {
    System.out.println("Área: " + forma.area());
}
```

Esse método funciona para:

* Circulo
* Retangulo
* Qualquer nova subclasse futura

Sem modificar o código.

Isso reduz:

* Condicionais
* Acoplamento
* Complexidade

---

# 8️⃣ Classe Abstrata vs Interface (Antecipação)

| Classe Abstrata            | Interface                |
| -------------------------- | ------------------------ |
| Pode ter atributos         | Não possui estado        |
| Pode ter métodos concretos | Define contrato          |
| Herança única              | Múltiplas implementações |

---

# 9️⃣ Conceito Avançado Importante

Isso está diretamente ligado ao:

### Princípio da Substituição de Liskov (LSP)

Se `Circulo` é uma `Forma`, então:

> Deve poder substituir `Forma` sem quebrar comportamento esperado.

Seu exemplo respeita isso.

---

# 📌 Conclusão

Você agora domina:

* Encapsulamento
* Composição
* Herança
* Override
* Polimorfismo
* Classes abstratas

Isso já é base sólida para:

* Interfaces
* SOLID
* Padrões de Projeto
* Arquitetura limpa
