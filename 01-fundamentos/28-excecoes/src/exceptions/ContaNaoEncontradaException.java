package exceptions;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException(String id) {
        super("Conta " + id + " nao encontrada.");
    }
}
