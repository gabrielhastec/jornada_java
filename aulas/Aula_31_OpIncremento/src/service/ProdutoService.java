package service;

import domain.Produto;
import repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Produto produto) {
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        repository.salvar(produto);
    }

    public List<Produto> listar() {
        return repository.listar();
    }

    public void atualizarPreco(int id, double novoPreco) {
        Produto p = repository.buscarPorId(id);
        if (p != null) {
            p.setPreco(novoPreco);
        }
    }

    public void remover(int id) {
        repository.remover(id);
    }

    public void adicionarEstoque(int id, int quantidade) {
        Produto p = repository.buscarPorId(id);
        if (p == null) throw new RuntimeException("Produto não encontrado");

        System.out.println("Adicionando " + quantidade + " unidades a " + p.getNome());
        for (int i = 0; i < quantidade; i++) {
            int antes = p.incrementarComRetorno(); // pós-incremento: retorna valor antigo
            System.out.println("  Unidade " + (i+1) + " - estoque anterior: " + antes);
        }
        repository.salvar(p);
        System.out.println("Estoque final: " + p.getEstoque());
    }

    public void removerEstoque(int id, int quantidade) {
        Produto p = repository.buscarPorId(id);
        if (p == null) throw new RuntimeException("Produto não encontrado");
        if (p.getEstoque() < quantidade) throw new RuntimeException("Estoque insuficiente");

        System.out.println("Removendo " + quantidade + " unidades de " + p.getNome());
        for (int i = 0; i < quantidade; i++) {
            int novo = p.decrementarComRetorno(); // pré-decremento: já retorna valor atualizado
            System.out.println("  Removida 1 unidade. Novo estoque: " + novo);
        }
        repository.salvar(p);
        System.out.println("Estoque final: " + p.getEstoque());
    }

    public List<Produto> listarEstoqueBaixo(int limite) {
        List<Produto> todos = repository.listar();
        List<Produto> resultado = new ArrayList<>();
        System.out.println("Produtos com estoque <= " + limite + ":");
        for (int i = 0; i < todos.size(); i++) {
            Produto p = todos.get(i);
            if (p.getEstoque() <= limite) {
                resultado.add(p);
                System.out.println("  " + p.getNome() + ": " + p.getEstoque());
            }
        }
        return resultado;
    }

    public void liquidarProduto(int id) {
        Produto p = repository.buscarPorId(id);
        if (p == null) throw new RuntimeException("Produto não encontrado");

        System.out.println("Liquidando " + p.getNome() + "...");
        int qtd = p.getEstoque();
        System.out.print("Contagem regressiva: ");
        while (qtd > 0) {
            System.out.print(qtd-- + " ");  // imprime valor atual e depois decrementa
        }
        System.out.println();
        // Após o loop, qtd == 0, atualizamos o produto
        p.decrementarComRetorno(); // apenas para manter o objeto consistente (estoque já foi impresso)
        // Na verdade, precisamos zerar o estoque real. Vamos fazer diretamente:
        while (p.getEstoque() > 0) {
            p.decrementar();  // decrementa até zero (poderíamos usar setter, mas assim praticamos)
        }
        repository.salvar(p);
        System.out.println("Produto liquidado. Estoque: " + p.getEstoque());
    }

    public void reabastecerTodos(int quantidade) {
        List<Produto> todos = repository.listar();
        System.out.println("Reabastecendo todos os produtos com +" + quantidade);
        for (Produto p : todos) {
            for (int i = 0; i < quantidade; i++) {
                p.incrementar();  // pós-incremento simples
            }
            System.out.println("  " + p.getNome() + ": " + p.getEstoque());
            repository.salvar(p);
        }
    }

}
