package service;

import entities.Saque;
import excepitions.SaqueInvalidoException;
import entities.Nota;

public class CaixaService {

    public void processarSaque(Saque saque) throws SaqueInvalidoException {

        int valor = saque.getValorSolicitado();

        if (valor % 5 != 0) {
            throw new SaqueInvalidoException("Valor do saque deve ser múltiplo de 5.");
        }

        Nota[] notas = Nota.getNotasDisponiveis();
        int i = 0;
        int restante = valor;

        while (i < notas.length) {
            if (restante >= notas[i].getValor()) {
                restante -= notas[i].getValor();
                saque.incrementarNota(i);
            } else {
                i++;
            }
        }

        while (restante > 0) {
            saque.subtrairValor(restante);
        }

    }
   
}
