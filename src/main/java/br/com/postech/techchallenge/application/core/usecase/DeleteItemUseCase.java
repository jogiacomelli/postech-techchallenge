package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.application.ports.in.DeleteItemInputPort;
import br.com.postech.techchallenge.application.ports.out.DeleteItemOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteItemUseCase implements DeleteItemInputPort {
  private final DeleteItemOutputPort deleteItemOutputPort;

  @Override
  public void execute(Integer id) {
    try {
      deleteItemOutputPort.execute(id);
    } catch (IllegalArgumentException e) {
      throw new NotFoundException("Item not found");
    }
  }
}
