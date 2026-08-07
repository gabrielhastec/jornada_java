package entities;

public class Aluno implements Identificavel {

    private final String id;
    private final String nome;
    private final String curso;
    private final double nota;

    public Aluno(String id, String nome, String curso, double nota) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.nota = nota;
    }

    @Override
    public String getId() {
        return id;
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
        return id + " - " + nome + " (" + curso + ") nota " + nota;
    }
}
