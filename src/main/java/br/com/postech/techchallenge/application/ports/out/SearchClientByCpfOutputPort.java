package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Client;
import java.util.Optional;

public interface SearchClientByCpfOutputPort {
  Optional<Client> execute(String cpf);

}
