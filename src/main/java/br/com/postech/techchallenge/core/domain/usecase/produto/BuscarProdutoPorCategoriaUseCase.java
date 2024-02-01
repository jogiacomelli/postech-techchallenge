package br.com.postech.techchallenge.core.domain.usecase.produto;

import br.com.postech.techchallenge.core.domain.entity.Produto;
import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import br.com.postech.techchallenge.core.gateway.ProdutoGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BuscarProdutoPorCategoriaUseCase {

    ProdutoGateway produtoGateway;
    public List<Produto> execute(Categoria categoria) {
        try {
            return produtoGateway.listByCategoria(categoria);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid item type.");
        }
    }
}
