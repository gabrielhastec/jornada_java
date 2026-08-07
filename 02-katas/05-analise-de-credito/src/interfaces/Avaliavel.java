package interfaces;

/**
 * Contrato para qualquer critério de avaliação de crédito.
 *
 * Cada critério (idade, ocupação, renda) sabe:
 *  - quanto vale em pontos para um determinado cliente
 *  - como se descrever para o relatório
 *
 * Padrão Strategy: o AnalisadorCredito não precisa saber
 * como cada critério funciona — só chama calcularPontos().
 */

public interface Avaliavel {
    int calcularPontos();
    String getDescricao();
}
