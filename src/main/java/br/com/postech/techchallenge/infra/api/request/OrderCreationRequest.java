package br.com.postech.techchallenge.infra.api.request;

import br.com.postech.techchallenge.infra.api.dto.ProdutoPedidoDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class OrderCreationRequest {

  private String cpf;

  @NotEmpty
  private List<ProdutoPedidoDTO> orderItems;

}
