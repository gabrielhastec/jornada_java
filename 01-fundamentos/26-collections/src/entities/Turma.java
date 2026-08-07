package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Turma {

    private final List<Aluno> alunos = new ArrayList<>(); // lista preserva ordem de insercao

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno melhorAluno() {
        Aluno melhor = alunos.get(0);
        for (Aluno a : alunos) {
            if (a.getNota() > melhor.getNota()) {
                melhor = a;
            }
        }
        return melhor;
    }

    public Set<String> cursosDistintos() {
        Set<String> cursos = new HashSet<>();
        for (Aluno a : alunos) {
            cursos.add(a.getCurso()); // Set ignora duplicados
        }
        return cursos;
    }

    public Map<String, Integer> contagemPorCurso() {
        Map<String, Integer> contagem = new HashMap<>();
        for (Aluno a : alunos) {
            String curso = a.getCurso();
            Integer atual = contagem.get(curso);
            contagem.put(curso, (atual == null) ? 1 : atual + 1);
        }
        return contagem;
    }

    public Map<String, Aluno> melhorPorCurso() {
        Map<String, Aluno> melhor = new HashMap<>();
        for (Aluno a : alunos) {
            Aluno atual = melhor.get(a.getCurso());
            if (atual == null || a.getNota() > atual.getNota()) {
                melhor.put(a.getCurso(), a);
            }
        }
        return melhor;
    }
}
