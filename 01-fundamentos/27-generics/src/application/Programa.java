package application;

import entities.Aluno;
import repositories.Repositorio;
import utils.GenericsUtils;

import java.util.List;

public class Programa {

    public static void main(String[] args) {

        // Repositorio generico que reaproveita List/Map da aula de colecoes
        Repositorio<Aluno> alunos = new Repositorio<>();

        alunos.salvar(new Aluno("A1", "Ana", "Java", 8.6));
        alunos.salvar(new Aluno("A2", "Bruno", "Python", 7.9));
        alunos.salvar(new Aluno("A3", "Carla", "Java", 9.2));

        // Type safety: so aceita Aluno
        System.out.println("Listando alunos (List retornada pelo repositorio):");
        List<Aluno> lista = alunos.listarTodos();
        GenericsUtils.imprimirColecao(lista); // wildcard aceita qualquer colecao

        // Buscando por id (Map interno tipado)
        System.out.println("\nBuscar A2:");
        System.out.println(alunos.buscarPorId("A2"));

        // Metodo generico para pegar o ultimo elemento
        Aluno ultimo = GenericsUtils.ultimo(lista);
        System.out.println("\nUltimo da lista: " + ultimo);
    }
}
