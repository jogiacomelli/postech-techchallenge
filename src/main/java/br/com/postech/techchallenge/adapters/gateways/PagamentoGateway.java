package br.com.postech.techchallenge.adapters.gateways;

import br.com.postech.techchallenge.application.dto.PagamentoDTO;
import br.com.postech.techchallenge.domain.model.Pagamento;

public interface PagamentoGateway {

    Pagamento savePagamento(Pagamento pagamento);

    Pagamento findPagamentoByIdPedido(Long id);

}
