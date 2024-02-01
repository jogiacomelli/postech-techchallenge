package br.com.postech.techchallenge.infra.repository.jpa;

import br.com.postech.techchallenge.infra.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJPARepository extends JpaRepository<ClienteEntity, String> {
  boolean existsByCpf(String cpf);

}
