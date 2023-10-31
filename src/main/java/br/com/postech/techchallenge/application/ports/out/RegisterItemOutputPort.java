package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Item;

public interface RegisterItemOutputPort {
  Item execute(Item item);
}
