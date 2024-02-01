package br.com.postech.techchallenge.infra.gateway;

import br.com.postech.techchallenge.core.domain.entity.Pedido;
import br.com.postech.techchallenge.core.gateway.PedidoGateway;
import br.com.postech.techchallenge.core.repository.PedidoRepository;
import br.com.postech.techchallenge.core.repository.ProdutoRepository;

import java.util.List;

public class PedidoGatewayImpl implements PedidoGateway {

  private final PedidoRepository pedidoRepository;

  public PedidoGatewayImpl(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
  }


  @Override
  public Pedido findPedidoById(Long id) {
    return pedidoRepository.findPedidoById(id);
  }

  @Override
  public List<Pedido> findAllPedidos() {
    return pedidoRepository.findAllPedidos();
  }

  @Override
  public Pedido createPedido(Pedido pedido) {
    return pedidoRepository.createPedido(pedido);
  }

  @Override
  public Pedido updatePedido(Long id, Pedido pedido) {
    return pedidoRepository.updatePedido(id, pedido);
  }

}
