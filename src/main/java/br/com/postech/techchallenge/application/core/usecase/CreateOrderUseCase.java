package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.application.ports.in.CreateOrderInputPort;
import br.com.postech.techchallenge.application.ports.out.CreateOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOrderUseCase implements CreateOrderInputPort {

  private final CreateOrderOutputPort createOrderOutputPort;
  private final SearchClientByCpfUseCase searchClientByCpfUseCase;

  @Override
  public void execute(Order order) {
    try {
      createOrderOutputPort.execute(order);
    } catch (IllegalArgumentException e) {
      throw new NotFoundException("Pedido com item não existente, revise o pedido!");
    }
  }
}
