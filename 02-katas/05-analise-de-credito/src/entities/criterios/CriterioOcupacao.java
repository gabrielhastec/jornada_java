package entities.criterios;

import entities.Cliente;
import interfaces.Avaliavel;

/**
 * Avalia o perfil de crédito com base na ocupação do cliente.
 * Delega a pontuação para o próprio enum Ocupacao,
 * mantendo a regra encapsulada no lugar certo.
 */

public class CriterioOcupacao implements Avaliavel {

    private final Cliente cliente;

    public CriterioOcupacao(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int calcularPontos() {
        return cliente.getOcupacao().getPontos();
    }

    @Override
    public String getDescricao() {
        return cliente.getOcupacao().getDescricao()
                + " (" + (calcularPontos() >= 0 ? "+" : "") + calcularPontos() + " pts)";
    }
}
