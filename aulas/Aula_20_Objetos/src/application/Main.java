package application;

import entities.Departamento;
import entities.Funcionario;

public class Main {
    public static void main(String[] args) {
        Departamento dept = new Departamento("TI");
        Funcionario func = new Funcionario("Ana", dept);
        func.exibirInfo();
    }
}
