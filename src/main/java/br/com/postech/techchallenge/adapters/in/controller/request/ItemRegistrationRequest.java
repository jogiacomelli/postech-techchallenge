package br.com.postech.techchallenge.adapters.in.controller.request;

import br.com.postech.techchallenge.application.core.domain.enums.ItemType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ItemRegistrationRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotNull
  private BigDecimal price;

  @NotNull
  private ItemType type;
}
