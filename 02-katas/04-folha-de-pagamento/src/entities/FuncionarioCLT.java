package entities;

import interfaces.Tributavel;

/**
 * Funcionário com vínculo CLT.
 * Regra: desconto de 8% de INSS sobre o salário bruto.
 */

public class FuncionarioCLT extends Funcionario implements Tributavel {

    private static final double ALIQUOTA_INSS = 0.08;

    public FuncionarioCLT(String nome, double salarioBase, int horasExtras, Beneficios beneficios) {
        super(nome, salarioBase, horasExtras, beneficios);
    }

    @Override
    public double calcularDesconto() {
        return calcularSalarioBruto() * ALIQUOTA_INSS;
    }

    @Override
    public double calcularSalarioLiquido() {
        double liquido = calcularSalarioBruto() - calcularDesconto();
        return aplicarSalarioMinimo(liquido);
    }

    @Override
    public String getTipoContrato() {
        return "CLT";
    }

    public static double getAliquotaInss() { return ALIQUOTA_INSS; }
}
