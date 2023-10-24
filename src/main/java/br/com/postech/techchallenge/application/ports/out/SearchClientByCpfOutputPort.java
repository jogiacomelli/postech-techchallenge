package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Client;

public interface SearchClientByCpfOutputPort {
  Client execute(String cpf);

}
