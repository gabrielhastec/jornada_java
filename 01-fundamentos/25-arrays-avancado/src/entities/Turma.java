package entities;

import java.util.Arrays;

public class Turma {

    private final Aluno[] alunos; // array de objetos

    public Turma(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public double[][] montarMatrizNotas() {
        double[][] matriz = new double[alunos.length][];
        for (int i = 0; i < alunos.length; i++) {
            matriz[i] = Arrays.copyOf(alunos[i].getNotas(), alunos[i].getNotas().length);
        }
        return matriz;
    }

    public double mediaGeral() {
        double soma = 0;
        int total = 0;
        for (Aluno aluno : alunos) {
            for (double nota : aluno.getNotas()) {
                soma += nota;
                total++;
            }
        }
        return soma / total;
    }

    public double[] mediasPorProva() {
        int provas = alunos[0].getNotas().length;
        double[] medias = new double[provas];

        for (int j = 0; j < provas; j++) {
            double soma = 0;
            for (Aluno aluno : alunos) {
                soma += aluno.getNotas()[j];
            }
            medias[j] = soma / alunos.length;
        }
        return medias;
    }

    public Aluno melhorAlunoPorMedia() {
        Aluno melhor = alunos[0];
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() > melhor.calcularMedia()) {
                melhor = aluno;
            }
        }
        return melhor;
    }

    public double[] notasOrdenadasDaTurma() {
        int provas = alunos[0].getNotas().length;
        double[] todas = new double[alunos.length * provas];

        int k = 0;
        for (Aluno aluno : alunos) {
            for (double nota : aluno.getNotas()) {
                todas[k++] = nota;
            }
        }

        Arrays.sort(todas); // ordena em ordem crescente
        return todas;
    }
}
