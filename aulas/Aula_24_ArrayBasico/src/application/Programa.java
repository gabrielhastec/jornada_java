package application;

import services.EstoqueService;

public class Programa {

    public static void main(String[] args) {

        EstoqueService estoque = new EstoqueService(10);

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Calcular valor total");
            System.out.println("4 - Buscar produto");
            System.out.println("0 - Sair");

            opcao = util.ConsoleUtils.lerInt("Escolha: ");

            switch (opcao) {
                case 1:
                    estoque.adicionar();
                    break;
                case 2:
                    estoque.listar();
                    break;
                case 3:
                    estoque.calcularValorTotalEstoque();
                    break;
                case 4:
                    estoque.buscarPorNome();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
