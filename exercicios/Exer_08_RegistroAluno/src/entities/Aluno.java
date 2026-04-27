package entities;

public class Aluno extends MembroEscolar {

    private double[] notas = new double[4];

    public Aluno(int matricula, String nome) {
        super(matricula, nome);
    }

    public void setNota(int posicao, double nota) {
        if (posicao >= 0 && posicao < 4) {
            notas[posicao] = nota;
        }
    }

    public double[] getNotas() {
        return notas.clone();
    }

}
