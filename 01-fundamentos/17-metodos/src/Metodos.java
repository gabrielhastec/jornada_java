
public class Metodos {

    // ================================================================
    // O main também é um método. A diferença é que a JVM chama ele
    // sozinha quando o programa começa. Todos os outros, quem chama
    // é você.
    // ================================================================
    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. CHAMANDO UM MÉTODO SEM RETORNO (void)
        // ------------------------------------------------------------
        exibirCabecalho("BOLETIM");

        // ------------------------------------------------------------
        // 2. MÉTODO QUE DEVOLVE UM VALOR
        //    O valor devolvido precisa ser guardado ou usado.
        // ------------------------------------------------------------
        double media = calcularMedia(7.5, 9.0);
        System.out.println("Média de 2 notas: " + media);

        // ------------------------------------------------------------
        // 3. SOBRECARGA: mesmo nome, lista de parâmetros diferente.
        //    O compilador escolhe pela quantidade/tipo dos argumentos.
        // ------------------------------------------------------------
        double mediaTrimestral = calcularMedia(7.5, 9.0, 6.0);
        System.out.println("Média de 3 notas: " + mediaTrimestral);

        // ------------------------------------------------------------
        // 4. O RETORNO DE UM MÉTODO PODE ALIMENTAR OUTRO
        // ------------------------------------------------------------
        System.out.println("Situação: " + situacao(calcularMedia(8.0, 9.0)));
        System.out.println("Situação: " + situacao(calcularMedia(5.0, 6.0)));
        System.out.println("Situação: " + situacao(calcularMedia(4.0, 3.0)));

        // ------------------------------------------------------------
        // 5. PARÂMETRO É CÓPIA: o método recebe o valor, não a variável
        // ------------------------------------------------------------
        int idade = 20;
        int idadeDobrada = dobrar(idade);
        System.out.println("original = " + idade + " | devolvido = " + idadeDobrada);

        exibirCabecalho("FIM");
    }

    // ================================================================
    // ANATOMIA DE UM MÉTODO
    //
    //   static   void   exibirCabecalho ( String titulo )
    //     │        │           │                │
    //     │        │           │                └── parâmetro
    //     │        │           └── nome (verbo, camelCase)
    //     │        └── tipo de retorno (void = não devolve nada)
    //     └── pertence à classe, não a um objeto
    // ================================================================
    static void exibirCabecalho(String titulo) {
        System.out.println();
        System.out.println("===== " + titulo + " =====");
    }

    // Devolve um double: TODO caminho do método precisa ter um return.
    static double calcularMedia(double n1, double n2) {
        return (n1 + n2) / 2;
    }

    // SOBRECARGA: mesmo nome, três parâmetros em vez de dois.
    static double calcularMedia(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }

    // O return encerra o método na hora — o que vem depois não executa.
    static String situacao(double media) {
        if (media >= 7.0) {
            return "Aprovado";
        }
        if (media >= 5.0) {
            return "Recuperação";
        }
        return "Reprovado";
    }

    // 'valor' é uma CÓPIA do argumento. Alterar aqui dentro não
    // altera a variável de quem chamou.
    static int dobrar(int valor) {
        valor = valor * 2;
        return valor;
    }
}
