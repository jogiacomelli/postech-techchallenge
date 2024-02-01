package br.com.postech.techchallenge.infra.gateway;

import br.com.postech.techchallenge.core.domain.entity.Produto;
import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import br.com.postech.techchallenge.core.gateway.ProdutoGateway;
import br.com.postech.techchallenge.core.repository.ProdutoRepository;

import java.util.List;

public class ProdutoGatewayImpl implements ProdutoGateway {
    ProdutoRepository repository;
    public ProdutoGatewayImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto saveProduto(Produto produto) {
        return repository.saveProduto(produto);
    }

    @Override
    public Produto updateProduto(Long id, Produto produto) {
        return repository.updateProduto(produto);
    }

    @Override
    public void deleteProduto(Long id) {
        repository.deleteProduto(id);
    }

    @Override
    public List<Produto> listByCategoria(Categoria categoria) {
        return repository.listByCategoria(categoria);
    }
}
