package br.com.postech.techchallenge.core.domain.usecase.produto;

import br.com.postech.techchallenge.core.domain.entity.Produto;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.gateway.ProdutoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditProdutoUseCase {
    private final ProdutoGateway produtoGateway;
    public Produto execute(Long id, Produto produto) {
        try {
            return produtoGateway.updateProduto(id, produto);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException("Produto não encontrado!");
        }
    }
}
