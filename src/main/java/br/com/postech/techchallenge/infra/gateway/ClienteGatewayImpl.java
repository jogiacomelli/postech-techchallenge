package br.com.postech.techchallenge.infra.gateway;

import br.com.postech.techchallenge.core.domain.entity.Cliente;
import br.com.postech.techchallenge.core.gateway.ClienteGateway;
import br.com.postech.techchallenge.core.repository.ClienteRepository;

import java.util.Optional;

public class ClienteGatewayImpl implements ClienteGateway {

    private final ClienteRepository clienteRepository;

    public ClienteGatewayImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente saveCliente(Cliente clienteDTO) {
        return this.clienteRepository.saveCliente(clienteDTO);
    }
    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        return this.clienteRepository.findByCpf(cpf);
    }

    @Override
    public void deleteCliente(String cpf) {
        clienteRepository.deleteCliente(cpf);
    }
}
