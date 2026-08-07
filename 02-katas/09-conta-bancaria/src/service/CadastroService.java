package service;

import entities.Cliente;
import entities.Ocupacao;
import java.util.List;

public class CadastroService {

    public void cadastrarCliente(List<Cliente> 
        clientes, 
        String id, 
        String nome, 
        int idade, 
        int codOcupacao, 
        double salario) {

            Ocupacao ocupacao = Ocupacao.fromCodigo(codOcupacao);
            Cliente novo = new Cliente(id, nome, idade, ocupacao, salario);
            double limite = ValidadorCredito.calcularLimite(novo);
            novo.setLimiteCredito(limite);
            clientes.add(novo);
    }
}
