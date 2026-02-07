/*Faça um programa para ler dois valores inteiros, 
e depois mostrar na tela a soma desses números 
com uma mensagem explicativa */

import java.util.Scanner;

public class operBasica {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int x, y, resultado;

        x = sc.nextInt();
        y = sc.nextInt();
        resultado = (x+y);

        System.out.println("O resultado da soma é: " + resultado);

        sc.close();

    }
    
}
