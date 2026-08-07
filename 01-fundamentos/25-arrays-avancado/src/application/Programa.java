package application;

import entities.Aluno;
import entities.Turma;
import java.util.Arrays;

public class Programa {

    public static void main(String[] args) {

        // Array de objetos Aluno, cada um com seu array de notas
        Aluno[] alunos = {
                new Aluno("Ana", new double[]{7.5, 8.0, 6.5}),
                new Aluno("Bruno", new double[]{9.0, 8.5, 7.8}),
                new Aluno("Carla", new double[]{6.0, 7.0, 8.0}),
                new Aluno("Diego", new double[]{8.2, 7.9, 9.3})
        };

        Turma turma = new Turma(alunos);

        // MATRIZ (array 2D): linhas = alunos, colunas = provas
        double[][] matriz = turma.montarMatrizNotas();

        System.out.println("Matriz de notas");
        for (int i = 0; i < matriz.length; i++) { // loop externo = linhas
            System.out.printf("%-6s", alunos[i].getNome() + ":");

            for (int j = 0; j < matriz[i].length; j++) { // loop interno = colunas
                System.out.printf(" %4.1f", matriz[i][j]);
            }
            System.out.println();
        }

        // Utilizando Arrays utilitarios
        double[] mediasPorProva = turma.mediasPorProva();

        System.out.println("\nMedias por prova: " + Arrays.toString(mediasPorProva));
        System.out.printf("Media geral da turma: %.2f%n", turma.mediaGeral());

        Aluno melhorAluno = turma.melhorAlunoPorMedia();

        System.out.printf("Melhor media: %s (%.2f)%n", melhorAluno.getNome(), melhorAluno.calcularMedia());

        // Ordenacao e busca
        double[] notasOrdenadas = turma.notasOrdenadasDaTurma();

        System.out.println("\nNotas ordenadas (todas as provas): " + Arrays.toString(notasOrdenadas));

        int indiceBusca = Arrays.binarySearch(notasOrdenadas, 8.0); // exige array ordenado

        if (indiceBusca >= 0) {
            System.out.printf("Nota 8.0 encontrada na posicao ordenada %d%n", indiceBusca);

        } else {
            System.out.println("Nota 8.0 nao encontrada");

        }

        // Preencher array (ex.: nota minima de recuperacao)
        double[] notasRecuperacao = new double[alunos.length];
        Arrays.fill(notasRecuperacao, 6.0);
        System.out.println("Notas de recuperacao: " + Arrays.toString(notasRecuperacao));
        
    }
}
