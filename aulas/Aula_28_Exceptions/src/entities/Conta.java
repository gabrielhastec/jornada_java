package entities;

import exceptions.SaldoInsuficienteException;

public class Conta implements Identificavel {

    private final String id;
    private final String titular;
    private double saldo;

    public Conta(String id, String titular, double saldoInicial) {
        this.id = id;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Deposito negativo nao permitido.");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor < 0) {
            throw new IllegalArgumentException("Saque negativo nao permitido.");
        }
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para sacar " + valor);
        }
        saldo -= valor;
    }

    @Override
    public String toString() {
        return id + " - " + titular + " (saldo: " + saldo + ")";
    }
}
