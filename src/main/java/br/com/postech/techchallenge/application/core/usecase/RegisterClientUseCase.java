package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Client;
import br.com.postech.techchallenge.application.core.exceptions.ConflictException;
import br.com.postech.techchallenge.application.ports.in.RegisterClientInputPort;
import br.com.postech.techchallenge.application.ports.out.RegisterClientOutputPort;
import br.com.postech.techchallenge.application.ports.out.VerifyClientRegistrationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterClientUseCase implements RegisterClientInputPort {

  private final RegisterClientOutputPort registerClientOutputPort;
  private final VerifyClientRegistrationOutputPort verifyClientRegistrationOutputPort;

  @Override
  public void execute(Client client) {
    var existsById = verifyClientRegistrationOutputPort.execute(client.getCpf());
    if (existsById) {
      throw new ConflictException("Cliente com CPF %s já está cadastrado".formatted(client.getCpf()));
    }
    registerClientOutputPort.execute(client);

  }
}
