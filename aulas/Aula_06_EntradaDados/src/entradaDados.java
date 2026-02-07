
import java.util.Locale;
import java.util.Scanner;

public class entradaDados {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double x;

        System.out.println("Digite um número decimal: ");
        x = sc.nextDouble();
        System.out.println("Você digitou: " + x);
        //formatação
        System.out.printf("Você Digitou: %.2f%n", x);   

        // Caractere
        char y;

        System.out.println("Escreva uma palavra: ");
        y = sc.next().charAt(0);
        System.out.println("A primeira letra é: " + y);

        //
        String a1;
        int a2;
        double a3;

        System.out.println("Escreva uma palavra: ");
        a1 = sc.next();
        System.out.printf("Você digitou um String: %s%n", a1);

        System.out.println("Escreva um numero inteiro: ");
        a2 = sc.nextInt();
        System.out.printf("Você digitou um inteiro: %d%n", a2);

        System.out.println("Escreva um numero decimal: ");
        a3 = sc.nextDouble();
        System.out.printf("Você digitou um Double: %.2f%n", a3);       
        
        //
        String s1;

        System.out.println("Digite uma frase: ");
        s1 = sc.nextLine();
        System.out.println("Sua frase é: " + s1);

        sc.close();

    }
}