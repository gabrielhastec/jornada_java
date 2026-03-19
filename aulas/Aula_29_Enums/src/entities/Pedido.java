package entities;

import enums.StatusPedido;

public class Pedido implements Identificavel {

    private final String id;
    private final String cliente;
    private final double total;
    private StatusPedido status;

    public Pedido(String id, String cliente, double total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.status = StatusPedido.NOVO;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void atualizarStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public String toString() {
        return id + " - " + cliente + " - " + status.getRotulo() + " (" + status.getDescricao() + ")";
    }
}
