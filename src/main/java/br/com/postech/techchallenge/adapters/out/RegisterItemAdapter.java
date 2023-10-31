package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.entity.ItemEntity;
import br.com.postech.techchallenge.adapters.out.database.repository.ItemRepository;
import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.ports.out.RegisterItemOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterItemAdapter implements RegisterItemOutputPort {

  private final ItemRepository itemRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public Item execute(Item item) {
    var itemEntity = modelMapper.map(item, ItemEntity.class);
    return modelMapper.map(itemRepository.save(itemEntity), Item.class);
  }
}
