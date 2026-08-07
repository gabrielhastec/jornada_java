package application;

import entities.Conta;
import exceptions.ContaNaoEncontradaException;
import exceptions.SaldoInsuficienteException;
import repositories.ContaRepositorio;

public class Programa {

    public static void main(String[] args) {

        ContaRepositorio<Conta> contas = new ContaRepositorio<>();
        contas.salvar(new Conta("C1", "Ana", 500));
        contas.salvar(new Conta("C2", "Bruno", 200));

        // Unchecked: buscar conta inexistente (lança runtime exception)
        try {
            contas.buscarObrigatorio("C3");
        } catch (ContaNaoEncontradaException e) {
            System.out.println("Erro de busca: " + e.getMessage());
        }

        Conta contaAna = contas.buscarObrigatorio("C1");

        // Checked: saque que pode falhar
        try {
            realizarSaque(contaAna, 700); // vai lançar SaldoInsuficienteException
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saque falhou: " + e.getMessage());
        } finally {
            System.out.println("Saldo apos tentativa: " + contaAna.getSaldo());
        }

        // Saque bem-sucedido
        try {
            realizarSaque(contaAna, 150);
            System.out.println("Saque ok. Saldo atual: " + contaAna.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro inesperado no saque: " + e.getMessage());
        }

        // Multi-catch com erro aritmetico
        try {
            int resultado = dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Erro matematico: " + e.getMessage());
        }

        System.out.println("\nContas cadastradas (List do repositorio):");
        for (Conta c : contas.listarTodos()) {
            System.out.println(c);
        }
    }

    // throws propaga a checked exception
    private static void realizarSaque(Conta conta, double valor) throws SaldoInsuficienteException {
        conta.sacar(valor);
    }

    // Exemplo simples para multi-catch
    private static int dividir(Integer a, Integer b) {
        return a / b;
    }
}
