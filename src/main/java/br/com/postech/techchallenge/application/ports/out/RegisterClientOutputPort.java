package br.com.postech.techchallenge.application.ports.out;

import br.com.postech.techchallenge.application.core.domain.Client;

public interface RegisterClientOutputPort {
  void execute(Client client);

}
