package br.com.postech.techchallenge.application.core.domain;

import br.com.postech.techchallenge.application.core.domain.enums.ItemType;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class Item {
  private Integer id;
  private String name;
  private String description;
  private BigDecimal price;
  private ItemType type;
}
