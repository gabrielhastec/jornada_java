/*
🎯 Contexto
Criar um sistema simples de análise de crédito bancário.

📌 Entradas
idade
renda mensal
score de crédito (0 a 1000)

📜 Regras
O crédito será aprovado se:
idade ≥ 18
renda ≥ 1500
score ≥ 600
*/

import java.util.Scanner;

public class analiseCred {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        String nome;
        int idade, opcao, score;
        double renda;
        boolean aprovado = false;
        score = 0;

        System.out.println("========== INICIANDO O PROGRAMA ==========");
        System.out.println("Informe o seu nome: ");
        nome = sc.nextLine();

        System.out.println("Informe sua idade: ");
        idade = sc.nextInt();

        if (idade < 18){
            score += 50;
            System.out.println("Você é classificado como instável");
        } 
        else if ((idade >= 18) && (idade < 30)){
            score += 100;
            System.out.println("Você é classificado como variável");
        } 
        else if ((idade >= 30) && (idade < 65)) {
            score += 200;
            System.out.println("Você é classificado como estável");
        } 
        else{
            score += 50;
            System.out.println("Você é considerado como variável");
        }

        System.out.println("========== CARREGANDO... ==========");
        System.out.println();

        System.out.println("----Escolha sua ocupação: ----");
        System.out.println("---- 1. Carteira Assinada ----");
        System.out.println("---- 2. Servidor Público ----");
        System.out.println("---- 3. Autônomo / Empreendedor ----");
        System.out.println("---- 4. Estudante / Estágio ----");
        System.out.println("---- 5. Desempregado ----");
        opcao = sc.nextInt();

        if (opcao == 1){
            score += 400;
            System.out.println("Você trabalha de Carteira assinada.");

        } 
        else if (opcao == 2) {
            score += 600;
            System.out.println("Você é um servidor público.");

        } 
        else if (opcao == 3){
            score += 200;
            System.out.println("Você é um autonomo.");

        }
        else if (opcao == 4) {
            score += 100;
            System.out.println("Você é um estudante.");

        }
        else {
            score -= 100;
            System.out.println("Você é desempregado.");
        }

        System.out.println("========== CARREGANDO... ==========");
        System.out.println();

        System.out.println("Informe sua renda mensal: ");
        renda = sc.nextDouble();

        if (renda < 1500) { 
            score -= 50;
        } else if ((renda >= 1500) && (renda < 3000) ) {
            score += 100;
        }  else if ((renda >= 3000) && (renda < 5000)) {
            score += 150;
        } else {
            score += 200;
        }

        System.out.println("========== CARREGANDO... ==========");
        System.out.println();

        if (score > 1000){
            score = 1000;
        }

        System.out.println("========== CARREGANDO... ==========");
        System.out.printf("NOME:    | %s\n", nome);
        System.out.printf("IDADE:   | %d\n", idade);
        System.out.printf("RENDA:   | %.2f\n", renda);
        System.out.printf("SCORE:   | %d\n", score);

        System.out.println("======== ANALISANDO PERFIL... ========");

        if ((idade >= 18) && (renda >= 1500) && (score >= 600)){
            aprovado = true;
            System.out.println("Seu crédito foi aprovado!" + aprovado);

        }else{
            System.out.println("Seu crédito foi reprovado!");
        }

        sc.close();
        

    }
}
