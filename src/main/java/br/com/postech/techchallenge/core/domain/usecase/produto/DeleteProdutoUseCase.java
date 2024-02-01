package br.com.postech.techchallenge.core.domain.usecase.produto;

import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.gateway.ProdutoGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProdutoUseCase {
  private final ProdutoGateway produtoGateway;
  public void execute(Long id) {
    try {
      produtoGateway.deleteProduto(id);
    } catch (IllegalArgumentException e) {
      throw new NotFoundException("Produto não encontrado.");
    }
  }
}
