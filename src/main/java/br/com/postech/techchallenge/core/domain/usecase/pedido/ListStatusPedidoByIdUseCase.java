package br.com.postech.techchallenge.core.domain.usecase.pedido;

import br.com.postech.techchallenge.core.domain.entity.Pedido;
import br.com.postech.techchallenge.core.gateway.PedidoGateway;

public class ListStatusPedidoByIdUseCase {
    private final PedidoGateway pedidoGateway;

    public ListStatusPedidoByIdUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido execute(Long idPedido) {
        return pedidoGateway.findPedidoById(idPedido);
    }
}
