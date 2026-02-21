package utils;

import entities.Cliente;
import service.BancoService;
import service.CadastroService;
import utils.Exceptions.*;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void exibirMenuPrincipal() {
        System.out.println("\n===== SISTEMA BANCÁRIO =====");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Operação");
        System.out.println("3 - Extrato");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public static void menuCadastro(Scanner sc, List<Cliente> clientes, CadastroService cadastroService) {
        System.out.println("\n--- CADASTRO DE CLIENTE ---");
        try {
            System.out.print("CPF (apenas números): ");
            String id = sc.nextLine();

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine();

            System.out.println("Ocupação:");
            System.out.println("1 - Servidor público");
            System.out.println("2 - Privado");
            System.out.println("3 - Autônomo");
            System.out.print("Escolha: ");
            int ocupacao = sc.nextInt();

            System.out.print("Salário: ");
            double salario = sc.nextDouble();
            sc.nextLine();

            cadastroService.cadastrarCliente(clientes, id, nome, idade, ocupacao, salario);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    public static void menuOperacao(Scanner sc, BancoService bancoService) {
        System.out.println("\n--- OPERAÇÕES ---");
        System.out.println("1 - Depósito");
        System.out.println("2 - Saque");
        System.out.println("3 - Transferência");
        System.out.print("Escolha: ");
        int op = sc.nextInt();
        sc.nextLine();

        try {
            switch (op) {
                case 1:
                    System.out.print("ID do cliente: ");
                    String idDep = sc.nextLine();
                    System.out.print("Valor do depósito: ");
                    double valDep = sc.nextDouble();
                    bancoService.depositar(idDep, valDep);
                    System.out.println("Depósito realizado!");
                    break;
                case 2:
                    System.out.print("ID do cliente: ");
                    String idSaq = sc.nextLine();
                    System.out.print("Valor do saque: ");
                    double valSaq = sc.nextDouble();
                    bancoService.sacar(idSaq, valSaq);
                    System.out.println("Saque realizado!");
                    break;
                case 3:
                    System.out.print("ID da conta origem: ");
                    String idOrig = sc.nextLine();
                    System.out.print("ID da conta destino: ");
                    String idDest = sc.nextLine();
                    System.out.print("Valor da transferência: ");
                    double valTransf = sc.nextDouble();
                    bancoService.transferir(idOrig, idDest, valTransf);
                    System.out.println("Transferência realizada!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (ClienteNaoEncontradoException | SaldoInsuficienteException | ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void menuExtrato(Scanner sc, List<Cliente> clientes) {
        System.out.println("\n--- EXTRATO ---");
        System.out.print("ID do cliente: ");
        String id = sc.nextLine();
        sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getId() == id) {
                System.out.println("Cliente: " + c.getNome());
                System.out.println("Saldo: R$ " + String.format("%.2f", c.getSaldo()));
                System.out.println("Limite de crédito: R$ " + String.format("%.2f", c.getLimiteCredito()));
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }
}
