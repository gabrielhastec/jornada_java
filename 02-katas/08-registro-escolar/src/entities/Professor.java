package entities;

public class Professor extends MembroEscolar {

    private String materia;

    public Professor(int matricula, String nome, String materia) {
        super(matricula, nome);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

}
