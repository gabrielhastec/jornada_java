package utils;

public class Exceptions {

    public static class ClienteNaoEncontradoException extends Exception {
        public ClienteNaoEncontradoException(String message) {
            super(message);
        }
    }
    
    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String message) {
            super(message);
        }
    }

    public static class ValorInvalidoException extends Exception {
        public ValorInvalidoException(String message) {
            super(message);
        }
    }

}
