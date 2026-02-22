package application;

import entities.Conta;
import entities.ContaEspecial;

public class Main {
    public static void main(String[] args) {
        Conta c = new Conta("João", 1000);
        c.sacar(1100); // saldo insuficiente

        ContaEspecial ce = new ContaEspecial("Maria", 1000, 500);
        ce.sacar(1200); // usa o limite, saldo fica -200
        ce.exibirSaldo();
    }
}
