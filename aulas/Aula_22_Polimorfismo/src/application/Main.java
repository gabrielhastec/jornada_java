package application;

import entities.Circulo;
import entities.Retangulo;
import utils.Forma;

public class Main {
    public static void main(String[] args) {
        // Polimorfismo: variável do tipo Forma pode referenciar qualquer subclasse
        Forma f1 = new Circulo("Vermelho", 3.0);
        Forma f2 = new Retangulo("Azul", 4.0, 5.0);

        System.out.println("Área do círculo: " + f1.area());
        System.out.println("Área do retângulo: " + f2.area());

        // Não é possível instanciar Forma porque é abstrata:
        // Forma f = new Forma("Verde"); // erro de compilação
    }
}
