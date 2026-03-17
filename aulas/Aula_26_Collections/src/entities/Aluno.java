package entities;

public class Aluno {

    private final String nome;
    private final String curso;
    private final double nota;

    public Aluno(String nome, String curso, double nota) {
        this.nome = nome;
        this.curso = curso;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nome + " (" + curso + ") - nota " + nota;
    }
}
