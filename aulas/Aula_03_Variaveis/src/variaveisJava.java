
public class variaveisJava {

    public static void main (String[] args){

        
        // Tipos Primitivos em Java:
        // Variável do tipo inteiro (números sem casa decimal)
        int idade = 20;

        // Variável do tipo double (números com casa decimal)
        double altura = 1.75;

        // Tipos Não Primitivos em Java:
        // Pode armazenar uma sequência de caracteres (texto) e possui diversos métodos para manipulação de strings

        // Variável do tipo String (textos)
        String nome = "João Silva";

        // Exemplos de métodos para manipulação de strings
        nome.toUpperCase(); // Método para converter o nome para maiúsculas
        System.out.println("Nome em maiúsculas: " + nome.toUpperCase());
        nome.toLowerCase(); // Método para converter o nome para minúsculas
        System.out.println("Nome em minúsculas: " + nome.toLowerCase());
        nome.length(); // Método para obter o comprimento do nome
        System.out.println("Comprimento do nome: " + nome.length());
        nome.contains("Silva"); // Método para verificar se o nome contém a palavra "Silva"
        System.out.println("O nome contém 'Silva'? " + nome.contains("Silva"));
        nome.replace("João", "Maria"); // Método para substituir "João" por "Maria"
        System.out.println("Nome após substituição: " + nome.replace("João", "Maria"));
        nome.charAt(3); // Método para obter o caractere na posição 3 (índice começa em 0)
        System.out.println("Caractere na posição 3: " + nome.charAt(3));
        
        // Imprimindo os valores das variáveis
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);

        // Podemos mudar o valor da variável
        idade = 21;
        System.out.println("Nova idade: " + idade);

    }
}
