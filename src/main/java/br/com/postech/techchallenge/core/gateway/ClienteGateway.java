package br.com.postech.techchallenge.core.gateway;

import br.com.postech.techchallenge.core.domain.entity.Cliente;

import java.util.Optional;

public interface ClienteGateway {
    Cliente saveCliente(Cliente clienteDTO);
    Optional<Cliente> findByCpf(String cpf);

    void deleteCliente(String cpf);
}