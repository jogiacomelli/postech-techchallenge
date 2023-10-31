package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.repository.ItemRepository;
import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.ports.out.EditItemOutputPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EditItemAdapter implements EditItemOutputPort {

  private final ItemRepository itemRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public Item execute(Integer id, Item item) {
    var itemEntity = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    modelMapper.map(item, itemEntity);
    return modelMapper.map(itemRepository.save(itemEntity), Item.class);
  }
}
