package br.com.postech.techchallenge.application.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

import br.com.postech.techchallenge.domain.enums.StatusPedido;

public record PedidoDTO(
        Long id,
        Long idCliente,
        List<ComboDTO> combos,
        BigDecimal valorTotal,
        StatusPedido status,
        boolean pago,
        Date dataCadastro,
        Date dataAlteracao
) {

}
