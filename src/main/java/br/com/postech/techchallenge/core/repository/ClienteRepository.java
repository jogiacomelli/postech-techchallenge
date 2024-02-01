package br.com.postech.techchallenge.core.repository;

import br.com.postech.techchallenge.core.domain.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository { // TODO CRIAR BEANS
    Cliente saveCliente(Cliente clienteDTO);
    void deleteCliente(String id);
    Optional<Cliente> findByCpf(String cpf);
}