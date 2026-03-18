package repositories;

import entities.Conta;
import entities.Identificavel;
import exceptions.ContaNaoEncontradaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Repositorio generico simples reaproveitando Collections
public class ContaRepositorio<T extends Identificavel> {

    private final Map<String, T> dados = new HashMap<>();

    public void salvar(T item) {
        dados.put(item.getId(), item);
    }

    public T buscarObrigatorio(String id) {
        T item = dados.get(id);
        if (item == null) {
            throw new ContaNaoEncontradaException(id);
        }
        return item;
    }

    public List<T> listarTodos() {
        return new ArrayList<>(dados.values());
    }
}
