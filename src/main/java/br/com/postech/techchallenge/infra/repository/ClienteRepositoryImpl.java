package br.com.postech.techchallenge.infra.repository;

import br.com.postech.techchallenge.core.domain.entity.Cliente;
import br.com.postech.techchallenge.core.repository.ClienteRepository;
import br.com.postech.techchallenge.infra.repository.entity.ClienteEntity;
import br.com.postech.techchallenge.infra.repository.jpa.ClienteJPARepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteRepositoryImpl implements ClienteRepository {
    private final ClienteJPARepository clienteJPARepository;
    private final ModelMapper modelMapper;
    public ClienteRepositoryImpl(ClienteJPARepository clienteJPARepository, ModelMapper modelMapper) {
        this.clienteJPARepository = clienteJPARepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        ClienteEntity toSave = modelMapper.map(cliente, ClienteEntity.class);

        return modelMapper.map(
                clienteJPARepository.save(toSave), Cliente.class
        );
    }

    @Override
    public void deleteCliente(String id) {
        clienteJPARepository.findById(id).ifPresent(
                clienteJPARepository::delete
        );
    }

    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        Optional<ClienteEntity> clienteEntity = clienteJPARepository.findById(cpf);

        return clienteEntity.map(
                entity -> modelMapper.map(entity, Cliente.class));

    }
}