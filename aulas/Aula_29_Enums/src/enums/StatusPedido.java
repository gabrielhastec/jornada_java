package enums;

public enum StatusPedido {

    NOVO("Novo", "Aguardando pagamento"),
    PAGO("Pago", "Preparando envio"),
    ENVIADO("Enviado", "Em transito"),
    ENTREGUE("Entregue", "Finalizado"),
    CANCELADO("Cancelado", "Pedido encerrado");

    private final String rotulo;
    private final String descricao;

    StatusPedido(String rotulo, String descricao) {
        this.rotulo = rotulo;
        this.descricao = descricao;
    }

    public String getRotulo() {
        return rotulo;
    }

    public String getDescricao() {
        return descricao;
    }

    // Regras simples de fluxo
    public boolean podeAvancarPara(StatusPedido destino) {
        switch (this) {
            case NOVO:
                return destino == PAGO || destino == CANCELADO;
            case PAGO:
                return destino == ENVIADO || destino == CANCELADO;
            case ENVIADO:
                return destino == ENTREGUE;
            default:
                return false;
        }
    }
}
