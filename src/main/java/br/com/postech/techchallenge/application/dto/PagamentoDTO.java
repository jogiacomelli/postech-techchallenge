package br.com.postech.techchallenge.application.dto;

public record PagamentoDTO(
        Long id,
        String idCobranca,
        String idtx,
        Long idPedido
) {

}
