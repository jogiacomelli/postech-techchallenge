package br.com.postech.techchallenge.core.gateway;

import br.com.postech.techchallenge.core.domain.entity.Pedido;

import java.util.List;

public interface PedidoGateway {

    Pedido findPedidoById(Long id);

    List<Pedido> findAllPedidos();

    Pedido createPedido(Pedido pedido);

    Pedido updatePedido(Long id, Pedido pedido);

}
