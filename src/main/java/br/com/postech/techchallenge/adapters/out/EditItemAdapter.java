package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.entity.ItemEntity;
import br.com.postech.techchallenge.adapters.out.database.repository.ItemRepository;
import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.ports.out.EditItemOutputPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
        copyNonNullProperties(item, itemEntity);
        return modelMapper.map(itemRepository.save(itemEntity), Item.class);
    }

    private void copyNonNullProperties(Item item, ItemEntity itemEntity) {
        if(item.getPrice() != null) {
            itemEntity.setPrice(item.getPrice());
        }

        if(item.getDescription() != null) {
            itemEntity.setDescription(item.getDescription());
        }

        if(item.getName() != null) {
            itemEntity.setName(item.getName());
        }

        if(item.getType() != null) {
            itemEntity.setType(item.getType());
        }
    }
}
