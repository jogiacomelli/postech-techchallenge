package br.com.postech.techchallenge.adapters.out;

import br.com.postech.techchallenge.adapters.out.database.repository.ClientRepository;
import br.com.postech.techchallenge.application.ports.out.VerifyClientRegistrationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerifyClientRegistrationAdapter implements VerifyClientRegistrationOutputPort {

  private final ClientRepository clientRepository;

  @Override
  public Boolean execute(String cpf) {
    return clientRepository.existsById(cpf);
  }
}
