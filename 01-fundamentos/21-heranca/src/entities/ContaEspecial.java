package entities;

public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(String titular, double saldoInicial, double limite) {
        super(titular, saldoInicial); // chama o construtor da superclasse
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
        } else {
            System.out.println("Limite insuficiente.");
        }
    }

    public double getLimite() { return limite; }
}
