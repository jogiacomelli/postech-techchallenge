package br.com.postech.techchallenge.application.ports.in;

import br.com.postech.techchallenge.application.core.domain.Client;

public interface RegisterClientInputPort {
  void execute(Client client);

}
