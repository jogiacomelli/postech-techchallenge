package br.com.postech.techchallenge.infra.repository.entity;

import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @JoinColumn(name = "cpf")
  private String cpf;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private StatusPedido status;

  @Column(name = "order_date", insertable = false, updatable = false)
  private LocalDateTime orderDate;

  @Column(name = "last_update_date", insertable = false, updatable = false)
  private LocalDateTime lastUpdateDate;

  @OneToOne(mappedBy = "order")
  private PagamentoEntity payment;

  @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
  private List<ProdutoPedidoEntity> orderItems = new ArrayList<>();

  public void addOrderItem(ProdutoPedidoEntity orderItem) {
    this.orderItems.add(orderItem);
    orderItem.setOrder(this);
  }
}