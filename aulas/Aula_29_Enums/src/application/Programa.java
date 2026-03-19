package application;

import entities.Pedido;
import enums.StatusPedido;
import exceptions.TransicaoDeStatusException;
import repositories.Repositorio;
import services.PedidoService;

public class Programa {

    public static void main(String[] args) {

        Repositorio<Pedido> repositorio = new Repositorio<>();
        PedidoService service = new PedidoService(repositorio);

        service.cadastrar(new Pedido("P1", "Ana", 120.0));
        service.cadastrar(new Pedido("P2", "Bruno", 250.0));

        // values() e valueOf()
        System.out.println("Status disponiveis:");
        for (StatusPedido status : StatusPedido.values()) {
            System.out.println(status + " - " + status.getRotulo() + " (" + status.getDescricao() + ")");
        }

        StatusPedido convertido = StatusPedido.valueOf("PAGO");
        System.out.println("\nConvertido a partir de String: " + convertido);

        // Fluxo feliz
        service.mudarStatus("P1", StatusPedido.PAGO);
        service.mudarStatus("P1", StatusPedido.ENVIADO);
        service.mudarStatus("P1", StatusPedido.ENTREGUE);

        // Tentativa invalida gera excecao customizada (unchecked)
        try {
            service.mudarStatus("P2", StatusPedido.ENTREGUE); // nao pode pular para ENTREGUE
        } catch (TransicaoDeStatusException e) {
            System.out.println("\nFalha ao mudar status: " + e.getMessage());
        }

        // Id inexistente tambem gera excecao
        try {
            service.mudarStatus("PX", StatusPedido.PAGO);
        } catch (TransicaoDeStatusException e) {
            System.out.println("Erro ao buscar pedido: " + e.getMessage());
        }

        // Listagem final
        System.out.println("\nPedidos cadastrados:");
        for (Pedido pedido : repositorio.listarTodos()) {
            System.out.println(pedido);
        }
    }
}
