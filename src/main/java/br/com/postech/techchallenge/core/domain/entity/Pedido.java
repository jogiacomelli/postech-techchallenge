package br.com.postech.techchallenge.core.domain.entity;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.time.LocalDateTime;
import java.util.List;

import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;
import lombok.Data;

@Data
public class Pedido {

  private Integer id;
  private String cpf;
  private List<ItemPedido> itemPedidos;
  private StatusPedido status;
  private LocalDateTime orderDate;
  private LocalDateTime lastUpdateDate;

  public boolean isOrderWithIdentification() {
    return isNotBlank(cpf);
  }
}
