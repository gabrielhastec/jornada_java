import java.util.Scanner;

public class repeticao {
    
    public static void main(String[] args) {
        
        // Estrutura de repetição for (Para)
        // Utilizada quando sabemos o número exato de iterações que queremos realizar.
        // Sintaxe: for (inicialização; condição; atualização) { // bloco de código a ser repetido }


        for (int i = 0; i < 10; i++) {
            System.out.println("Valor de i: " + i);
        }

        // Caso de uso: Processar pedidos de um e-commerce.
        int totalPedidos = 5;

        for (int pedido = 1; pedido <= totalPedidos; pedido++) {
            System.out.println("Processando pedido número: " + pedido);
        }

        // Estrutura de repetição while (Enquanto)
        // Utilizada quando não sabemos o número exato de iterações, mas temos uma condição para continuar.
        // Sintaxe: while (condição) { // bloco de código a ser repetido }
        int contador = 0;

        while (contador < 5) {
            System.out.println("Contador: " + contador);
            contador++;
        }

        // Caso de uso: Verificar o estoque de um produto.
        int estoque = 3;

        while (estoque > 0) {
            System.out.println("Produto em estoque. Quantidade restante: " + estoque);
            estoque--;
        }

        // Estrutura de repetição do-while (Faça enquanto)
        // Similar ao while, mas garante que o bloco de código seja executado pelo menos uma vez, pois a condição é verificada após a execução.
        // Sintaxe: do { // bloco de código a ser repetido } while (condição);
        int numero = 0;

        do {
            System.out.println("Número: " + numero);
            numero++;
        } while (numero < 5);

        // Caso de uso: Verificar a senha do usuário.
        
        Scanner scanner = new Scanner(System.in);

        String senhaCorreta = "12345";    
        String senhaDigitada;

        do {
            System.out.print("Digite a senha: ");
            senhaDigitada = scanner.nextLine();

            if (!senhaDigitada.equals(senhaCorreta)) {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        } while (!senhaDigitada.equals(senhaCorreta));

        System.out.println("Senha correta! Acesso concedido.");

        scanner.close();


    }
}
