package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.repository.ItemRepository;
import br.com.postech.techchallenge.adapters.out.database.repository.OrderItemRepository;
import br.com.postech.techchallenge.application.ports.out.DeleteItemOutputPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteItemAdapter implements DeleteItemOutputPort {
  private final ItemRepository itemRepository;
  private final OrderItemRepository orderItemRepository;

  @Override
  @Transactional
  public void execute(Integer id) {
    var item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    orderItemRepository.deleteAllByItem(item);
    itemRepository.delete(item);
  }
}
