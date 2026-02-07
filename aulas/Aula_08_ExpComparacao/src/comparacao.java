
public class comparacao {
    
    public static void main(String[] args) {
        
        int a = 10;
        int b = 5;
        
        // OPERADOR (MAIOR QUE) >
        System.out.println(a > b);   // true → 10 é maior que 5

        // OPERADOR (MENOR QUE) <
        System.out.println(a < b);   // false → 10 não é menor que

        // OPERADOR (MAIOR OU IGUAL) >=
        System.out.println(a >= b);  // true → 10 é maior que 5

        // OPERADOR (MENOR OU IGUAL) <=
        System.out.println(a <= b);  // false → 10 não é menor nem igual

        // OPERADOR (IGUALDADE) ==
        System.out.println(a == b);  // false → 10 é diferente de 5

        // OPERADOR (DIFERENTE) !=
        System.out.println(a != b);  // true → 10 é diferente de 5


        // EXEMPLO DE USO 
        // 1 - Verificar o salário de um funcionário

        double salario = 3500.00;

        System.out.println(salario > 3000); // true
        System.out.println(salario < 3000); // false

        // 2 - Verificar a idade de uma pessoa

        int idade = 18;

        System.out.println(idade >= 18); // true → 18 é maior ou igual a 18
        System.out.println(idade < 18);  // false → 18 não é menor que 18
        
    }
}
