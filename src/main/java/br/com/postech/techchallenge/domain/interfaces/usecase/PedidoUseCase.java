package br.com.postech.techchallenge.domain.interfaces.usecase;

import java.util.List;

import br.com.postech.techchallenge.application.dto.PedidoDTO;
import br.com.postech.techchallenge.domain.enums.StatusPedido;
import br.com.postech.techchallenge.domain.model.Pedido;

public interface PedidoUseCase {

    PedidoDTO getPedidoById(Long id);

    List<PedidoDTO> getAllPedidos();

    PedidoDTO createPedido(PedidoDTO pedidoDTO);

    PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO);

    boolean deletePedido(Long id);

    List<Pedido> findPedidosByStatus(StatusPedido status);

    List<PedidoDTO> findPedidosAtivos();

}
