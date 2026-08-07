package entities;

import interfaces.Tributavel;

/**
 * Funcionário contratado como Pessoa Jurídica (PJ).
 * Regra: sem desconto direto na folha — desconto é zero.
 * Recebe o salário bruto integral (sem benefícios embutidos no contrato).
 */
public class FuncionarioPJ extends Funcionario implements Tributavel {

    /**
     * PJ não possui benefícios por padrão.
     * O objeto Beneficios é criado internamente com tudo desativado.
     */
    public FuncionarioPJ(String nome, double salarioBase, int horasExtras) {
        super(nome, salarioBase, horasExtras, new Beneficios(false, false));
    }

    @Override
    public double calcularDesconto() {
        return 0.0; // PJ não tem desconto na fonte
    }

    @Override
    public double calcularSalarioLiquido() {
        double liquido = calcularSalarioBruto(); // sem desconto
        return aplicarSalarioMinimo(liquido);
    }

    @Override
    public String getTipoContrato() {
        return "PJ";
    }
}
