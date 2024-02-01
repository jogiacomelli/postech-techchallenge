package br.com.postech.techchallenge.infra.api.dto;

import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;

public record PedidoStatusDTO(Long idPedido, StatusPedido status) {

}
