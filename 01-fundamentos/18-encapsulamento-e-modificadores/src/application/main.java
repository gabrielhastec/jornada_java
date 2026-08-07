
package application;
import entities.Produto;

public class Main {
    public static void Main(String[] args) {
        Produto p = new Produto("Notebook", 2500.0, 10);
        System.out.println("Produto: " + p.getNome());
        System.out.println("Preço: R$" + p.getPreco());
        System.out.println("Quantidade: " + p.getQuantidade());
        System.out.println("Valor em estoque: R$" + p.valorEstoque());

        // Tentando alterar para valores inválidos
        p.setPreco(-500);   // será rejeitado
        p.setQuantidade(-5); // será rejeitado
    }
}
