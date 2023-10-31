package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Order;

public interface CreateOrderOutputPort {
  Order execute(Order order);
}
