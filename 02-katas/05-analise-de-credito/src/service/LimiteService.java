package service;

import entities.Cliente;

/**
 * Calcula o limite de crédito sugerido para um cliente aprovado.
 *
 * Regra: base é um percentual da renda mensal, ajustado pelo score.
 *   Score 600–699  → 1x a renda
 *   Score 700–849  → 2x a renda
 *   Score 850–1000 → 3x a renda
 *
 * Clientes reprovados recebem limite zero.
 */

public class LimiteService {

    public double calcularLimite(Cliente cliente, int score, boolean aprovado) {
        if (!aprovado) return 0.0;

        double renda = cliente.getRenda();
        double multiplicador;

        if (score >= 850) {
            multiplicador = 3.0;
        } else if (score >= 700) {
            multiplicador = 2.0;
        } else {
            multiplicador = 1.0;
        }

        return renda * multiplicador;
    }
}
