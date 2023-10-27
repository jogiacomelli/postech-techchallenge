package br.com.postech.techchallenge.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemRequest {

  @NotBlank
  private Integer itemId;

  @NotBlank
  @Positive
  private Integer quantity;
}
