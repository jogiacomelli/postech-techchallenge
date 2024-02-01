package br.com.postech.techchallenge.core.domain.entity;

import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;
import lombok.Data;

@Data
public class PedidoStatus {
    private Long idPedido;
    private StatusPedido status;
}
