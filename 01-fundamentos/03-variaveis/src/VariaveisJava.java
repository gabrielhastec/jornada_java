
public class VariaveisJava {

    public static void main(String[] args) {

        // ============================================================
        // 1. DECLARAR, INICIALIZAR E REATRIBUIR
        // ============================================================
        // Forma geral:  tipo nomeDaVariavel = valor;

        int idade = 20;
        System.out.println("Idade: " + idade);

        // Reatribuir muda o VALOR. O TIPO nunca muda.
        idade = 21;
        System.out.println("Nova idade: " + idade);

        // final = constante. Depois de receber valor, não aceita reatribuição.
        final int ANO_ATUAL = 2026;
        System.out.println("Ano atual: " + ANO_ATUAL);

        // ============================================================
        // 2. OS 8 TIPOS PRIMITIVOS
        // ============================================================

        // --- Números inteiros (sem casa decimal) ---
        byte  itensNaCaixa   = 100;              //  8 bits  · -128 a 127
        short alunosNaEscola = 30_000;           // 16 bits  · -32.768 a 32.767
        int   habitantesDaCidade = 1_000_000;    // 32 bits  · ±2,1 bilhões
        long  habitantesDoPlaneta = 8_000_000_000L; // 64 bits · o L é obrigatório

        System.out.println();
        System.out.println("byte  -> " + itensNaCaixa);
        System.out.println("short -> " + alunosNaEscola);
        System.out.println("int   -> " + habitantesDaCidade);
        System.out.println("long  -> " + habitantesDoPlaneta);

        // --- Números com casa decimal (ponto flutuante) ---
        float  temperatura = 36.6f;              // 32 bits · o f é obrigatório · ~7 dígitos
        double distanciaEmKm = 384_400.5;        // 64 bits · ~15 dígitos

        System.out.println("float  -> " + temperatura);
        System.out.println("double -> " + distanciaEmKm);

        // --- Um caractere e valor lógico ---
        char inicialDoNome = 'J';                // 16 bits · UM caractere · aspas SIMPLES
        boolean maiorDeIdade = true;             // apenas true ou false

        System.out.println("char    -> " + inicialDoNome);
        System.out.println("boolean -> " + maiorDeIdade);

        // ============================================================
        // 3. ESCOLHER O TIPO ERRADO CUSTA CARO: OVERFLOW
        // ============================================================
        // O int vai até 2.147.483.647. Somar 1 não dá erro:
        // o valor "dá a volta" e vira o menor número possível.

        int limiteDoInt = 2147483647;

        System.out.println();
        System.out.println("limite do int     -> " + limiteDoInt);
        System.out.println("limite do int + 1 -> " + (limiteDoInt + 1));

        // ============================================================
        // 4. double É APROXIMADO — NÃO SERVE PARA DINHEIRO
        // ============================================================

        System.out.println();
        System.out.println("0.1 + 0.2   -> " + (0.1 + 0.2));
        System.out.println("1.03 - 0.42 -> " + (1.03 - 0.42));

        // ============================================================
        // 5. String: O TIPO PARA TEXTO
        // ============================================================
        // String NÃO é primitivo. Guarda uma sequência de caracteres
        // e usa aspas DUPLAS. O + junta (concatena) textos e valores.

        String nome = "João Silva";

        System.out.println();
        System.out.println("Nome: " + nome);
        System.out.println(nome + " tem " + idade + " anos.");
    }
}
