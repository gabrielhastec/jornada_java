package interfaces;

/**
 * Contrato que define o comportamento tributário de um funcionário.
 * Toda classe que implementar Tributavel deve saber calcular
 * seu próprio desconto e salário líquido.
 */

public interface Tributavel {
    double calcularDesconto();
    double calcularSalarioLiquido();
    String getTipoContrato();
}
