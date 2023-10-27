package br.com.postech.techchallenge.application.core.usecase;

import br.com.postech.techchallenge.application.core.domain.Client;
import br.com.postech.techchallenge.application.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.application.ports.in.SearchClientByCpfInputPort;
import br.com.postech.techchallenge.application.ports.out.SearchClientByCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchClientByCpfUseCase implements SearchClientByCpfInputPort {

  private final SearchClientByCpfOutputPort searchClientByCpfOutputPort;

  @Override
  public Client execute(String cpf) {
    return searchClientByCpfOutputPort.execute(cpf)
        .orElseThrow(() -> new NotFoundException(String.format("Client with cpf %s not found", cpf)));
  }
}
