package services;

import entities.Produto;
import interfaces.Gerenciavel;

public class EstoqueService implements Gerenciavel {

    private Produto[] produtos;
    private int contador;

    public EstoqueService(int capacidade) {
        produtos = new Produto[capacidade];
        contador = 0;
    }

    @Override
    public void adicionar() {
        if (contador >= produtos.length) {
            System.out.println("Estoque cheio!");
            return;
        }

        String nome = util.ConsoleUtils.lerString("Nome: ");
        double preco = util.ConsoleUtils.lerDouble("Preço: ");
        int quantidade = util.ConsoleUtils.lerInt("Quantidade: ");

        produtos[contador] = new Produto(nome, preco, quantidade);
        contador++;

        System.out.println("Produto adicionado com sucesso!");
    }

    @Override
    public void listar() {
        if (contador == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            System.out.println(produtos[i]);
        }
    }

    public void calcularValorTotalEstoque() {
        double total = 0;

        for (int i = 0; i < contador; i++) {
            total += produtos[i].calcularValorTotal();
        }

        System.out.println("Valor total em estoque: R$ " + total);
    }

    public void buscarPorNome() {
        String nomeBusca = util.ConsoleUtils.lerString("Digite o nome do produto: ");

        for (int i = 0; i < contador; i++) {
            if (produtos[i].getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println("Produto encontrado:");
                System.out.println(produtos[i]);
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}
