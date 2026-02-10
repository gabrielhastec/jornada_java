import java.util.Locale;
import java.util.Scanner;

public class atribCumulativas {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int a, x;

        // Atribuições Convencionais
        a = 5;
        a = a + 3; // a agora é 8
        a = a * 2; // a agora é 16
        a = a - 4; // a agora é 12
        a = a / 2; // a agora é 6

        // Caso de uso: conta telefônica
        int minutos = sc.nextInt();
        double conta = 50.0;

        if (minutos > 100) {
            conta = conta + (minutos - 100) * 2.0;
        }

        System.out.printf("Valor a pagar: R$ %.2f%n", conta);

        // Atribuições Cumulativas
        x = 5;
        x += 3; // x agora é 8
        x *= 2; // x agora é 16
        x -= 4; // x agora é 12
        x /= 2; // x agora é 6

        // Caso de uso: conta telefônica com atribuição cumulativa
        int minutos2 = sc.nextInt();
        double conta2 = 50.0;

        if (minutos2 > 100) {
            conta2 += (minutos2 - 100) * 2.0;
        }

        System.out.printf("Valor a pagar: R$ %.2f%n", conta2);

        sc.close();

        
    }
}
