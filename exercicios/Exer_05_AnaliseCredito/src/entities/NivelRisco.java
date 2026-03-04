package entities;

/**
 * Classificação de risco baseada no score final.
 * Cada nível carrega sua faixa de score, rótulo e emoji para o relatório.
 */

public enum NivelRisco {

    BAIXO (700, 1000, "BAIXO",  "✅"),
    MEDIO (400,  699, "MÉDIO",  "⚠️ "),
    ALTO  (  0,  399, "ALTO",   "🚨");

    private final int    scoreMin;
    private final int    scoreMax;
    private final String rotulo;
    private final String icone;

    NivelRisco(int scoreMin, int scoreMax, String rotulo, String icone) {
        this.scoreMin = scoreMin;
        this.scoreMax = scoreMax;
        this.rotulo   = rotulo;
        this.icone    = icone;
    }

    public String getRotulo() { return rotulo; }
    public String getIcone()  { return icone; }

    public static NivelRisco fromScore(int score) {
        for (NivelRisco n : values()) {
            if (score >= n.scoreMin && score <= n.scoreMax) return n;
        }
        return ALTO;
    }
}
