package services;

import entities.Pedido;
import enums.StatusPedido;
import exceptions.TransicaoDeStatusException;
import repositories.Repositorio;

public class PedidoService {

    private final Repositorio<Pedido> pedidos;

    public PedidoService(Repositorio<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void cadastrar(Pedido pedido) {
        pedidos.salvar(pedido);
    }

    public Pedido buscar(String id) {
        Pedido pedido = pedidos.buscar(id);
        if (pedido == null) {
            throw new TransicaoDeStatusException("Pedido " + id + " nao encontrado.");
        }
        return pedido;
    }

    public void mudarStatus(String id, StatusPedido novoStatus) {
        Pedido pedido = buscar(id);
        StatusPedido statusAtual = pedido.getStatus();

        if (!statusAtual.podeAvancarPara(novoStatus)) {
            throw new TransicaoDeStatusException(
                    "Transicao invalida de " + statusAtual + " para " + novoStatus);
        }

        pedido.atualizarStatus(novoStatus);
    }
}
