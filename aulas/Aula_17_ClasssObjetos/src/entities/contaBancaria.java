package entities;

public class contaBancaria {
    // Atributos (características da conta)
    public String titular;
    public int numero;
    public double saldo;

    // Método (comportamento)
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado. Saldo atual: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void exibirInfo() {
        System.out.println("Titular: " + titular + " | Conta: " + numero + " | Saldo: R$" + saldo);
    }
    
}
