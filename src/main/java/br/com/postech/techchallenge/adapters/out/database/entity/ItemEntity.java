package br.com.postech.techchallenge.adapters.out.database.entity;

import br.com.postech.techchallenge.adapters.out.database.entity.enums.ItemType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "item")
public class ItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private ItemType type;

  @OneToMany(mappedBy = "item")
  private List<OrderItemEntity> orderItems;
}
