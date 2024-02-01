package br.com.postech.techchallenge.infra.repository;

import br.com.postech.techchallenge.core.domain.entity.Produto;
import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import br.com.postech.techchallenge.core.repository.ProdutoRepository;
import br.com.postech.techchallenge.infra.repository.jpa.ProdutoJPARepository;
import br.com.postech.techchallenge.infra.repository.entity.ProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {
    private final ProdutoJPARepository produtoJPARepository;
    private final ModelMapper modelMapper;
    public ProdutoRepositoryImpl(ProdutoJPARepository produtoJPARepository, ModelMapper modelMapper) {
        this.produtoJPARepository = produtoJPARepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Produto saveProduto(Produto produto) {
        ProdutoEntity produtoEntity = modelMapper.map(produto, ProdutoEntity.class);
        return modelMapper.map(
                produtoJPARepository.save(produtoEntity), Produto.class
        );
    }

    @Override
    public Produto updateProduto(Produto produto) {
        ProdutoEntity produtoEntity = modelMapper.map(produto, ProdutoEntity.class);
        return modelMapper.map(
                produtoJPARepository.save(produtoEntity), Produto.class
        );
    }

    @Override
    public void deleteProduto(Long id) {
        produtoJPARepository.findById(id).ifPresent(
                produtoJPARepository::delete
        );
    }

    @Override
    public List<Produto> listByCategoria(Categoria categoria) {
        return produtoJPARepository.findByType(categoria)
                .stream()
                .map(produtoEntity ->
                        modelMapper.map(produtoEntity, Produto.class)
                )
                .toList();

    }

    @Override
    public Produto findById(Long id) {
        return produtoJPARepository.findById(id)
                .map(produtoEntity -> modelMapper.map(produtoEntity, Produto.class))
                .orElse(null);
    }
}
