import java.util.Scanner;

public class calculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        System.out.println("======== CALCULADORA ========");
        int opcao1, opcao2, saida, dgVerificador;
        double resultado;

        System.out.println("--- Dígitos das operações: ---");
        System.out.println(" 1 - Adição ");
        System.out.println(" 2 - Subtração ");
        System.out.println(" 3 - Multiplicação ");
        System.out.println(" 4 - Divisão ");

        do {
            System.out.println("---------------------------");
            System.out.println("Digite o primeiro digito: ");
            opcao1 = sc.nextInt();
            System.out.println("Digite o segundo digito: ");
            opcao2 = sc.nextInt();

            System.out.println("Digite a operação: ");
            dgVerificador = sc.nextInt();

            switch (dgVerificador) {
                case 1:
                    resultado = opcao1 + opcao2;
                    System.out.println("O resultado é: " + resultado);
                    System.out.println("---------------------------");
                    break;
                case 2:
                    resultado = opcao1 - opcao2;
                    System.out.println("O resultado é: " + resultado);
                    System.out.println("---------------------------");
                    break;
                case 3:
                    resultado = opcao1 * opcao2;
                    System.out.println("O resultado é: " + resultado);
                    System.out.println("---------------------------");
                    break;
                case 4:
                    resultado = opcao1 / opcao2;
                    System.out.println("O resultado é: " + resultado);
                    System.out.println("---------------------------");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    System.out.println("---------------------------");
                    break;
            }

            System.out.println("Deseja fazer outra operação? ");
            System.out.println(" 1 - Sim ");
            System.out.println(" 2 - Não ");
            saida = sc.nextInt();

        } while (saida == 1);

        System.out.println("======= ENCERRANDO... =======");

        sc.close();
        
    }
    
}
