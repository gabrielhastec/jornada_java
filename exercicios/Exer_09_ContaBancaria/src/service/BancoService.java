package service;

import entities.Cliente;
import utils.Exceptions.*;
import java.util.List;

public class BancoService {

    private List<Cliente> clientes;

    public BancoService(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    private Cliente buscarCliente(String id) throws ClienteNaoEncontradoException {
        
        // Usando Stream para buscar o cliente por ID
        return clientes.stream()  
                .filter(c -> c.getId() == id)  // Filtra o cliente com o ID correspondente
                .findFirst()   // Retorna o primeiro cliente encontrado (se houver)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente com ID " + id + " não encontrado."));    // Lança exceção se o cliente não for encontrado
    }

    public void depositar(String id, double valor) throws ClienteNaoEncontradoException, ValorInvalidoException {
        if (valor <= 0) throw new ValorInvalidoException("Valor de depósito deve ser positivo.");
        Cliente c = buscarCliente(id);
        c.setSaldo(c.getSaldo() + valor);
    }

    public void sacar(String id, double valor) throws ClienteNaoEncontradoException, SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) throw new ValorInvalidoException("Valor de saque deve ser positivo.");
        Cliente c = buscarCliente(id);
        if (c.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo atual: " + c.getSaldo());
        }
        c.setSaldo(c.getSaldo() - valor);
    }

    public void transferir(String idOrigem, String idDestino, double valor) 
            throws ClienteNaoEncontradoException, SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) throw new ValorInvalidoException("Valor de transferência deve ser positivo.");
        Cliente origem = buscarCliente(idOrigem);
        Cliente destino = buscarCliente(idDestino);

        if (origem.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
        }

        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);
    }
}
