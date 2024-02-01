package br.com.postech.techchallenge.infra.repository.jpa;

import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import br.com.postech.techchallenge.infra.repository.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoJPARepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findByType(Categoria categoria);
}
