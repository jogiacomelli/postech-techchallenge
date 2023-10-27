package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.entity.ClientEntity;
import br.com.postech.techchallenge.adapters.out.database.repository.ClientRepository;
import br.com.postech.techchallenge.application.core.domain.Client;
import br.com.postech.techchallenge.application.ports.out.RegisterClientOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterClientAdapter implements RegisterClientOutputPort {

  private final ClientRepository clientRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public void execute(Client client) {
    var clientEntity = modelMapper.map(client, ClientEntity.class);
    clientRepository.save(clientEntity);
  }
}
