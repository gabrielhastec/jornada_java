package repository;

import domain.Produto;

import java.util.*;

public class ProdutoRepository {

    // Wrapper obrigatório
    private Map<Integer, Produto> banco = new HashMap<>();

    public void salvar(Produto produto) {
        banco.put(produto.getId(), produto); // autoboxing
    }

    public Produto buscarPorId(int id) {
        return banco.get(id); // unboxing implícito na chave
    }

    public List<Produto> listar() {
        return new ArrayList<>(banco.values());
    }

    public void remover(int id) {
        banco.remove(id);
    }
}