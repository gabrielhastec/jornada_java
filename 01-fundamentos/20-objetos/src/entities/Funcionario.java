package entities;

public class Funcionario {
    private String nome;
    private Departamento departamento; // composição

    public Funcionario(String nome, Departamento departamento) {
        this.nome = nome;
        this.departamento = departamento;
    }

    public void exibirInfo() {
        System.out.println("Funcionário: " + nome + ", Departamento: " + departamento.getNome());
    }
}
