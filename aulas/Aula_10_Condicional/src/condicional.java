public class condicional {
    
    public static void main(String[] args) {
        
        // Exemplo de estrutura condicional simples
        String nome;
        int idade;
        boolean permissao; 

        nome = "João";
        idade = 20;
        permissao = false;

        if (idade >= 18){
            permissao = true;
        }

        System.out.printf("%s tem %d anos. Permissão para entrar: %b\n", nome, idade, permissao);


        // Exemplo de estrutura condicional composta
        double media, nota1, nota2;

        nome = "Maria";
        nota1 = 7.0;
        nota2 = 8.5;
        media = (nota1 + nota2) / 2;

        if (media >= 6.0){
            System.out.printf("%s foi aprovado com média %.2f\n", nome, media);
        } else {
            System.out.printf("%s foi reprovado com média %.2f\n", nome, media);
        }

        // Exemplo de estrutura condicional encadeada
        
        nome = "Carlos";
        idade = 17;

        if (idade < 16 && idade >= 0){
            System.out.println(nome + " não pode entrar na festa.");
        } else if (idade >= 16 && idade < 18){
            System.out.println(nome + " pode entrar na festa com permissão dos pais.");
        } else {
            System.out.println(nome + " pode entrar na festa sem permissão dos pais.");
        }


    }
}
