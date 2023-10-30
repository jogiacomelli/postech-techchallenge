package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Order;

import java.util.List;

public interface ListOrderInputPort {
    List<Order> execute();
}
