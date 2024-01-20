package br.com.postech.techchallenge.application.usecases;


import java.util.List;
import java.util.stream.Collectors;

import  br.com.postech.techchallenge.adapters.gateways.ProdutoGateway;
import  br.com.postech.techchallenge.adapters.mappers.ProdutoMapper;
import  br.com.postech.techchallenge.application.dto.ProdutoDTO;
import  br.com.postech.techchallenge.domain.enums.Categoria;
import  br.com.postech.techchallenge.domain.interfaces.usecase.ProdutoUseCase;
import  br.com.postech.techchallenge.domain.model.Produto;

public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoGateway produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoUseCaseImpl(ProdutoGateway produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) {
        Produto produto = produtoDTO.toProduto();
        produto = produtoRepository.saveProduto(produto);
        return produtoMapper.domainToDto(produto);
    }

    @Override
    public ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoDTO.toProduto();
        produto = produtoRepository.updateProduto(id, produto);
        return produto != null ? produtoMapper.domainToDto(produto) : null;
    }

    @Override
    public ProdutoDTO getProdutoById(Long id) {
        Produto produto = produtoRepository.findProdutoById(id);
        return produto != null ? produtoMapper.domainToDto(produto) : null;
    }

    @Override
    public boolean deleteProduto(Long id) {
        return produtoRepository.deleteProduto(id);
    }

    @Override
    public List<ProdutoDTO> getAllProdutos() {
        return produtoRepository.listAllProdutos().stream()
                .map(produtoMapper::domainToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDTO> getProdutosByCategoria(Categoria categoria) {
        return produtoRepository.listByCategoria(categoria).stream()
                .map(produtoMapper::domainToDto)
                .collect(Collectors.toList());
    }
}