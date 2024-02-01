package br.com.postech.techchallenge.core.domain.usecase.pedido;

import br.com.postech.techchallenge.core.domain.entity.enums.StatusPagamento;
import br.com.postech.techchallenge.core.gateway.PagamentoGateway;
import br.com.postech.techchallenge.core.gateway.PedidoGateway;
import br.com.postech.techchallenge.core.repository.PedidoRepository;

public class UpdatePagamentoUseCase {

    private final PagamentoGateway pagamentoGateway;

    public UpdatePagamentoUseCase(PagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }

    public void pagar(Long idPedido, StatusPagamento statusPagamento) {
        this.pagamentoGateway.updatePagamento(idPedido, statusPagamento);
    }
}
