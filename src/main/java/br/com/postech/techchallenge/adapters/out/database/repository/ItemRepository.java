package br.com.postech.techchallenge.adapters.out.database.repository;

import br.com.postech.techchallenge.adapters.out.database.entity.ItemEntity;
import br.com.postech.techchallenge.application.core.domain.enums.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    List<ItemEntity> findByType(ItemType type);
}
