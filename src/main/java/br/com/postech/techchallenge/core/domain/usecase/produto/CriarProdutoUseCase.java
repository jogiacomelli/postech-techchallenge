package br.com.postech.techchallenge.core.domain.usecase.produto;

import br.com.postech.techchallenge.core.domain.entity.Produto;
import br.com.postech.techchallenge.core.gateway.ProdutoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarProdutoUseCase {

  private final ProdutoGateway produtoGateway;

  public Produto execute(Produto produto) {
    return produtoGateway.saveProduto(produto);
  }
}
