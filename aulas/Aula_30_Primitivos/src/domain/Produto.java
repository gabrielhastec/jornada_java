package domain;

public class Produto {

    private int id;                // primitivo
    private String nome;
    private double preco;          // precisão financeira (discutir depois BigDecimal)
    private int estoque;
    private boolean ativo;
    private char categoria;
    private long codigoBarras;     // precisa do L
    private float peso;            // precisa do f

    public Produto(int id, String nome, double preco, int estoque,
                   boolean ativo, char categoria, long codigoBarras, float peso) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.ativo = ativo;
        this.categoria = categoria;
        this.codigoBarras = codigoBarras;
        this.peso = peso;
    }

    public int getId() { return id; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public void exibir() {
        System.out.println(id + " - " + nome + " | R$ " + preco + " | Estoque: " + estoque);
    }
}
