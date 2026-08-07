package entities.criterios;

import entities.Cliente;
import interfaces.Avaliavel;

/**
 * Avalia o perfil de crédito com base na idade do cliente.
 * Cada faixa etária reflete um nível diferente de estabilidade financeira.
 */

public class CriterioIdade implements Avaliavel {

    private final Cliente cliente;
    private String descricao;

    public CriterioIdade(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int calcularPontos() {
        int idade = cliente.getIdade();

        if (idade < 18) {
            descricao = "Menor de idade — perfil instável";
            return 50;
        } else if (idade < 30) {
            descricao = "18–29 anos — perfil variável";
            return 100;
        } else if (idade < 65) {
            descricao = "30–64 anos — perfil estável";
            return 200;
        } else {
            descricao = "65+ anos — perfil variável";
            return 50;
        }
    }

    @Override
    public String getDescricao() {
        return descricao != null ? descricao : "Critério de idade não avaliado";
    }
}
