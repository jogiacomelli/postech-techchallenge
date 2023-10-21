package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Client;
import br.com.postech.techchallenge.application.ports.in.RegisterClientInputPort;
import br.com.postech.techchallenge.application.ports.out.RegisterClientOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterClientUseCase implements RegisterClientInputPort {

  private final RegisterClientOutputPort registerClientOutputPort;

  @Override
  public void execute(Client client) {
    registerClientOutputPort.execute(client);
  }


    }
