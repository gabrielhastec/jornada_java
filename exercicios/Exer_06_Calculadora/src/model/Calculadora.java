package model;

import utils.DivisaoPorZeroException;

public class Calculadora extends DivisaoPorZeroException {

    private int dgVerificador;
    private double opcao1, opcao2, resultado;

    public Calculadora(double opcao1, double opcao2, int dgVerificador) {
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.dgVerificador = dgVerificador;
    }
    
    public double calcular() {
        switch (dgVerificador) {
            case 1:
                resultado = opcao1 + opcao2;
                break;
            case 2:
                resultado = opcao1 - opcao2;
                break;
            case 3:
                resultado = opcao1 * opcao2;
                break;
            case 4:
                if (opcao2 == 0) {
                    throw new utils.DivisaoPorZeroException();
                }
                resultado = opcao1 / opcao2;
                break;
            default:
                throw new IllegalArgumentException("Operação inválida. Escolha 1, 2, 3 ou 4.");
        }
        return resultado;
    }

    public double getOpcao1() {
        return opcao1;
    }

    public double getOpcao2() {
        return opcao2;
    }

    public int getDgVerificador() {
        return dgVerificador;
    }

    public double getResultado() {
        return resultado;
    }

    private String getOperadorSimbolo() {
        switch (dgVerificador) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
            case 4:
                return "/";
            default:
                return "?";
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f %s %.2f = %.2f",
                opcao1, getOperadorSimbolo(), opcao2, resultado);
    }

}
