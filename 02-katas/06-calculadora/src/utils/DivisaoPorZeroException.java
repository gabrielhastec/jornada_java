package utils;

public class DivisaoPorZeroException extends RuntimeException {
 
    public DivisaoPorZeroException() {
        super("Erro: divisão por zero não é permitida.");
    }
 
    public DivisaoPorZeroException(String mensagem) {
        super(mensagem);
    }
    
}
