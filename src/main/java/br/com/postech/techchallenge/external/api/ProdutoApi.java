package br.com.postech.techchallenge.external.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.postech.techchallenge.adapters.controllers.ProdutoController;
import br.com.postech.techchallenge.application.dto.ProdutoDTO;
import br.com.postech.techchallenge.domain.enums.Categoria;

import java.util.List;

@RestController
@RequestMapping("/techchallenge/produtos")
public class ProdutoApi {

    private final ProdutoController produtoController;

    public ProdutoApi(ProdutoController produtoController) {
        this.produtoController = produtoController;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoController.createProduto(produtoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        return produtoController.updateProduto(id, produtoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id) {
        return produtoController.getProdutoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        return produtoController.deleteProduto(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        return produtoController.getAllProdutos();
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProdutoDTO>> getProdutosByCategoria(@PathVariable Categoria categoria) {
        return produtoController.getProdutosByCategoria(categoria);
    }
}
