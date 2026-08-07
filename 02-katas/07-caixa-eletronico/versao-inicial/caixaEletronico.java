import java.util.Scanner;

public class caixaEletronico {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        int valorSaque;

        System.out.println("------ INICIANDO SAQUE ------");
        System.out.println("Digite o valor do saque: ");
        valorSaque = sc.nextInt();

        if (valorSaque % 5 != 0) {
            System.out.println("Saque não é possível. O valor deve ser múltiplo de 5.");

        } else {

            int[] notas = {100, 50, 20, 10, 5};
            int[] quantidade = new int[notas.length];
            int i = 0;

            System.out.println("======== CARREGANDO ========");

            while (i < notas.length) {

                if (valorSaque >= notas[i]) {
                    valorSaque -= notas[i];
                    quantidade[i]++;
                } else {
                    i++; // passa para a próxima nota
                }
            }

            System.out.println("Notas entregues:");
            for (int j = 0; j < notas.length; j++) {
                System.out.println(notas[j] + ": " + quantidade[j]);
            }
        }

        sc.close();;
        
    }
}
