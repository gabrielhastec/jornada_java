package entities;

public class Cliente {

    private String nome;
    private int idade;
    private Ocupacao ocupacao;
    private String id; // CPF simplificado
    private double salario;
    private double saldo;
    private double limiteCredito;

    // Construtor
    public Cliente(String id, String nome, int idade, Ocupacao ocupacao, double salario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.ocupacao = ocupacao;
        this.salario = salario;
        this.saldo = 0.0;

        // limite será calculado posteriormente (pode ser setado via setter)
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Ocupacao getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(Ocupacao ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    
}
