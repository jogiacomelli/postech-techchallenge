package br.com.postech.techchallenge.adapters.out.database.repository;

import br.com.postech.techchallenge.adapters.out.database.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {
  boolean existsByCpf(String cpf);

}
