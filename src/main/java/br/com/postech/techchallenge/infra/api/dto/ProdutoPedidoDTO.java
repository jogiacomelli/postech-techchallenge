package br.com.postech.techchallenge.infra.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProdutoPedidoDTO {

  @NotBlank
  private Long itemId;

  @NotBlank
  @Positive
  private Integer quantity;
}
