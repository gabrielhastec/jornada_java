package utils;

import java.util.Collection;
import java.util.List;

public final class GenericsUtils {

    private GenericsUtils() {
    }

    // Metodo generico: devolve o ultimo elemento de qualquer lista
    public static <T> T ultimo(List<T> lista) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }
        return lista.get(lista.size() - 1);
    }

    // Wildcard: aceita qualquer colecao e apenas imprime (nao adiciona)
    public static void imprimirColecao(Collection<?> itens) {
        for (Object item : itens) {
            System.out.println(item);
        }
    }
}
