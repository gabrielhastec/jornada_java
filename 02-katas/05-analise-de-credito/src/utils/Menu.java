package utils;

import entities.Cliente;
import entities.Ocupacao;

import java.util.Scanner;

/**
 * Responsável por toda a interação com o usuário na entrada de dados.
 */

public class Menu {

    public static void exibirCabecalho() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    SISTEMA DE ANÁLISE DE CRÉDITO     ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    /** Lê os dados do terminal e retorna um Cliente pronto para análise. */
    public static Cliente coletarDados(Scanner sc) {
        System.out.print("\nNome do solicitante: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = lerInt(sc);

        System.out.println("\nOcupação:");
        for (Ocupacao o : Ocupacao.values()) {
            System.out.printf("  %d - %s%n", o.getCodigo(), o.getDescricao());
        }
        System.out.print("Escolha: ");
        Ocupacao ocupacao = lerOcupacao(sc);

        System.out.print("Renda mensal (R$): ");
        double renda = lerDouble(sc);

        return new Cliente(nome, idade, ocupacao, renda);
    }

    public static boolean perguntarNovaAnalise(Scanner sc) {
        System.out.print("\nAnalisar outro cliente? [S/N]: ");
        return sc.nextLine().trim().equalsIgnoreCase("S");
    }

    // ── Helpers de leitura segura ────────────────────────────────────────────

    private static int lerInt(Scanner sc) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val < 0) { System.out.print("  Valor não pode ser negativo: "); continue; }
                return val;
            } catch (NumberFormatException e) {
                System.out.print("  Valor inválido. Tente novamente: ");
            }
        }
    }

    private static double lerDouble(Scanner sc) {
        while (true) {
            try {
                double val = Double.parseDouble(sc.nextLine().replace(",", ".").trim());
                if (val < 0) { System.out.print("  Valor não pode ser negativo: "); continue; }
                return val;
            } catch (NumberFormatException e) {
                System.out.print("  Valor inválido. Tente novamente: ");
            }
        }
    }

    private static Ocupacao lerOcupacao(Scanner sc) {
        while (true) {
            try {
                return Ocupacao.fromCodigo(Integer.parseInt(sc.nextLine().trim()));
            } catch (IllegalArgumentException e) {
                System.out.print("  Opção inválida. Escolha entre 1 e 5: ");
            }
        }
    }
}
