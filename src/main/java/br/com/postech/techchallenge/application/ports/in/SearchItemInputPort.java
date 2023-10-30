package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Item;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface SearchItemInputPort {
    List<Item> execute(@NotNull String type);
}
