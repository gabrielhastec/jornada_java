package utils;

import entities.Funcionario;
import entities.FuncionarioCLT;
import entities.FuncionarioPJ;
import entities.Beneficios;

import java.util.Scanner;

/**
 * Responsável por toda a interação com o usuário:
 * coleta de dados e montagem do objeto Funcionario correto.
 */
public class Menu {

    public static void exibirCabecalho() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       SISTEMA DE FOLHA SALARIAL      ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    /**
     * Lê os dados do funcionário e retorna um FuncionarioCLT ou FuncionarioPJ
     * já configurado com seus benefícios.
     */
    public static Funcionario coletarDados(Scanner sc) {

        System.out.print("\nNome do funcionário: ");
        String nome = sc.nextLine();

        System.out.print("Salário base (R$): ");
        double salarioBase = lerDouble(sc);

        System.out.print("Horas extras no mês: ");
        int horasExtras = lerInt(sc);

        System.out.println("\nTipo de contrato:");
        System.out.println("  1 - CLT  (com desconto INSS 8%)");
        System.out.println("  2 - PJ   (sem desconto)");
        System.out.print("Escolha: ");
        int tipoContrato = lerIntLinha(sc);

        if (tipoContrato == 1) {
            Beneficios beneficios = coletarBeneficios(sc);
            return new FuncionarioCLT(nome, salarioBase, horasExtras, beneficios);
        } else {
            System.out.println("\n PJ não possui benefícios via folha.");
            return new FuncionarioPJ(nome, salarioBase, horasExtras);
        }
    }

    private static Beneficios coletarBeneficios(Scanner sc) {
        System.out.println("\n── Benefícios ──────────────────────────");
        System.out.print("  Vale Alimentação (R$ 600,00)? [S/N]: ");
        boolean va = sc.nextLine().trim().equalsIgnoreCase("S");

        System.out.print("  Plano de Saúde   (R$ 300,00)? [S/N]: ");
        boolean saude = sc.nextLine().trim().equalsIgnoreCase("S");

        return new Beneficios(va, saude);
    }

    public static boolean perguntarNovoCadastro(Scanner sc) {
        System.out.print("\nProcessar outro funcionário? [S/N]: ");
        return sc.nextLine().trim().equalsIgnoreCase("S");
    }

    // ── Helpers de leitura segura ────────────────────────────────────────────

    private static double lerDouble(Scanner sc) {
        while (true) {
            try {
                double val = Double.parseDouble(sc.nextLine().replace(",", ".").trim());
                if (val < 0) { System.out.print("  Valor não pode ser negativo. Tente novamente: "); continue; }
                return val;
            } catch (NumberFormatException e) {
                System.out.print("  Valor inválido. Tente novamente: ");
            }
        }
    }

    private static int lerInt(Scanner sc) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val < 0) { System.out.print("  Valor não pode ser negativo. Tente novamente: "); continue; }
                return val;
            } catch (NumberFormatException e) {
                System.out.print("  Valor inválido. Tente novamente: ");
            }
        }
    }

    private static int lerIntLinha(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("  Opção inválida. Tente novamente: ");
            }
        }
    }
}
