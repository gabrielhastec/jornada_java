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
    public float getPeso() { return peso; }

    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Estoque: " + estoque);
        System.out.println("Ativo: " + ativo);
        System.out.println("Categoria: " + categoria);
        System.out.println("Código de Barras: " + codigoBarras);
        System.out.println("Peso: " + peso + " kg");
    }

}
