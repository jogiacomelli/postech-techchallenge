package br.com.postech.techchallenge.infra.api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {
    private String cpf;

    @NotEmpty
    private List<ProdutoPedidoDTO> orderItems;


}
