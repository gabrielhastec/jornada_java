package ui;

import domain.Produto;
import service.ProdutoService;

public class ProdutoConsoleUI {

    private ProdutoService service;

    public ProdutoConsoleUI(ProdutoService service) {
        this.service = service;
    }

    public void iniciar() {

        Produto p1 = new Produto(
                1,
                "Picanha",
                79.90,
                10,
                true,
                'A',
                7891234567890L,
                1.2f
        );

        Produto p2 = new Produto(
                2,
                "Refrigerante",
                6.50,
                50,
                true,
                'B',
                7899876543210L,
                2.0f
        );

        service.cadastrar(p1);
        service.cadastrar(p2);

        System.out.println("=== LISTAGEM ===");
        service.listar().forEach(Produto::exibir);

        System.out.println("\n=== ATUALIZANDO ===");
        service.atualizarPreco(1, 89.90);
        service.listar().forEach(Produto::exibir);

        System.out.println("\n=== REMOVENDO ===");
        service.remover(2);
        service.listar().forEach(Produto::exibir);
    }
}
