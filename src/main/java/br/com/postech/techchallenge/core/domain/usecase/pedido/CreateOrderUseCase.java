package br.com.postech.techchallenge.core.domain.usecase.pedido;

import br.com.postech.techchallenge.core.domain.entity.Pedido;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.gateway.PedidoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOrderUseCase {

  private final PedidoGateway pedidoGateway;

  public Pedido execute(Pedido pedido) {
    try {
      return pedidoGateway.createPedido(pedido);
    } catch (IllegalArgumentException e) {
      throw new NotFoundException("Pedido com item não existente, revise o pedido!");
    }
  }
}
