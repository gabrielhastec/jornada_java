package utils;

import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Professor;
import exceptions.AlunoNaoEncontradoException;
import exceptions.NotaInvalidaException;
import service.AlunoService;

public class Menu {

    public static int menuPrincipal(Scanner sc) {

        System.out.println("\n===== SISTEMA ESCOLAR =====");
        System.out.println("1 - Alunos");
        System.out.println("2 - Professores");
        System.out.println("3 - Relatorios");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        return sc.nextInt();
    }

    public static void menuAluno(Scanner sc, AlunoService alunoService) {

        System.out.println("\n1 - Cadastro: ");
        System.out.println("2 - Atualizar: ");
        System.out.println("3 - Aplicar Notas: ");
        System.out.print("Escolha: ");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                System.out.print("Matricula: ");
                int mat = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                alunoService.adicionarAluno(mat, nome);
                System.out.println("Aluno cadastrado!");
                break;

            case 2:
                System.out.print("Digite matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                try {
                    Aluno aluno = alunoService.buscarPorMatricula(matricula);
                    System.out.print("Novo nome: ");
                    aluno.setNome(sc.nextLine());
                    System.out.println("Atualizado!");
                } catch (AlunoNaoEncontradoException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.print("Digite matricula: ");
                int matNotas = sc.nextInt();
                sc.nextLine();

                try {
                    alunoService.buscarPorMatricula(matNotas);
                } catch (AlunoNaoEncontradoException e) {
                    System.out.println(e.getMessage());
                    break;
                }

                double[] notas = new double[4];
                for (int i = 0; i < 4; i++) {
                    System.out.print("Nota " + (i + 1) + ": ");
                    notas[i] = sc.nextDouble();
                }
                sc.nextLine();

                try {
                    alunoService.aplicarNota(matNotas, notas);
                    System.out.println("Notas cadastradas!");
                } catch (AlunoNaoEncontradoException | NotaInvalidaException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Opcao invalida!");
                break;
        }
    }

    public static void menuProfessor(Scanner sc, List<Professor> lista) {

        System.out.println("\n1 - Cadastro: ");
        System.out.println("2 - Atualizar: ");
        System.out.print("Escolha: ");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                System.out.print("Matricula: ");
                int mat = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Materia: ");
                String materia = sc.nextLine();

                lista.add(new Professor(mat, nome, materia));
                System.out.println("Professor(a) cadastrado!");
                break;

            case 2:
                System.out.print("Digite matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                for (Professor professor : lista) {
                    if (professor.getMatricula() == matricula) {
                        System.out.print("Novo nome: ");
                        professor.setNome(sc.nextLine());
                        System.out.println("Atualizado!");
                        return;
                    }
                }
                System.out.println("Professor(a) nao encontrado!");
                break;

            default:
                System.out.println("Opcao invalida!");
                break;
        }
    }

    public static void menuRelatorios(Scanner sc, AlunoService alunoService) {

        System.out.println("\n1 - Apenas Aprovados");
        System.out.println("2 - Apenas Reprovados");
        System.out.println("3 - Todos");
        System.out.print("Escolha: ");
        int op = sc.nextInt();
        sc.nextLine();

        List<Aluno> todos = alunoService.getAlunos();
        if (todos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        switch (op) {
            case 1:
                todos.stream().filter(alunoService::isAprovado).forEach(aluno -> exibirAluno(aluno, alunoService));
                break;
            case 2:
                todos.stream().filter(aluno -> !alunoService.isAprovado(aluno))
                        .forEach(aluno -> exibirAluno(aluno, alunoService));
                break;
            case 3:
                todos.forEach(aluno -> exibirAluno(aluno, alunoService));
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }

    private static void exibirAluno(Aluno aluno, AlunoService alunoService) {
        System.out.printf("Matricula: %d | Nome: %s | Media: %.2f | Status: %s%n",
                aluno.getMatricula(), aluno.getNome(),
                alunoService.calcularMedia(aluno),
                alunoService.isAprovado(aluno) ? "Aprovado" : "Reprovado");
    }
}
