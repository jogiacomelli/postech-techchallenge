package br.com.postech.techchallenge.infra.controller;

import br.com.postech.techchallenge.core.domain.entity.Produto;
import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import br.com.postech.techchallenge.core.domain.usecase.produto.BuscarProdutoPorCategoriaUseCase;
import br.com.postech.techchallenge.core.domain.usecase.produto.CriarProdutoUseCase;
import br.com.postech.techchallenge.core.domain.usecase.produto.DeleteProdutoUseCase;
import br.com.postech.techchallenge.core.domain.usecase.produto.EditProdutoUseCase;
import br.com.postech.techchallenge.core.gateway.ProdutoGateway;
import br.com.postech.techchallenge.core.repository.ProdutoRepository;
import br.com.postech.techchallenge.infra.api.dto.ProdutoDTO;
import br.com.postech.techchallenge.infra.gateway.ProdutoGatewayImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProdutoController {

    private final EditProdutoUseCase updateProdutoUseCase;
    private final CriarProdutoUseCase registrarProdutoUseCase;
    private final DeleteProdutoUseCase deleteProdutoUseCase;
    private final BuscarProdutoPorCategoriaUseCase buscarProdutoPorCategoriaUseCase;
    private final ModelMapper modelMapper;

    public ProdutoController(ProdutoRepository repository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        ProdutoGateway produtoGateway = new ProdutoGatewayImpl(repository);
        this.updateProdutoUseCase = new EditProdutoUseCase(produtoGateway);
        this.registrarProdutoUseCase = new CriarProdutoUseCase(produtoGateway);
        this.deleteProdutoUseCase = new DeleteProdutoUseCase(produtoGateway);
        this.buscarProdutoPorCategoriaUseCase = new BuscarProdutoPorCategoriaUseCase(produtoGateway);
    }

    public ResponseEntity<ProdutoDTO> createProduto(ProdutoDTO produtoDTO) {
        Produto novoProduto = modelMapper.map(produtoDTO, Produto.class);
        Produto createdProduto = registrarProdutoUseCase.execute(novoProduto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        modelMapper.map(createdProduto, ProdutoDTO.class)
                );
    }

    public ResponseEntity<ProdutoDTO> updateProduto(Long id, ProdutoDTO produtoDTO) {
        try {
            Produto produto = modelMapper.map(produtoDTO, Produto.class);
            Produto updatedProduto = updateProdutoUseCase.execute(id, produto);
            if (updatedProduto != null) {
                return ResponseEntity
                        .ok(
                                modelMapper.map(updatedProduto, ProdutoDTO.class)
                        );
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Void> deleteProduto(Long id) {
        try {
            deleteProdutoUseCase.execute(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<ProdutoDTO>> getProdutosByCategoria(Categoria categoria) {
        try {
            List<Produto> produtos = buscarProdutoPorCategoriaUseCase.execute(categoria);
            return ResponseEntity.ok(
                    produtos.stream().map(produto -> modelMapper.map(produto, ProdutoDTO.class)).toList()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
