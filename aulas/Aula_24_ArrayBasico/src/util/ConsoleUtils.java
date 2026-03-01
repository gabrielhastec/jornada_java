package util;

import java.util.Scanner;

public class ConsoleUtils {

    private static final Scanner sc = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        return sc.nextInt();
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        return sc.nextDouble();
    }
}
