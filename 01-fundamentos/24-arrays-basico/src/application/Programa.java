package application;

import entities.Aluno;

public class Programa {

    public static void main(String[] args) {

        // Array de objetos (3 alunos), cada um com array de notas
        Aluno[] turma = {
                new Aluno("Ana", new double[]{7.5, 8.0, 6.5}),
                new Aluno("Bruno", new double[]{9.0, 8.5, 7.8}),
                new Aluno("Carla", new double[]{6.0, 7.0, 8.0})
        };

        // Percorrer alunos (for tradicional para mostrar indices)
        System.out.println("Percorrendo alunos (for + indices)");
        for (int i = 0; i < turma.length; i++) {
            Aluno aluno = turma[i];
            System.out.printf("Indice %d -> %s%n", i, aluno.getNome());
        }

        // Percorrer notas de cada aluno (for-each aninhado)
        System.out.println("\nNotas por aluno (for-each)");
        for (Aluno aluno : turma) {
            System.out.printf("Aluno: %s%n", aluno.getNome());
            for (double nota : aluno.getNotas()) {
                System.out.printf("  Nota: %.1f%n", nota);
            }
        }

        // Calculos encapsulados em metodos da classe Aluno
        System.out.println("\nResumo individual");
        for (Aluno aluno : turma) {
            System.out.printf("%s -> media: %.2f | maior: %.1f | menor: %.1f%n",
                    aluno.getNome(),
                    aluno.calcularMedia(),
                    aluno.maiorNota(),
                    aluno.menorNota());
        }

        // Estatistica simples da turma usando o array basico
        double somaTurma = 0;
        int totalNotas = 0;
        for (Aluno aluno : turma) {
            for (double nota : aluno.getNotas()) {
                somaTurma += nota;
                totalNotas++;
            }
        }
        double mediaTurma = somaTurma / totalNotas;

        System.out.println("\n=== RESULTADO GERAL ===");
        System.out.printf("Media da turma: %.2f%n", mediaTurma);
    }
}
