package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.ports.in.RegisterItemInputPort;
import br.com.postech.techchallenge.application.ports.out.RegisterItemOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterItemUseCase implements RegisterItemInputPort {

  private final RegisterItemOutputPort registerItemOutputPort;

  @Override
  public Item execute(Item item) {
    return registerItemOutputPort.execute(item);
  }
}
