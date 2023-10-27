package br.com.postech.techchallenge.adapters.in.controller.request;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Data;

@Data
public class OrderCreationRequest {

  private String cpf;

  @NotEmpty
  private List<OrderItemRequest> orderItems;
}
