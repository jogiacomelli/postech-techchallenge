package br.com.postech.techchallenge.infra.api.request;

import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ItemEditionRequest {
  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotNull
  private BigDecimal price;

  @NotNull
  private Categoria type;

}
