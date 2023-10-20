package br.com.postech.techchallenge.adapters.out.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "client_order")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "cpf")
  private ClientEntity client;

  @Column(name = "status")
  private String status;

  @Column(name = "order_date")
  private LocalDateTime orderDate;

  @Column(name = "last_update_date")
  private LocalDateTime lastUpdateDate;

  @OneToOne(mappedBy = "order")
  private PaymentEntity payment;

  @OneToMany(mappedBy = "order")
  private List<OrderItemEntity> orderItems;
}