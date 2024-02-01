package br.com.postech.techchallenge.core.repository;


import br.com.postech.techchallenge.core.domain.entity.Produto;
import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;

import java.util.List;

public interface ProdutoRepository {
    Produto saveProduto(Produto produto);
    Produto updateProduto(Produto produto);
    void deleteProduto(Long id);
    List<Produto> listByCategoria(Categoria categoria);

    Produto findById(Long id);
}
