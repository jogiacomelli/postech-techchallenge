package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.repository.ItemRepository;
import br.com.postech.techchallenge.application.ports.out.DeleteItemOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteItemAdapter implements DeleteItemOutputPort {
    private final ItemRepository itemRepository;
    @Override
    public void execute(Integer id) {
        itemRepository.deleteById(id);
    }
}
