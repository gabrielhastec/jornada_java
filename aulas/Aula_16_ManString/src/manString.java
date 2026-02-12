public class manString {
    public static void main(String[] args) {
        
        String original = "Java é uma linguagem de programação.";

        // Imprime a string original
        System.out.println("String original: " + original);

        // Converte a string para maiúsculas        string.toUpperCase();
        String maiuscula = original.toUpperCase();
        System.out.println("String em maiúsculas: " + maiuscula);

        // Converte a string para minúsculas        String minuscula = original.toLowerCase();
        String minuscula = original.toLowerCase();
        System.out.println("String em minúsculas: " + minuscula);

        // Substitui "programação" por "desenvolvimento"
        String substituida = original.replace("programação", "desenvolvimento");
        System.out.println("String substituída: " + substituida);

        // Verifica se a string contém a palavra "Java"
        boolean contemJava = original.contains("Java");
        System.out.println("A string contém 'Java'? " + contemJava);

        // Verifica se a string começa com "Java"
        boolean comecaComJava = original.startsWith("Java");
        System.out.println("A string começa com 'Java'? " + comecaComJava);

        // Verifica se a string termina com "programação."
        boolean terminaComProgramacao = original.endsWith("programação.");
        System.out.println("A string termina com 'programação.'? " + terminaComProgramacao);

        // Obtém o comprimento da string
        int comprimento = original.length();
        System.out.println("Comprimento da string: " + comprimento);

        // Índice da palavra "linguagem"        int indiceLinguagem = original.indexOf("linguagem");
        int indiceLinguagem = original.indexOf("linguagem");
        System.out.println("Índice da palavra 'linguagem': " + indiceLinguagem);

        // Divide a string em palavras        String[] palavras = original.split(" ");
        String[] palavras = original.split(" ");
        System.out.println("Palavras na string:");
        System.out.println(palavras[0]);
        System.out.println(palavras[1]);
        System.out.println(palavras[2]);

        // Obtém o caractere na posição 5        char caractere = original.charAt(5);
        System.out.println("Caractere na posição 5: " + original.charAt(5));

        // Verifica se a string é vazia        boolean vazia = original.isEmpty();
        System.out.println("A string é vazia? " + original.isEmpty());

        // Substring da posição 5 até a posição 15        String substring = original.substring(5, 15);
        System.out.println("Substring (5 a 15): " + original.substring(5, 15));

        // Remove espaços em branco no início e no final da string        String trimada = original.trim();
        String trimada = original.trim();
        System.out.println("String trimada: " + trimada);




    }
}
