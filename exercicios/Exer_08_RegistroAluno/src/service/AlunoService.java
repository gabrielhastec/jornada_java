package service;

import java.util.List;

import entities.Aluno;
import exceptions.AlunoNaoEncontradoException;
import exceptions.NotaInvalidaException;

public class AlunoService {

    private final List<Aluno> alunos;

    public AlunoService(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Aluno buscarPorMatricula(int matricula) throws AlunoNaoEncontradoException {

        return alunos.stream()
                .filter(aluno -> aluno.getMatricula() == matricula)
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(
                        "Aluno com matricula " + matricula + " nao encontrado."));
    }

    public void aplicarNota(int matricula, double[] novasNotas)
            throws AlunoNaoEncontradoException, NotaInvalidaException {

        if (novasNotas.length != 4) {
            throw new IllegalArgumentException("Deve ser informada uma nota para cada atividade.");
        }

        for (double nota : novasNotas) {
            if (nota < 0 || nota > 10) {
                throw new NotaInvalidaException("Nota deve ser entre 0 e 10.");
            }
        }

        Aluno aluno = buscarPorMatricula(matricula);
        for (int i = 0; i < 4; i++) {
            aluno.setNota(i, novasNotas[i]);
        }
    }

    public double calcularMedia(Aluno aluno) {
        double soma = 0;
        for (double nota : aluno.getNotas()) {
            soma += nota;
        }
        return soma / 4;
    }

    public boolean isAprovado(Aluno aluno) {
        return calcularMedia(aluno) >= 6.0;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(int matricula, String nome) {
        alunos.add(new Aluno(matricula, nome));
    }
}
