package br.com.postech.techchallenge.core.gateway;

import br.com.postech.techchallenge.core.domain.entity.Produto;
import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;

import java.util.List;

public interface ProdutoGateway {
    Produto saveProduto(Produto produto);
    Produto updateProduto(Long id, Produto produto);
    void deleteProduto(Long id);
    List<Produto> listByCategoria(Categoria categoria);
}
