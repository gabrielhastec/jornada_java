package application;

import entities.Aluno;
import entities.Turma;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Programa {

    public static void main(String[] args) {

        // Base vinda de aulas anteriores: array inicial com os dados
        Aluno[] base = {
                new Aluno("Ana", "Java", 8.5),
                new Aluno("Bruno", "Python", 7.9),
                new Aluno("Carla", "Java", 9.1),
                new Aluno("Diego", "Java", 8.7),
                new Aluno("Elisa", "Python", 8.2),
                new Aluno("Bruno", "Python", 7.9) // duplicado para mostrar Set
        };

        // List: mantém ordem e permite duplicados
        Turma turma = new Turma();
        for (Aluno aluno : base) {
            turma.adicionarAluno(aluno);
        }

        System.out.println("LIST (ordem de insercao)");
        List<Aluno> alunos = turma.getAlunos();
        for (int i = 0; i < alunos.size(); i++) {
            System.out.printf("Indice %d -> %s%n", i, alunos.get(i));
        }

        // Set: valores unicos (quais cursos existem)
        System.out.println("\nSET (cursos unicos)");
        Set<String> cursos = turma.cursosDistintos();
        for (String curso : cursos) {
            System.out.println(curso);
        }

        // Map: chave/valor (curso -> quantidade)
        System.out.println("\nMAP (contagem por curso)");
        Map<String, Integer> contagem = turma.contagemPorCurso();
        for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // Map: curso -> melhor aluno
        System.out.println("\nMAP (melhor nota por curso)");
        Map<String, Aluno> melhores = turma.melhorPorCurso();
        for (Map.Entry<String, Aluno> entry : melhores.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("\nMelhor aluno da turma: " + turma.melhorAluno());
    }
}
