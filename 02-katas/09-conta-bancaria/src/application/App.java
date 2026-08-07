package application;

import entities.Cliente;
import service.BancoService;
import service.CadastroService;
import utils.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        CadastroService cadastroService = new CadastroService();
        BancoService bancoService = new BancoService(clientes);

        int opcao; 

        do {
            
            Menu.exibirMenuPrincipal();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    Menu.menuCadastro(sc, clientes, cadastroService);
                    break;
                case 2:
                    Menu.menuOperacao(sc, bancoService);
                    break;
                case 3:
                    Menu.menuExtrato(sc, clientes);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
