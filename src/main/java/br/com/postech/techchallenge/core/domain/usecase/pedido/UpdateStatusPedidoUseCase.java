package br.com.postech.techchallenge.core.domain.usecase.pedido;

import br.com.postech.techchallenge.core.domain.entity.Pedido;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;
import br.com.postech.techchallenge.core.gateway.PedidoGateway;

public class UpdateStatusPedidoUseCase {
    private final PedidoGateway pedidoGateway;

    public UpdateStatusPedidoUseCase(final PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido execute(Long id, StatusPedido statusPedido) {
        Pedido pedido = pedidoGateway.findPedidoById(id);
        pedido.setStatus(statusPedido);
        return pedidoGateway.updatePedido(id, pedido);
    }

}
