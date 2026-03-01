package entities;

/**
 * Representa o pacote de benefícios de um funcionário.
 * Usa composição dentro de Funcionario.
 * Cada benefício pode ser ativado ou desativado individualmente.
 */

public class Beneficios {

    private boolean valeAlimentacao;
    private boolean planoSaude;

    private static final double VALOR_VA        = 600.0;
    private static final double VALOR_SAUDE     = 300.0;

    public Beneficios(boolean valeAlimentacao, boolean planoSaude) {
        this.valeAlimentacao = valeAlimentacao;
        this.planoSaude      = planoSaude;
    }

    /** Retorna o total em reais que o funcionário recebe em benefícios. */
    public double totalBeneficios() {
        double total = 0;
        if (valeAlimentacao) total += VALOR_VA;
        if (planoSaude)      total += VALOR_SAUDE;
        return total;
    }

    public boolean isValeAlimentacao() { return valeAlimentacao; }
    public boolean isPlanoSaude()      { return planoSaude; }

    public void setValeAlimentacao(boolean valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }
    public void setPlanoSaude(boolean planoSaude) {
        this.planoSaude = planoSaude;
    }

    public static double getValorVa()     { return VALOR_VA; }
    public static double getValorSaude()  { return VALOR_SAUDE; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Vale Alimentação : ")
          .append(valeAlimentacao ? String.format("R$ %.2f", VALOR_VA) : "Não contratado")
          .append("\n");
        sb.append("  Plano de Saúde   : ")
          .append(planoSaude ? String.format("R$ %.2f", VALOR_SAUDE) : "Não contratado");
        return sb.toString();
    }
}
