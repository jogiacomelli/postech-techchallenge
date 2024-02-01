package br.com.postech.techchallenge.infra.controller;

import br.com.postech.techchallenge.core.domain.entity.Cliente;
import br.com.postech.techchallenge.core.domain.usecase.cliente.DeleteClientUseCase;
import br.com.postech.techchallenge.core.domain.usecase.cliente.RegisterClientUseCase;
import br.com.postech.techchallenge.core.domain.usecase.cliente.SearchClientByCpfUseCase;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.gateway.ClienteGateway;
import br.com.postech.techchallenge.core.repository.ClienteRepository;
import br.com.postech.techchallenge.infra.api.dto.ClienteDTO;
import br.com.postech.techchallenge.infra.gateway.ClienteGatewayImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ClienteController {

    private final RegisterClientUseCase registerClientUseCase;
    private final SearchClientByCpfUseCase searchClientByCpfUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final ModelMapper modelMapper;

    public ClienteController(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        ClienteGateway clienteGateway = new ClienteGatewayImpl(clienteRepository);
        this.registerClientUseCase = new RegisterClientUseCase(clienteGateway);
        this.searchClientByCpfUseCase = new SearchClientByCpfUseCase(clienteGateway);
        this.deleteClientUseCase = new DeleteClientUseCase(clienteGateway);
    }

    public ResponseEntity<ClienteDTO> createCliente(ClienteDTO clienteDTO) {
        Cliente toRegister = modelMapper.map(clienteDTO, Cliente.class);
        Cliente createdCliente = registerClientUseCase.execute(toRegister);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        modelMapper.map(createdCliente, ClienteDTO.class)
                );
    }

    public ResponseEntity<ClienteDTO> getClienteByCpf(String cpf) {
        try {
            Cliente cliente = searchClientByCpfUseCase.execute(cpf);
            return ResponseEntity.ok(
                        modelMapper.map(cliente, ClienteDTO.class)
                );
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Void> deleteCliente(String cpf) {
        try {
            deleteClientUseCase.execute(cpf);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}