package service;

import entities.Cliente;
import entities.NivelRisco;
import entities.ResultadoAnalise;
import entities.criterios.CriterioIdade;
import entities.criterios.CriterioOcupacao;
import entities.criterios.CriterioRenda;
import interfaces.Avaliavel;

import java.util.ArrayList;
import java.util.List;

/**
 * Orquestra a análise de crédito aplicando cada critério na sequência.
 *
 * Por trabalhar com a interface Avaliavel, não sabe (nem precisa saber)
 * como cada critério calcula sua pontuação — padrão Strategy em ação.
 * Para adicionar um novo critério basta criar uma classe que implemente
 * Avaliavel e incluí-la na lista abaixo.
 */

public class AnalisadorCredito {

    private static final int SCORE_MAXIMO    = 1000;
    private static final int SCORE_APROVACAO = 600;
    private static final int IDADE_MINIMA    = 18;
    private static final double RENDA_MINIMA = 1500.0;

    private final LimiteService limiteService;

    public AnalisadorCredito(LimiteService limiteService) {
        this.limiteService = limiteService;
    }

    public ResultadoAnalise analisar(Cliente cliente) {

        // Monta a lista de critérios — aqui é onde o Strategy brilha:
        // basta adicionar ou remover critérios sem tocar no resto do código.
        List<Avaliavel> criterios = new ArrayList<>();
        criterios.add(new CriterioIdade(cliente));
        criterios.add(new CriterioOcupacao(cliente));
        criterios.add(new CriterioRenda(cliente));

        // Aplica cada critério e coleta os detalhes para o relatório
        int          scoreTotal = 0;
        List<String> detalhes   = new ArrayList<>();

        for (Avaliavel criterio : criterios) {
            int pontos = criterio.calcularPontos(); // dispara o cálculo e preenche getDescricao()
            scoreTotal += pontos;
            detalhes.add(criterio.getDescricao()
                    + " → " + (pontos >= 0 ? "+" : "") + pontos + " pts");
        }

        // Aplica teto do score
        scoreTotal = Math.min(scoreTotal, SCORE_MAXIMO);

        // Regras de aprovação (todas devem ser satisfeitas)
        boolean aprovado = cliente.getIdade()  >= IDADE_MINIMA
                        && cliente.getRenda()  >= RENDA_MINIMA
                        && scoreTotal          >= SCORE_APROVACAO;

        NivelRisco risco  = NivelRisco.fromScore(scoreTotal);
        double     limite = limiteService.calcularLimite(cliente, scoreTotal, aprovado);

        return new ResultadoAnalise(cliente, scoreTotal, risco, aprovado, limite, detalhes);
    }
}
