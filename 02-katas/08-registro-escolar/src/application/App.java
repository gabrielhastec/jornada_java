package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Professor;
import service.AlunoService;
import utils.Menu;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Aluno> listaAlunos = new ArrayList<>();
        List<Professor> listaProfessores = new ArrayList<>();
        AlunoService alunoService = new AlunoService(listaAlunos);

        int opcao;

        do {
            opcao = Menu.menuPrincipal(sc);

            switch (opcao) {

                case 1:
                    Menu.menuAluno(sc, alunoService);
                    break;

                case 2:
                    Menu.menuProfessor(sc, listaProfessores);
                    break;

                case 3:
                    Menu.menuRelatorios(sc, alunoService);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
