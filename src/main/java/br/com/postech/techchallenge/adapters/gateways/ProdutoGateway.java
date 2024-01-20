package br.com.postech.techchallenge.adapters.gateways;

import java.util.List;

import br.com.postech.techchallenge.domain.enums.Categoria;
import br.com.postech.techchallenge.domain.model.Produto;

public interface ProdutoGateway {
    Produto saveProduto(Produto produto);
    Produto updateProduto(Long id, Produto produto);
    Produto findProdutoById(Long id);
    boolean deleteProduto(Long id);
    List<Produto> listAllProdutos();
    List<Produto> listByCategoria(Categoria categoria);
}
