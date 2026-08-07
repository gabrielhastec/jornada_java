package application;

import entities.Cliente;
import entities.ResultadoAnalise;
import service.AnalisadorCredito;
import service.LimiteService;
import service.RelatorioService;
import utils.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner          sc           = new Scanner(System.in);
        AnalisadorCredito analisador  = new AnalisadorCredito(new LimiteService());
        RelatorioService  relatorio   = new RelatorioService();
        List<ResultadoAnalise> historico = new ArrayList<>();

        Menu.exibirCabecalho();

        boolean continuar = true;
        while (continuar) {
            Cliente          cliente   = Menu.coletarDados(sc);
            ResultadoAnalise resultado = analisador.analisar(cliente);

            relatorio.exibirResultado(resultado);
            historico.add(resultado);

            continuar = Menu.perguntarNovaAnalise(sc);
        }

        // Exibe resumo consolidado da sessão se houver mais de uma análise
        if (historico.size() > 1) {
            relatorio.exibirResumoSessao(historico);
        }

        System.out.println("\nSistema encerrado. Até logo!");
        sc.close();
    }
}
