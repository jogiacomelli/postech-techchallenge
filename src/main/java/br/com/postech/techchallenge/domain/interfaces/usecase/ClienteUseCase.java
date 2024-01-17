package br.com.postech.techchallenge.domain.interfaces.usecase;
import java.util.List;

import br.com.postech.techchallenge.application.dto.ClienteDTO;
import br.com.postech.techchallenge.domain.valuesObjects.ValidadorCPF;

public interface ClienteUseCase {

    ClienteDTO getClienteById(Long id);

    List<ClienteDTO> getAllClientes();

    ClienteDTO createCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    boolean deleteCliente(Long id);

    ClienteDTO getClienteByCPF(String cpf);

}