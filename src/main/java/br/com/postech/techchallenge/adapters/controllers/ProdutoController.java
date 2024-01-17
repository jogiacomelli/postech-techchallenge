package br.com.postech.techchallenge.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.postech.techchallenge.application.dto.ProdutoDTO;
import br.com.postech.techchallenge.domain.enums.Categoria;
import br.com.postech.techchallenge.domain.interfaces.usecase.ProdutoUseCase;

import java.util.List;

@Controller
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    public ResponseEntity<ProdutoDTO> createProduto(ProdutoDTO produtoDTO) {
        ProdutoDTO createdProduto = produtoUseCase.createProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto);
    }

    public ResponseEntity<ProdutoDTO> updateProduto(Long id, ProdutoDTO produtoDTO) {
        try {
            ProdutoDTO updatedProduto = produtoUseCase.updateProduto(id, produtoDTO);
            if (updatedProduto != null) {
                return ResponseEntity.ok(updatedProduto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<ProdutoDTO> getProdutoById(Long id) {
        try {
            ProdutoDTO produto = produtoUseCase.getProdutoById(id);
            if (produto != null) {
                return ResponseEntity.ok(produto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Void> deleteProduto(Long id) {
        try {
            boolean deleted = produtoUseCase.deleteProduto(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        List<ProdutoDTO> produtos = produtoUseCase.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    public ResponseEntity<List<ProdutoDTO>> getProdutosByCategoria(Categoria tipo) {
        List<ProdutoDTO> produtos = produtoUseCase.getProdutosByCategoria(tipo);
        return ResponseEntity.ok(produtos);
    }
}
