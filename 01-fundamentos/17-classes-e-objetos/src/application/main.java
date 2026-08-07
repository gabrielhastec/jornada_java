package application;
import entities.ContaBancaria;

public class Main {

    public static void main(String[] args) {

        // Criando um objeto (instância) da classe ContaBancaria
        ContaBancaria conta1 = new ContaBancaria();
        conta1.titular = "João";
        conta1.numero = 123;
        conta1.saldo = 1000.0;

        conta1.exibirInfo();
        conta1.depositar(500);
        conta1.sacar(200);
        conta1.sacar(2000); // tentativa com saldo insuficiente
    }
}
