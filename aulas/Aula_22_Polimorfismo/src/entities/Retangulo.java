package entities;

import utils.Forma;

public class Retangulo extends Forma {
    private double largura, altura;

    public Retangulo(String cor, double largura, double altura) {
        super(cor);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double area() {
        return largura * altura;
    }
}
