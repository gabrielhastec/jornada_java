package utils;

import java.util.Scanner;

public class Menu {

    private Scanner sc;

    public Menu(Scanner scanner) {
        this.sc = scanner;
    }

    public void exibirCabecalho() {
        System.out.println("======== CALCULADORA ========");
    }

    public void exibirOperacoes() {
        System.out.println("--- Dígitos das operações: ---");
        System.out.println(" 1 - Adição ");
        System.out.println(" 2 - Subtração ");
        System.out.println(" 3 - Multiplicação ");
        System.out.println(" 4 - Divisão ");
    }

    public double lerOpcao(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido. Digite um número: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    public int lerOperador(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextInt()) {
            System.out.print("Valor inválido. Digite um dígito de operação: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public boolean askContinuar() {
        System.out.println("\nDeseja fazer outra operação?");
        System.out.println("  1 - Sim   |   2 - Não");
        int resp = sc.nextInt();
        return resp == 1;
    }

    public void exibirResultado(String resultado) {
        System.out.println( "Resultado: " + resultado);
        
    }
 
    public void exibirErro(String mensagem) {
        System.out.println("⚠ " + mensagem);
    }
 
    public void exibirEncerramento() {
        System.out.println("========= ENCERRANDO... =========");

    }
    
}

    
    

