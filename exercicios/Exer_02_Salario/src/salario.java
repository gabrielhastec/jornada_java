/*
Fazer um programa que leia o número de um funcionário, 
seu número de horas trabalhadas, o valor que recebe por
hora e calcula o salário desse funcionário. 
A seguir, mostre o número e o salário do funcionário, 
com duas casas decimais. 
*/

import java.util.Scanner;

public class salario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int funcionario, horaTrabalhada, salarioHora;
        double salarioTotal;

        System.out.println("Digite o número do funcionário: ");
        funcionario = sc.nextInt();

        System.out.println("Quantas horas trabalhadas: ");
        horaTrabalhada = sc.nextInt();

        System.out.println("Valor que recebe por hora: ");
        salarioHora = sc.nextInt();

        salarioTotal = horaTrabalhada * salarioHora;

        System.out.printf("Olá funcionário: %d, seu salário é: %.2f", funcionario, salarioTotal);

        sc.close();

        
    }
    
}
