package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Order;

public interface CreateOrderInputPort {
  void execute(Order order);

}
