package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Item;

public interface EditItemInputPort {
    void execute(Integer id, Item item);
}
