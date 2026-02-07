/*
Fazer um programa para ler o código de uma peça 1, 
o número de peças 1, o valor unitário de cada peça 1, 
o código de uma peça 2, o número de peças 2 
e o valor unitário de cada peça 2. Calcule 
e mostre o valor a ser pago.
*/

import java.util.Scanner;

public class venda {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int idProduto1, qtdProduto1, valorUnit1, idProduto2, qtdProduto2, valorUnit2;
        double resultado1, resultado2, totalVenda;

        System.out.println("======= Vamos registrar a primeira venda: =======");
        System.out.println("Digite o código do Produto 01: ");
        idProduto1 = sc.nextInt();
        System.out.println("Digite o valor Unitário do Produto 01: ");
        valorUnit1 = sc.nextInt();
        System.out.println("Digite a quantidade do Produto 01: ");
        qtdProduto1 = sc.nextInt();

        System.out.println("======= Vamos registrar a segunda venda: =======");
        System.out.println("Digite o código do Produto 02: ");
        idProduto2 = sc.nextInt();
        System.out.println("Digite o valor Unitário do Produto 02: ");
        valorUnit2 = sc.nextInt();
        System.out.println("Digite a quantidade do Produto 02: ");
        qtdProduto2 = sc.nextInt();

        resultado1 = (double) qtdProduto1 * valorUnit1;
        resultado2 = (double) qtdProduto2 * valorUnit2;
        totalVenda = resultado1 + resultado2;

        System.out.println("======= FINALIZANDO A VENDA: =======");
        System.out.printf("Produto: %d  |  Valor: %.2f\n", idProduto1, resultado1);
        System.out.printf("Produto: %d  |  Valor: %.2f\n", idProduto2, resultado2);
        System.out.println("===================================");
        System.out.printf("Valor total da venda: %.2f\n", totalVenda);

        sc.close();

    }
    
}
