package entities.criterios;

import entities.Cliente;
import interfaces.Avaliavel;

/**
 * Avalia o perfil de crédito com base na renda mensal do cliente.
 */

public class CriterioRenda implements Avaliavel {

    private final Cliente cliente;
    private String descricao;

    public CriterioRenda(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int calcularPontos() {
        double renda = cliente.getRenda();

        if (renda < 1500) {
            descricao = "Renda abaixo de R$ 1.500";
            return -50;
        } else if (renda < 3000) {
            descricao = "Renda entre R$ 1.500 e R$ 2.999";
            return 100;
        } else if (renda < 5000) {
            descricao = "Renda entre R$ 3.000 e R$ 4.999";
            return 150;
        } else {
            descricao = "Renda acima de R$ 5.000";
            return 200;
        }
    }

    @Override
    public String getDescricao() {
        return descricao != null ? descricao : "Critério de renda não avaliado";
    }
}
