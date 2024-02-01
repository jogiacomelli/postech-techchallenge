package br.com.postech.techchallenge.infra.repository.jpa;

import br.com.postech.techchallenge.infra.repository.entity.ProdutoEntity;
import br.com.postech.techchallenge.infra.repository.entity.ProdutoPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutoJPARepository extends JpaRepository<ProdutoPedidoEntity, Integer> {
  void deleteAllByItem(ProdutoEntity itemEntity);

}
