package br.com.postech.techchallenge.application.core.domain;

import br.com.postech.techchallenge.adapters.out.database.entity.enums.ItemType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class Item {
  private String name;
  private String description;
  private BigDecimal price;
  private ItemType type;
}
