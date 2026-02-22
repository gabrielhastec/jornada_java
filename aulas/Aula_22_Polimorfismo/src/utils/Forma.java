package utils;

public abstract class Forma {
    private String cor;

    public Forma(String cor) {
        this.cor = cor;
    }

    public String getCor() { return cor; }

    // Método abstrato – obriga as subclasses a implementarem
    public abstract double area();
}
