package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.repository.ClientRepository;
import br.com.postech.techchallenge.application.core.domain.Client;
import br.com.postech.techchallenge.application.ports.out.SearchClientByCpfOutputPort;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchClientByCpfAdapter implements SearchClientByCpfOutputPort {

  private final ClientRepository clientRepository;
  private final ModelMapper modelMapper;

  @Override
  public Optional<Client> execute(String cpf) {
    return clientRepository.findById(cpf)
        .map(clientEntity -> modelMapper.map(clientEntity, Client.class));
  }
}
