package br.com.postech.techchallenge.infra.controller;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPagamento;
import br.com.postech.techchallenge.core.domain.usecase.pedido.UpdatePagamentoUseCase;
import br.com.postech.techchallenge.core.gateway.PagamentoGateway;
import br.com.postech.techchallenge.core.repository.PedidoRepository;
import br.com.postech.techchallenge.infra.gateway.PagamentoGatewayImpl;

public class PagamentoController {

    private final UpdatePagamentoUseCase updatePagamentoUseCase;

    public PagamentoController(PedidoRepository pedidoRepository) {
        PagamentoGateway pagamentoGateway = new PagamentoGatewayImpl(pedidoRepository);
        this.updatePagamentoUseCase = new UpdatePagamentoUseCase(pagamentoGateway);
    }

    public void updatePagamento(Long idPedido, StatusPagamento statusPagamento) {
        updatePagamentoUseCase.pagar(idPedido, statusPagamento);
    }
}
