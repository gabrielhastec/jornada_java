package entities;

public class Saque {
    
    private final int valorSolicitado;
    private int valorRestante;
    private final int[] quantidadeNotas;

    public Saque(int valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
        this.valorRestante = valorRestante;
        this.quantidadeNotas = new int[Nota.getNotasDisponiveis().length];
    }

    public int getValorSolicitado() {
        return valorSolicitado;
    }

    public int getValorRestante() {
        return valorRestante;
    }

    public int[] getQuantidadeNotas() {
        return quantidadeNotas;
    }

    public void subtrairValor(int valor) {
        this.valorRestante -= valor;
    }

    public void incrementarNota(int indice) {
        this.quantidadeNotas[indice]++;
    }

    
}
