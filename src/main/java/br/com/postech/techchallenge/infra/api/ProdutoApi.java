package br.com.postech.techchallenge.infra.api;


import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import br.com.postech.techchallenge.core.repository.ProdutoRepository;
import br.com.postech.techchallenge.infra.api.dto.ProdutoDTO;
import br.com.postech.techchallenge.infra.controller.ProdutoController;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/techchallenge/produtos")
public class ProdutoApi {

    private final ProdutoController produtoController;
    public ProdutoApi(ProdutoRepository repository, ModelMapper modelMapper) {
        this.produtoController = new ProdutoController(repository, modelMapper);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoController.createProduto(produtoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        return produtoController.updateProduto(id, produtoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        return produtoController.deleteProduto(id);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listProdutosPorCategoria(@RequestParam Categoria categoria) {
        return produtoController.getProdutosByCategoria(categoria);
    }

}
