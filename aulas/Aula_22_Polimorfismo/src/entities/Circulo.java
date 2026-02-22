package entities;

import utils.Forma;

public class Circulo extends Forma {
    private double raio;

    public Circulo(String cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }
}
