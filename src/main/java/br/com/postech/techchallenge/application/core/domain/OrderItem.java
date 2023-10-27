package br.com.postech.techchallenge.application.core.domain;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderItem {
  private Integer itemId;
  private Integer quantity;
  private BigDecimal totalPrice;
}
