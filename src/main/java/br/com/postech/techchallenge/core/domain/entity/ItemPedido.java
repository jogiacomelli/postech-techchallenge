package br.com.postech.techchallenge.core.domain.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemPedido {
  private Long itemId;
  private Integer quantity;
  private BigDecimal totalPrice;
}
