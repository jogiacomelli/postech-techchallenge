package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.core.domain.enums.ItemType;
import br.com.postech.techchallenge.application.ports.in.SearchItemInputPort;
import br.com.postech.techchallenge.application.ports.out.SearchItemOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@AllArgsConstructor
public class SearchItemUseCase implements SearchItemInputPort {

    SearchItemOutputPort searchItemOutputPort;
    @Override
    public List<Item> execute(@NotNull ItemType type) {
        try {
            return searchItemOutputPort.execute(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid item type.");
        }
    }
}
