package service;

import domain.Produto;
import repository.ProdutoRepository;

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
}
