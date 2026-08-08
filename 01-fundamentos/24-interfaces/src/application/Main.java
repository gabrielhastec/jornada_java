package application;

import entities.Grafico;
import entities.Relatorio;
import interfaces.Imprimivel;

public class Main {
    public static void main(String[] args) {
        Imprimivel r = new Relatorio("Vendas do mês: R$ 10.000");
        Imprimivel g = new Grafico(new int[][]{{1,2},{3,4}});

        r.imprimir();
        g.imprimir();
    }
}
