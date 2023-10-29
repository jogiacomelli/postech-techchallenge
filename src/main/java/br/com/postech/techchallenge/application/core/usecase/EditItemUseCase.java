package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.application.ports.in.EditItemInputPort;
import br.com.postech.techchallenge.application.ports.out.EditItemOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditItemUseCase implements EditItemInputPort {
    private final EditItemOutputPort editItemOutputPort;
    @Override
    public Item execute(Integer id, Item item) {
        try {
            return editItemOutputPort.execute(id, item);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException("Item não encontrado!");
        }
    }
}
