package entities;

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    // Construtor padrão (sem parâmetros)
    public Funcionario() {
        this.nome = "Sem nome";
        this.cargo = "Não definido";
        this.salario = 0.0;
    }

    // Construtor com nome e cargo
    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = 0.0; // salário ainda não definido
    }

    // Construtor completo
    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    // Sobrecarga do método aumentarSalario
    public void aumentarSalario(double percentual) {
        this.salario += this.salario * percentual / 100;
    }

    public void aumentarSalario(double valorFixo, boolean fixo) { // o booleano é só para diferenciar a assinatura
        this.salario += valorFixo;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public double getSalario() { return salario; }

    public void exibirInfo() {
        System.out.printf("Funcionário: %s | Cargo: %s | Salário: R$%.2f%n", nome, cargo, salario);
    }
}
