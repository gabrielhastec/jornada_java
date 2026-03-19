package repositories;

import entities.Identificavel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorio<T extends Identificavel> {

    private final Map<String, T> dados = new HashMap<>();

    public void salvar(T item) {
        dados.put(item.getId(), item);
    }

    public T buscar(String id) {
        return dados.get(id);
    }

    public List<T> listarTodos() {
        return new ArrayList<>(dados.values());
    }
}
