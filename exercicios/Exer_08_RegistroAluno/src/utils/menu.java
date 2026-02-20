package utils;

import java.util.List;
import java.util.Scanner;

import entities.aluno;
import entities.professor;

public class menu {

    public static int menuPrincipal(Scanner sc) {

        System.out.println("\n===== SISTEMA ESCOLAR =====");
        System.out.println("1 - Alunos");
        System.out.println("2 - Professores");
        System.out.println("3 - Relatórios");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        return sc.nextInt();
    }

    public static void menuAluno(Scanner sc, List<aluno> lista) {

        System.out.println("\n1 - Cadastro: ");
        System.out.println("2 - Atualizar: ");
        System.out.println("3 - Aplicar Notas: ");
        System.out.print("Escolha: ");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                System.out.print("Matrícula: ");
                int mat = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                lista.add(new aluno(mat, nome));
                System.out.println("Aluno cadastrado!");
                break;

            case 2:
                System.out.print("Digite matrícula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                for (aluno a : lista) {
                    if (a.getMatricula() == matricula) {
                        System.out.print("Novo nome: ");
                        a.setNome(sc.nextLine());
                        System.out.println("Atualizado!");
                        return;
                    }
                }
                System.out.println("Aluno não encontrado!");
                break;

            case 3:
                System.out.print("Digite matrícula: ");
                int matNotas = sc.nextInt();

                for (aluno a : lista) {
                    if (a.getMatricula() == matNotas) {
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Nota " + (i + 1) + ": ");
                            a.setNota(i, sc.nextDouble());
                        }
                        System.out.println("Notas cadastradas!");
                        return;
                    }
                }
                System.out.println("Aluno não encontrado!");
                break;
        }
    }

    public static void menuProfessor(Scanner sc, List<professor> lista) {

        System.out.println("\n1 - Cadastro: ");
        System.out.println("2 - Atualizar: ");
        System.out.print("Escolha: ");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                System.out.print("Matrícula: ");
                int mat = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Materia: ");
                String materia = sc.nextLine();

                lista.add(new professor(mat, nome, materia));
                System.out.println("Professor(a) cadastrado!");
                break;

            case 2:
                System.out.print("Digite matrícula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                for (professor a : lista) {
                    if (a.getMatricula() == matricula) {
                        System.out.print("Novo nome: ");
                        a.setNome(sc.nextLine());
                        System.out.println("Atualizado!");
                        return;
                    }
                }
                System.out.println("Professor(a) não encontrado!");
                break;

            default:
                System.out.println("Opção inválida!");
                break;
            
    
        }
    }

    public static void menuRelatorios(List<aluno> lista) {

        System.out.println("\n1 - Apenas Aprovados");
        System.out.println("2 - Apenas Recuperação");
        System.out.println("3 - Todos");
        System.out.print("Escolha: ");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op) {

            case 1:
                for (aluno a : lista) {
                    if (a.isAprovado()) {
                        System.out.println(a);
                    }
                }
                break;

            case 2:
                for (aluno a : lista) {
                    if (!a.isAprovado()) {
                        System.out.println(a);
                    }
                }
                break;

            case 3:
                for (aluno a : lista) {
                    System.out.println(a);
                }
                break;
        }

        sc.close();

    }
}
