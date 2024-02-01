package br.com.postech.techchallenge.core.repository;

import br.com.postech.techchallenge.core.domain.entity.Pedido;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPagamento;

import java.util.List;

public interface PedidoRepository {

    Pedido findPedidoById(Long id);

    List<Pedido> findAllPedidos();

    Pedido createPedido(Pedido pedido);

    Pedido updatePedido(Long id, Pedido pedido);

    void updatePagamentoToPedido(Long idPedido, StatusPagamento statusPagamento);

    }
