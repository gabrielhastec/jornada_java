package application;

import entities.Funcionario;

public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();                       // padrão
        Funcionario f2 = new Funcionario("Maria", "Analista");   // nome e cargo
        Funcionario f3 = new Funcionario("João", "Gerente", 5000.0); // completo

        f1.exibirInfo();
        f2.exibirInfo();
        f3.exibirInfo();

        f3.aumentarSalario(10.0);        // percentual
        f3.exibirInfo();
        f3.aumentarSalario(300.0, true); // valor fixo
        f3.exibirInfo();
    }
}
