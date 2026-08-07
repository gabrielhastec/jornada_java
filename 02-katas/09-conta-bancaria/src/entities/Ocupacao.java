package entities;

public enum Ocupacao {

    SERVIDOR_PUBLICO(1),
    PRIVADO(2),
    AUTONOMO(3);

    private int codigo;

    Ocupacao(int codigo) { 
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo; 
    }

    public static Ocupacao fromCodigo(int codigo) {
        for (Ocupacao o : values()) {
            if (o.codigo == codigo) return o;
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
