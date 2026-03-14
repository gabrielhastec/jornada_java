package application;

import java.util.Scanner;
import model.Calculadora;
import utils.Menu;
import utils.DivisaoPorZeroException;

public class Main {

    public static void main(String[] args) {

        Scanner sc  = new Scanner (System.in);
        Menu menu   = new Menu(sc);
        boolean continuar = true;

        menu.exibirCabecalho();
        
        while (continuar) {

            menu.exibirOperacoes();

            double opcao1 = menu.lerOpcao("Primeiro número: ");
            double opcao2 = menu.lerOpcao("Segundo número: ");
            int dgVerificador = (int) menu.lerOperador("Digite o dígito da operação desejada: ");

            try {
                Calculadora calculadora = new Calculadora(opcao1, opcao2, dgVerificador);
                calculadora.calcular();
                menu.exibirResultado(calculadora.toString());
            } catch (DivisaoPorZeroException e) {
                menu.exibirErro(e.getMessage());
            } catch (IllegalArgumentException e) {
                menu.exibirErro(e.getMessage());
            }
            continuar = menu.askContinuar();

        }

        menu.exibirEncerramento();
        sc.close();
        
    }
    
}
