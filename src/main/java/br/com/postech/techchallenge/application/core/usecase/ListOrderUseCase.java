package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Order;
import br.com.postech.techchallenge.application.ports.in.ListOrderInputPort;
import br.com.postech.techchallenge.application.ports.out.ListOrderOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListOrderUseCase implements ListOrderInputPort {

    private final ListOrderOutputPort listOrderOutputPort;
    @Override
    public List<Order> execute() {
        return listOrderOutputPort.execute();
    }
}
