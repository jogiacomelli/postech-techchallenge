package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.core.domain.enums.ItemType;

import java.util.List;

public interface SearchItemOutputPort {
    List<Item> execute(ItemType type);
}
