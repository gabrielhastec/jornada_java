package application;

import entities.Funcionario;
import interfaces.Tributavel;
import service.FolhaService;
import utils.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc      = new Scanner(System.in);
        FolhaService folhaService = new FolhaService();

        Menu.exibirCabecalho();

        boolean continuar = true;
        while (continuar) {

            // coletarDados sempre retorna CLT ou PJ, ambos implementam Tributavel
            Funcionario funcionario = Menu.coletarDados(sc);

            // Cast seguro: sabemos que CLT e PJ implementam Tributavel
            if (funcionario instanceof Tributavel) {
                folhaService.gerarHolerite((Funcionario & Tributavel) funcionario);
            }

            continuar = Menu.perguntarNovoCadastro(sc);
        }

        System.out.println("\nSistema encerrado. Até logo!");
        sc.close();
    }
}
