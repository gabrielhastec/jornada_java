package entities;

public class aluno {

    private int matricula;
    private String nome;
    private double[] notas = new double[4];

    public aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(int posicao, double nota) {
        if (posicao >= 0 && posicao < 4) {
            notas[posicao] = nota;
        }
    }

    public double calcularMedia() {
        double soma = 0;
        for (double n : notas) {
            soma += n;
        }
        return soma / 4;
    }

    public boolean isAprovado() {
        return calcularMedia() >= 6;
    }

    public String toString() {
        return "Matrícula: " + matricula
                + ", Nome: " + nome
                + ", Média: " + String.format("%.2f", calcularMedia())
                + ", Status: " + (isAprovado() ? "Aprovado" : "Recuperação");
    }
}
