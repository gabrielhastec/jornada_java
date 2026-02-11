import java.util.Scanner;

public class bitwise {
    
    public static void main(String[] args) {
        
        // Operadores bitwise
        int a = 5; // 0101 em binário
        int b = 3; // 0011 em binário

        // AND bitwise
        int andResult = a & b; // 0001 em binário, resultado é 1
        System.out.println("AND bitwise: " + andResult);

        // OR bitwise
        int orResult = a | b; // 0111 em binário, resultado é 7
        System.out.println("OR bitwise: " + orResult);

        // XOR bitwise
        int xorResult = a ^ b; // 0110 em binário, resultado é 6
        System.out.println("XOR bitwise: " + xorResult);

        // NOT bitwise
        int notResult = ~a; // 1010 em binário (complemento de 2), resultado é -6
        System.out.println("NOT bitwise: " + notResult);

        // Caso de uso: Verificar se um número é par ou ímpar usando bitwise
        int number = 10; // 1010 em binário
        boolean isEven = (number & 1) == 0; // Verifica o bit menos significativo
        System.out.println(number + " é par? " + isEven);

        //

        Scanner sc = new Scanner(System.in);

        int mask = 0b00001111; // Máscara para extrair os 4 bits menos significativos
        int n = sc.nextInt(); // Lê um número inteiro do usuário

        if ((n & mask) != 0) {
            System.out.println("6th bit is true!");
        } else {
            System.out.println("6th bit is false!");
        }

        sc.close();

    }
}
