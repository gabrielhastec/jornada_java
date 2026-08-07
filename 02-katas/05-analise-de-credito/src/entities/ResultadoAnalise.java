package entities;

import java.util.List;

/**
 * Encapsula o resultado completo de uma análise de crédito.
 *
 * É um Value Object: imutável, criado pelo AnalisadorCredito
 * e consumido pelo relatório. Não tem lógica de negócio.
 */

public class ResultadoAnalise {

    private final Cliente          cliente;
    private final int              score;
    private final NivelRisco       risco;
    private final boolean          aprovado;
    private final double           limiteCredito;
    private final List<String>     detalhesCriterios;

    public ResultadoAnalise(
            Cliente      cliente,
            int          score,
            NivelRisco   risco,
            boolean      aprovado,
            double       limiteCredito,
            List<String> detalhesCriterios) {

        this.cliente           = cliente;
        this.score             = score;
        this.risco             = risco;
        this.aprovado          = aprovado;
        this.limiteCredito     = limiteCredito;
        this.detalhesCriterios = detalhesCriterios;
    }

    public Cliente      getCliente()           { return cliente; }
    public int          getScore()             { return score; }
    public NivelRisco   getRisco()             { return risco; }
    public boolean      isAprovado()           { return aprovado; }
    public double       getLimiteCredito()     { return limiteCredito; }
    public List<String> getDetalhesCriterios() { return detalhesCriterios; }
}
