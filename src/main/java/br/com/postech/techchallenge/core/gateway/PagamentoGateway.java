package br.com.postech.techchallenge.core.gateway;

import br.com.postech.techchallenge.core.domain.entity.Pagamento;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPagamento;

public interface PagamentoGateway {
    void updatePagamento(Long id, StatusPagamento pagamento);

}
