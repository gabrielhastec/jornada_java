package service;

import entities.Cliente;

public class ValidadorCredito {

    public static double calcularLimite(Cliente cliente) {
        
        double base = cliente.getSalario() * 0.3; // 30% do salário como base

        // Ajuste por idade
        if (cliente.getIdade() < 25) {
            base *= 0.8; // 20% a menos para jovens
        } else if (cliente.getIdade() > 60) {
            base *= 1.2; // 20% a mais para idosos (estabilidade)
        }

        // Ajuste por ocupação
        switch (cliente.getOcupacao()) {
            case SERVIDOR_PUBLICO:
                base *= 1.5; // mais estável
                break;
            case PRIVADO:
                base *= 1.2;
                break;
            case AUTONOMO:
                base *= 1.0; // sem acréscimo
                break;
        }

        // Garantir um mínimo, se desejar
        return Math.max(base, 100.0);
    }
}
