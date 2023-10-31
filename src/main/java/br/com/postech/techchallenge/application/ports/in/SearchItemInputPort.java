package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Item;

import br.com.postech.techchallenge.application.core.domain.enums.ItemType;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SearchItemInputPort {
    List<Item> execute(@NotNull ItemType type);
}
