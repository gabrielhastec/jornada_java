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
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public void setPreco(double preco) { this.preco = preco; }

    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Estoque: " + estoque);
        System.out.println("Ativo: " + ativo);
        System.out.println("Categoria: " + categoria);
        System.out.println("Código de Barras: " + codigoBarras);
        System.out.println("Peso: " + peso);
    }

    public void incrementar() {
        estoque++;  // pós-incremento, mas sem usar o valor retornado
    }

    /**
     * Decrementa a quantidade em 1.
     */
    public void decrementar() {
        estoque--;
    }

    /**
     * Incrementa e retorna o valor ANTES do incremento (pós-incremento).
     * Útil quando precisamos do valor original em uma operação.
     */
    public int incrementarComRetorno() {
        return estoque++;   // retorna o valor atual e depois incrementa
    }

    /**
     * Decrementa e retorna o valor APÓS o decremento (pré-decremento).
     */
    public int decrementarComRetorno() {
        return --estoque;   // decrementa primeiro, depois retorna o novo valor
    }

    @Override
    public String toString() {
        return
                "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                ", ativo=" + ativo +
                ", categoria=" + categoria +
                ", codigoBarras=" + codigoBarras +
                ", peso=" + peso +
                '}';
    }

}
