
# 📘 Aula 15 – Operadores Bitwise

## 🎯 Objetivos

Nesta aula você aprenderá a:

* ✅ Manipular bits diretamente
* ✅ Utilizar `&`, `|`, `^`, `~`
* ✅ Aplicar máscaras de bits
* ✅ Verificar paridade usando operação binária
* ✅ Entender representação em complemento de dois

---

# 🧠 Conceito Fundamental

Todo número inteiro é armazenado em binário.

Exemplo:

```
5  = 00000101
3  = 00000011
```

Operadores bitwise comparam **bit a bit**.

---

# 🔹 1. AND Bit a Bit (`&`)

Retorna `1` apenas se ambos os bits forem `1`.

```
   0101  (5)
&  0011  (3)
--------
   0001  (1)
```

Código:

```java
System.out.println("a & b = " + (a & b)); // 1
```

---

# 🔹 2. OR Bit a Bit (`|`)

Retorna `1` se pelo menos um dos bits for `1`.

```
   0101
|  0011
--------
   0111  (7)
```

```java
System.out.println("a | b = " + (a | b)); // 7
```

---

# 🔹 3. XOR Bit a Bit (`^`)

Retorna `1` se os bits forem diferentes.

```
   0101
^  0011
--------
   0110  (6)
```

```java
System.out.println("a ^ b = " + (a ^ b)); // 6
```

---

# 🔹 4. NOT Bit a Bit (`~`)

Inverte todos os bits.

```
a = 00000101 (5)
~a = 11111010 (-6)
```

⚠ Java usa **complemento de dois** para números negativos.

```java
System.out.println("~a = " + (~a)); // -6
```

---

# 💻 Código da Aula

```java
import java.util.Scanner;

public class bitwise {

    public static void main(String[] args) {

        int a = 5, b = 3;

        System.out.println("a & b = " + (a & b)); // 1
        System.out.println("a | b = " + (a | b)); // 7
        System.out.println("a ^ b = " + (a ^ b)); // 6
        System.out.println("~a = " + (~a));       // -6

        int numero = 10;
        System.out.println(numero + " é par? " + ((numero & 1) == 0));

        Scanner sc = new Scanner(System.in);

        int mask = 0b00001111;
        int n = sc.nextInt();

        if ((n & mask) != 0)
            System.out.println("6th bit is true!");

        sc.close();
    }
}
```

---

# 🔍 Verificar se Número é Par

```java
(numero & 1) == 0
```

### Por quê funciona?

Números pares terminam com bit `0`.

Exemplo:

```
10 = 1010
& 1 = 0001
-----------
      0000
```

Resultado `0` → número par.

Mais eficiente que `% 2`.

---

# 🔹 Máscaras de Bits

Uma máscara é usada para verificar ou manipular bits específicos.

Exemplo:

```java
int mask = 0b00001111;
```

Isso seleciona apenas os 4 bits menos significativos.

```java
if ((n & mask) != 0)
```

Significa:

> Se algum dos 4 bits finais estiver ativado.

---

# ⚠️ Observação Técnica Importante

No seu código:

```java
System.out.println("6th bit is true!");
```

Mas a máscara `0b00001111` verifica os **4 primeiros bits**, não o sexto.

Se quiser verificar o sexto bit corretamente:

```java
int mask = 1 << 5; // desloca 1 cinco posições (começa do 0)
```

---

# 🧩 Aplicações Reais

* Sistemas embarcados
* Permissões (flags)
* Controle de hardware
* Compactação de dados
* Criptografia básica
* Otimizações de performance

---

# 🔬 Diferença Importante

Não confundir:

| Operador | Tipo    |         |        |
| -------- | ------- | ------- | ------ |
| `&&`     | Lógico  |         |        |
| `&`      | Bitwise |         |        |
| `        |         | `       | Lógico |
| `        | `       | Bitwise |        |

---

# 🧠 Nível Avançado (Extra)

Operadores de deslocamento:

* `<<` desloca bits à esquerda
* `>>` desloca à direita
* `>>>` deslocamento lógico à direita

Exemplo:

```java
1 << 3  // 8
```

---

# ⚙️ Compilação

```bash
javac bitwise.java
java bitwise
```

---

# 🚀 Panorama Atual

Você agora domina:

* Operadores aritméticos
* Operadores lógicos
* Controle de fluxo
* Laços
* Operações de baixo nível

Isso já cobre **a base estrutural da linguagem Java procedural**.
