package entities;

public class produto {
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor (será visto na próxima aula, mas já usaremos)
    public produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        setPreco(preco);       // reaproveita a validação do setter
        setQuantidade(quantidade);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido. Atribuído 0.0");
            this.preco = 0.0;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade inválida. Atribuído 0");
            this.quantidade = 0;
        }
    }

    // Método para calcular valor total em estoque
    public double valorEstoque() {
        return preco * quantidade;
    }
}
