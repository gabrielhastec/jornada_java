package entities;

public class professor {

    private int matricula;
    private String nome, materia;

    public professor(int matricula, String nome, String materia) {
        this.matricula = matricula;
        this.nome = nome;
        this.materia = materia;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMateria () {
        return materia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
