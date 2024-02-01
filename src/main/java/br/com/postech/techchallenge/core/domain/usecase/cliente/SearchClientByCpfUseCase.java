package br.com.postech.techchallenge.core.domain.usecase.cliente;

import br.com.postech.techchallenge.core.domain.entity.Cliente;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.gateway.ClienteGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchClientByCpfUseCase {

  private final ClienteGateway clienteGateway;

  public Cliente execute(String cpf) {
    return clienteGateway.findByCpf(cpf)
        .orElseThrow(() -> new NotFoundException(String.format("Client with cpf %s not found", cpf)));
  }
}
