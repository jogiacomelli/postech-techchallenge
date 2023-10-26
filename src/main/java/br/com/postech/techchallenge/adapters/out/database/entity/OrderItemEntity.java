package br.com.postech.techchallenge.adapters.out.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Table(name = "order_item")
@Data
public class OrderItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderEntity order;

  @ManyToOne
  @JoinColumn(name = "item_id")
  private ItemEntity item;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "total_price")
  private BigDecimal totalPrice;
}
