
import java.util.Locale;

public class saidaDados {

    public static void main(String[] args) {

        // Define o padrão de idioma para números
        // Usado principalmente para garantir o ponto como separador decimal
        Locale.setDefault(Locale.US);

        // print -> imprime o texto sem pular linha
        System.out.print("Olá");
        System.out.print(" Mundo");

        // println -> imprime o texto e pula para a próxima linha
        System.out.println();
        System.out.println("Pulou a linha!");

        // Concatenando vários elementos com +
        int idade = 25;
        double salario = 2500.50;
        String nome = "Maria";

        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Salário: " + salario);

        // printf -> imprime texto formatado
        // %d -> números inteiros
        // %f -> números decimais
        // %s -> textos (String)
        // %n -> quebra de linha
        System.out.printf("Nome: %s%n", nome);
        System.out.printf("Idade: %d%n", idade);
        System.out.printf("Salário: %.2f%n", salario);

        // Vários valores no mesmo printf
        System.out.printf(
                "Funcionária: %s | Idade: %d | Salário: %.2f%n",
                nome, idade, salario
        );
    }
}
