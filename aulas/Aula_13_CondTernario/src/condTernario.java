public class condTernario {
    
    public static void main(String[] args) {
        
        //Sintaxe do condicional ternário
        //variavel = (condição) ? valor_se_verdadeiro : valor_se falso;

        int x, y;
        x = 10;
        y = (x > 5) ? 20 : 30; //Se x for maior que 5, y recebe 20, senão y recebe 30

        System.out.println("O valor de y é: " + y);

        //Caso de uso: Verifica quantos porcentos de desconto aplicar
        double precoProduto, deconto, precoComDesconto;

        precoProduto = 150.0;
        deconto = (precoProduto > 100.0) ? 0.1 : 0.05; //10% se o preço for maior que 100, senão 5%
        precoComDesconto = precoProduto - (precoProduto * deconto);

        System.out.println("O preço com desconto é: " + precoComDesconto);
            

    }
}
