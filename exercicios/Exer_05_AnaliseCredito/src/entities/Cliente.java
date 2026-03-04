package entities;

/**
 * Representa o cliente que solicita análise de crédito.
 * Apenas armazena e expõe dados — sem lógica de negócio aqui.
 */

public class Cliente {

    private final String   nome;
    private final int      idade;
    private final Ocupacao ocupacao;
    private final double   renda;

    public Cliente(String nome, int idade, Ocupacao ocupacao, double renda) {
        this.nome     = nome;
        this.idade    = idade;
        this.ocupacao = ocupacao;
        this.renda    = renda;
    }

    public String   getNome()     { return nome; }
    public int      getIdade()    { return idade; }
    public Ocupacao getOcupacao() { return ocupacao; }
    public double   getRenda()    { return renda; }
}
