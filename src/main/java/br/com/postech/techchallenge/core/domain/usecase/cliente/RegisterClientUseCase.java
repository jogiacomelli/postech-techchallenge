package br.com.postech.techchallenge.core.domain.usecase.cliente;

import br.com.postech.techchallenge.core.domain.entity.Cliente;
import br.com.postech.techchallenge.core.exceptions.ConflictException;
import br.com.postech.techchallenge.core.gateway.ClienteGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterClientUseCase {

  private final ClienteGateway clienteGateway;

  public Cliente execute(Cliente cliente) {
    clienteGateway.findByCpf(cliente.getCpf()).ifPresent(
              clienteEncontrado -> {
                throw new ConflictException("Cliente com CPF %s já está cadastrado".formatted(clienteEncontrado.getCpf()));
              });

    return clienteGateway.saveCliente(cliente);
  }
}
