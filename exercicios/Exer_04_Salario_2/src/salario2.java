/*
📌 Regras de Negócio
O sistema deve receber:
salário base
quantidade de horas extras
se o funcionário é CLT ou PJ

Regras:
Hora extra vale 50% a mais
Se for CLT:
    desconto de 8% de INSS
Se for PJ:
    não tem desconto
Salário final não pode ser menor que o salário mínimo (R$ 1.412)
*/

import java.util.Scanner;

public class salario2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nome, verificacao;
        int qtdHoraExtra;
        double salarioBase, valorHora, valorHoraExtra, horaExtra50, desconto, saldoBruto, saldoFinal, salarioMinimo;
        boolean contratado;

        salarioMinimo = 1412;
        contratado = false;

        System.out.println("====== INICIANDO PROGRAMA ======");
        System.out.println("Qual é o seu nome? ");
        nome = sc.nextLine();

        System.out.println("Qual é o seu salário Base? ");
        salarioBase = sc.nextDouble();

        System.out.println("Quantas horas extras fez no mês? ");
        qtdHoraExtra = sc.nextInt();

        System.out.println("Trabalha de Carteira Assinada?  Y - Sim | N - Não");
        verificacao = sc.nextLine();
        verificacao = sc.nextLine();

        if (verificacao.equalsIgnoreCase("y")){
            contratado = true;
        } else {
            contratado = false;
        }

        System.out.println("====== PROCESSANDO... ======");
        System.out.printf("Olá, %s. Seja Bem-vindo ao Sistema de Salário\n", nome);
        
        valorHora = salarioBase / 180;
        System.out.printf("Você recebe: %.2f por hora. \n", valorHora);

        horaExtra50 = (valorHora * qtdHoraExtra) * 0.5;
        valorHoraExtra = (valorHora * qtdHoraExtra) + horaExtra50;
        System.out.printf("Você recebeu: %.2f em horas extras. \n", valorHoraExtra);

        saldoBruto = salarioBase + valorHoraExtra;
        System.out.printf("Seu salário sem descontos é: %.2f\n", saldoBruto);

        if (contratado == true){
            desconto = saldoBruto * 0.08;
        } else {
            desconto = 0;
        }

        saldoFinal = saldoBruto - desconto;

        if (saldoFinal < salarioMinimo) {
            System.out.printf("Você recebeu menos que o salário mínimo: %.2f\n", saldoFinal);
            saldoFinal = salarioMinimo;
            System.out.printf("Seu salário foi convertido para: %.2f\n", saldoFinal);
        }

        System.out.println("========== Relatório do Mês ==========");
        System.out.printf("Nome =         | %s\n", nome);
        System.out.printf("Salário Base = | %.2f\n", salarioBase);
        System.out.printf("Valor de Hora Extra = | %.2f\n", valorHoraExtra);
        System.out.printf("Saldo Final sem Desconto = | %.2f\n", saldoBruto);
        System.out.println("-------------------------------------");
        if (contratado == true){
            System.out.printf("Desconto INSS = | %.2f\n", desconto);
        } else {
            System.out.printf("--------------------------------- \n");
        }
        
        System.out.printf("Saldo Final = | %.2f\n", saldoFinal);
        
        sc.close();

        
    }
    
}
