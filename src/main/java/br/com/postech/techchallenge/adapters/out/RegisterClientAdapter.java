package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.exceptions.ConflictException;
import br.com.postech.techchallenge.adapters.out.database.entity.ClientEntity;
import br.com.postech.techchallenge.adapters.out.database.repository.ClientRepository;
import br.com.postech.techchallenge.application.core.domain.Client;
import br.com.postech.techchallenge.application.ports.out.RegisterClientOutputPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterClientAdapter implements RegisterClientOutputPort {

  private final ClientRepository clientRepository;
  private final ModelMapper modelMapper;

  @Override
  public void execute(Client client) {
    var clientEntity = modelMapper.map(client, ClientEntity.class);
    var existsById = clientRepository.existsById(clientEntity.getCpf());

    if(existsById){
      throw new ConflictException("Cliente com CPF %s já está cadastrado".formatted(clientEntity.getCpf()));
    }

    clientRepository.save(clientEntity);
  }
}
