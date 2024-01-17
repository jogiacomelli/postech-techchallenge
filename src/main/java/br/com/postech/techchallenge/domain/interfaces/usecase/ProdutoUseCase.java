package br.com.postech.techchallenge.domain.interfaces.usecase;


import java.util.List;

import br.com.postech.techchallenge.application.dto.ProdutoDTO;
import br.com.postech.techchallenge.domain.enums.Categoria;

public interface ProdutoUseCase {

    ProdutoDTO getProdutoById(Long id);

    ProdutoDTO createProduto(ProdutoDTO produtoDTO);

    ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO);

    boolean deleteProduto(Long id);
    List<ProdutoDTO> getAllProdutos();

    List<ProdutoDTO> getProdutosByCategoria(Categoria categoria);

}
