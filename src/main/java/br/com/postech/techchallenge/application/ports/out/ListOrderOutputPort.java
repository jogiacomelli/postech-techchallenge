package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Order;

import java.util.List;

public interface ListOrderOutputPort {
    List<Order> execute();
}
