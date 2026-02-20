package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.aluno;
import entities.professor;
import utils.menu;

public class app {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<aluno> listaAlunos = new ArrayList<>();
        List<professor> listaProfessores = new ArrayList<>();

        int opcao;

        do {
            opcao = menu.menuPrincipal(sc);

            switch (opcao) {

                case 1:
                    menu.menuAluno(sc, listaAlunos);
                    break;

                case 2:
                    menu.menuProfessor(sc, listaProfessores);
                    break;
                
                case 3:
                    menu.menuRelatorios(listaAlunos);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
