package br.com.postech.techchallenge.adapters.gateways;

import java.util.List;

import br.com.postech.techchallenge.domain.enums.StatusPedido;
import br.com.postech.techchallenge.domain.model.Pedido;

public interface PedidoGateway {

    Pedido findPedidoById(Long id);

    List<Pedido> findAllPedidos();

    Pedido createPedido(Pedido pedido);

    Pedido updatePedido(Long id, Pedido pedido);

    boolean deletePedido(Long id);

    List<Pedido> findPedidosByStatusPagamento(boolean pago);

    List<Pedido> findPedidosByStatus(StatusPedido status);

    List<Pedido> findPedidosAtivos();

}
