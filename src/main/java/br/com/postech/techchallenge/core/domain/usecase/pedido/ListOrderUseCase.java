package br.com.postech.techchallenge.core.domain.usecase.pedido;

import br.com.postech.techchallenge.core.domain.entity.Pedido;
import br.com.postech.techchallenge.core.gateway.PedidoGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListOrderUseCase {

    private final PedidoGateway pedidoGateway;
    public List<Pedido> execute() {
        return pedidoGateway.findAllPedidos();
    }
}
