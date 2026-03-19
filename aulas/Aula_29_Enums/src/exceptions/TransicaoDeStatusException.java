package exceptions;

public class TransicaoDeStatusException extends RuntimeException {

    public TransicaoDeStatusException(String mensagem) {
        super(mensagem);
    }
}
