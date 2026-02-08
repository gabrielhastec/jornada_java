
public class expLogica {
    
    public static void main(String[] args) {
        
        int a, b, c;
        
        a = 10;
        b = 20;
        c = 30;

        // Operadores Lógicos
        // && -> AND -> E

        System.out.println((a > b) && (b < c)); // false
        System.out.println((a < b) && (b < c)); // true

        // || -> OR -> OU
        System.out.println((a > b) || (b < c)); // true
        System.out.println((a > b) || (b > c)); // false

        // ! -> NOT -> NÃO
        System.out.println(!(a > b)); // true
        System.out.println(!(a < b)); // false

        // Casos de Uso
        // 1. Verifica se um aluno é maior de idade e tem nota suficiente para passar
        int idadeAluno = 18;
        double notaAluno = 7.5;
        boolean passou = (idadeAluno >= 18) && (notaAluno >= 6.0);
        
        System.out.println("O aluno passou? " + passou);

        // 2. Verifica se o candidato é acima dos 30 anos ou 5 anos de experiência para uma vaga de emprego
        int idadeCandidato = 28;
        int anosExperiencia = 6;
        boolean elegivel = (idadeCandidato > 30) || (anosExperiencia >= 5);

        System.out.println("O candidato é elegível? " + elegivel);

        // 3. Verifica se o condutor tem carteira de motorista e não está alcoolizado para dirigir
        boolean temCarteira = true;
        boolean alcoolizado = false;
        boolean podeDirigir = temCarteira && !alcoolizado;
        
        System.out.println("O condutor pode dirigir? " + podeDirigir);
        

    }
}
