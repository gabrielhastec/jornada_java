package entities;

import interfaces.Imprimivel;

public class Grafico implements Imprimivel {
    private int[][] dados;

    public Grafico(int[][] dados) {
        this.dados = dados;
    }

    @Override
    public void imprimir() {
        System.out.println("=== GRÁFICO ===");
        for (int[] linha : dados) {
            for (int valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}
