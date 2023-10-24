package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Client;

public interface SearchClientByCpfInputPort {
  Client execute(String cpf);
}
