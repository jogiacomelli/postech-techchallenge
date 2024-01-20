package br.com.postech.techchallenge.domain.interfaces.usecase;

import java.util.List;

import br.com.postech.techchallenge.application.dto.PedidoDTO;
import br.com.postech.techchallenge.domain.model.Cliente;
import br.com.postech.techchallenge.domain.model.Pedido;
public interface PagamentoUseCase {

    Boolean consultaStatusPagamento(Long id);

    Boolean verificaStatusPagamento(Long id);

    List<PedidoDTO> findPedidosByStatusPagamento(boolean pago);

    void gerarCobranca(PedidoDTO pedido, Cliente cliente);
}
