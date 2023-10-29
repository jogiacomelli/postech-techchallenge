package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Item;

public interface EditItemOutputPort {
    void execute(Integer id, Item item);
}
