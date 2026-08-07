package service;

import entities.Funcionario;
import interfaces.Tributavel;

/**
 * Serviço responsável por processar os cálculos da folha
 * e gerar o relatório/holerite de um funcionário.
 *
 * Recebe qualquer Funcionario que também seja Tributavel,
 * demonstrando o uso de múltiplas interfaces como contrato.
 */
public class FolhaService {

    /**
     * Gera e imprime o holerite completo do funcionário.
     *
     * @param funcionario qualquer instância que seja Funcionario e Tributavel
     * @param <T>         tipo genérico que garante os dois contratos ao mesmo tempo
     */
    public <T extends Funcionario & Tributavel> void gerarHolerite(T funcionario) {

        double bruto        = funcionario.calcularSalarioBruto();
        double horasExtras  = funcionario.calcularHorasExtras();
        double desconto     = funcionario.calcularDesconto();
        double liquido      = funcionario.calcularSalarioLiquido();
        double beneficios   = funcionario.getBeneficios().totalBeneficios();
        double remuneracao  = funcionario.calcularRemuneracaoTotal();

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║           HOLERITE MENSAL            ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║  Funcionário : %-22s║%n", funcionario.getNome());
        System.out.printf( "║  Contrato    : %-22s║%n", funcionario.getTipoContrato());
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║  Salário Base      : R$ %12.2f ║%n", funcionario.getSalarioBase());
        System.out.printf( "║  Horas Extras (%2dh): R$ %12.2f ║%n", funcionario.getHorasExtras(), horasExtras);
        System.out.printf( "║  Salário Bruto     : R$ %12.2f ║%n", bruto);
        System.out.println("╠══════════════════════════════════════╣");

        if (desconto > 0) {
            System.out.printf("║  Desconto INSS(8%%): R$ %12.2f  ║%n", desconto);
        } else {
            System.out.println("║  Desconto INSS    : Isento (PJ)      ║");
        }

        System.out.printf( "║  Salário Líquido  : R$ %12.2f  ║%n", liquido);
        if (beneficios > 0) {
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║           BENEFÍCIOS                 ║");
            System.out.printf( "║  Vale Alimentação : %-17s║%n",
                    funcionario.getBeneficios().isValeAlimentacao()
                            ? String.format("R$ %,.2f", entities.Beneficios.getValorVa())
                            : "Não contratado");
            System.out.printf( "║  Plano de Saúde   : %-17s║%n",
                    funcionario.getBeneficios().isPlanoSaude()
                            ? String.format("R$ %,.2f", entities.Beneficios.getValorSaude())
                            : "Não contratado");
            System.out.printf( "║  Total Benefícios : R$ %12.2f  ║%n", beneficios);
            System.out.println("╠══════════════════════════════════════╣");
            System.out.printf( "║  REMUNERAÇÃO TOTAL: R$ %12.2f  ║%n", remuneracao);
        } else {
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  Benefícios       : Não aplicável    ║");
            System.out.println("║                    (contrato PJ)     ║");
            System.out.printf( "║  REMUNERAÇÃO TOTAL: R$ %12.2f  ║%n", liquido);
        }
        System.out.println("╚══════════════════════════════════════╝");

        // Aviso de salário mínimo
        if (liquido == Funcionario.getSalarioMinimo()) {
            System.out.println("Salário ajustado para o mínimo: R$ "
                    + String.format("%.2f", Funcionario.getSalarioMinimo()) + "ajuste automático.");
        }
    }
}
