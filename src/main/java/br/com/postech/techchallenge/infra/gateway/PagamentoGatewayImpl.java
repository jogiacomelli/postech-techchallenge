package br.com.postech.techchallenge.infra.gateway;

import br.com.postech.techchallenge.core.domain.entity.enums.StatusPagamento;
import br.com.postech.techchallenge.core.gateway.PagamentoGateway;
import br.com.postech.techchallenge.core.repository.PedidoRepository;

public class PagamentoGatewayImpl implements PagamentoGateway {

    private final PedidoRepository pedidoRepository;
    public PagamentoGatewayImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void updatePagamento(Long id, StatusPagamento pagamento) {
        pedidoRepository.updatePagamentoToPedido(id, pagamento);
    }
}
