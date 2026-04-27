package entities;

public abstract class MembroEscolar {

    protected int matricula;
    protected String nome;

    public MembroEscolar(int matricula, String nome) {
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
    
}
