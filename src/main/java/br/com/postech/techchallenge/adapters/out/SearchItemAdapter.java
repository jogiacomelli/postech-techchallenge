package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.repository.ItemRepository;
import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.core.domain.enums.ItemType;
import br.com.postech.techchallenge.application.ports.out.SearchItemOutputPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SearchItemAdapter implements SearchItemOutputPort {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    @Override
    @Transactional
    public List<Item> execute(ItemType type) {
        var items = itemRepository.findByType(type);
        return items.stream()
                .map(itemEntity -> modelMapper.map(itemEntity, Item.class))
                .toList();
    }
}
