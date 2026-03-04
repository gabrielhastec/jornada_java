package entities;

/**
 * Tipos de ocupação com sua pontuação de crédito embutida.
 * A pontuação é parte da regra de negócio da ocupação,
 * então faz sentido ela viver aqui, não espalhada em if/else.
 */

public enum Ocupacao {

    CARTEIRA_ASSINADA(1, "Carteira Assinada",  400),
    SERVIDOR_PUBLICO (2, "Servidor Público",   600),
    AUTONOMO         (3, "Autônomo/Empreendedor", 200),
    ESTUDANTE        (4, "Estudante/Estágio",  100),
    DESEMPREGADO     (5, "Desempregado",      -100);

    private final int    codigo;
    private final String descricao;
    private final int    pontos;

    Ocupacao(int codigo, String descricao, int pontos) {
        this.codigo    = codigo;
        this.descricao = descricao;
        this.pontos    = pontos;
    }

    public int    getCodigo()    { return codigo; }
    public String getDescricao() { return descricao; }
    public int    getPontos()    { return pontos; }

    public static Ocupacao fromCodigo(int codigo) {
        for (Ocupacao o : values()) {
            if (o.codigo == codigo) return o;
        }
        throw new IllegalArgumentException("Código de ocupação inválido: " + codigo);
    }
}
