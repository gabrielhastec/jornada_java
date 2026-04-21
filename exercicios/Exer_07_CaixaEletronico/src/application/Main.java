package application;

import service.CaixaService;
import util.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CaixaService caixaService = new CaixaService();
        Menu menu = new Menu(scanner, caixaService);

        menu.executar();

        scanner.close();
    }
    
}
