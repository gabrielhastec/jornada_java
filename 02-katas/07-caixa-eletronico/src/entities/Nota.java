package entities;

public enum Nota {

    CEM(100, "R$ 100"),
    CINQUENTA(50, "R$ 50"),
    VINTE(20, "R$ 20"),
    DEZ(10, "R$ 10"),
    CINCO(5, "R$ 5");

    private final int valor;
    private final String descricao;

    Nota(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;       
    }

    public static Nota[] getNotasDisponiveis() {
        return values();        
    }

}
