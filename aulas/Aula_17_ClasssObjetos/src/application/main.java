package application;
import entities.contaBancaria;

public class main {
    public static void Main(String[] args) {

        // Criando um objeto (instância) da classe ContaBancaria
        contaBancaria conta1 = new contaBancaria();
        conta1.titular = "João";
        conta1.numero = 123;
        conta1.saldo = 1000.0;

        conta1.exibirInfo();
        conta1.depositar(500);
        conta1.sacar(200);
        conta1.sacar(2000); // tentativa com saldo insuficiente
    }
}
