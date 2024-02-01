package br.com.postech.techchallenge.infra.repository.jpa;

import br.com.postech.techchallenge.infra.repository.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoJPARepository extends JpaRepository<PedidoEntity, Long> {


}
