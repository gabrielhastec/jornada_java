package ui;

import domain.Produto;
import service.ProdutoService;

public class ProdutoConsoleUI {

    private ProdutoService service;

    public ProdutoConsoleUI(ProdutoService service) {
        this.service = service;
    }

    public void iniciar() {

        // Cadastro inicial (exercício 30)
        Produto p1 = new Produto(1, "Picanha", 79.90, 10, true, 'A', 7891234567890L, 1.2f);
        Produto p2 = new Produto(2, "Refrigerante", 6.50, 50, true, 'B', 7899876543210L, 2.0f);
        service.cadastrar(p1);
        service.cadastrar(p2);

        System.out.println("=== SISTEMA DE PRODUTOS - ESTOQUE INTELIGENTE ===\n");

        // 1. Adicionar estoque (pós-incremento)
        System.out.println("--- ADICIONAR ESTOQUE ---");
        service.adicionarEstoque(1, 3);
        System.out.println();

        // 2. Remover estoque (pré-decremento)
        System.out.println("--- REMOVER ESTOQUE ---");
        service.removerEstoque(2, 2);
        System.out.println();

        // 3. Listar estoque baixo
        System.out.println("--- ESTOQUE BAIXO ---");
        service.listarEstoqueBaixo(15);
        System.out.println();

        // 4. Liquidar produto (contagem regressiva)
        System.out.println("--- LIQUIDAR PRODUTO ---");
        service.liquidarProduto(1);
        System.out.println();

        // 5. Reabastecer todos
        System.out.println("--- REABASTECER TODOS ---");
        service.reabastecerTodos(1);
        System.out.println();

        // Relatório final
        System.out.println("=== RELATÓRIO FINAL ===");
        service.listar().forEach(p -> System.out.println(p.getNome() + ": " + p.getEstoque()));

    }
}
