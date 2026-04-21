package util;

import entities.Nota;
import entities.Saque;
import excepitions.SaqueInvalidoException;
import service.CaixaService;

import java.util.Scanner;

public class Menu {

    private final CaixaService caixaService;
    private final Scanner scanner;

    public Menu(Scanner scanner, CaixaService service) {
        this.caixaService = service;
        this.scanner = scanner;
    }

    public void exibirCabecalho() {
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║        CAIXA ELETRÔNICO        ║");
        System.out.println("╚════════════════════════════════╝");
    }

    public int solicitarValorSaque() {
        System.out.print("Digite o valor do saque (múltiplo de 5): R$ ");
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido. Digite um número inteiro: R$ ");
            scanner.next();
        }
        return scanner.nextInt();
    
    }

    public void executar() {
        exibirCabecalho();
        int valor = solicitarValorSaque();

        Saque saque = new Saque (valor);
        try {
            caixaService.processarSaque(saque);
            exibirResultadoSaque(saque);
        } catch (SaqueInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    
    }

    public void exibirResultadoSaque(Saque saque) {
        System.out.println("Valor solicitado: R$ " + saque.getValorSolicitado());
        System.out.println("Notas fornecidas:");
        Nota[] notas = Nota.getNotasDisponiveis();
        int[] quantidades = saque.getQuantidadeNotas();

        for (int i = 0; i < notas.length; i++) {
            if (quantidades[i] > 0) {
                System.out.println(notas[i].getDescricao() + " - Quantidade: " + quantidades[i]);
            }
        }
        System.out.printf("Valor total: R$ %d%n", saque.getValorSolicitado());
        
    }

    
        
}
