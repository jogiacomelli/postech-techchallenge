package br.com.postech.techchallenge.application.dto;

import java.math.BigDecimal;

import br.com.postech.techchallenge.domain.enums.Categoria;
import br.com.postech.techchallenge.domain.model.Produto;

public record ProdutoDTO(Long id, String nome, String descricao, BigDecimal preco, Categoria categoria) {
    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.descricao, this.preco, this.categoria);
    }
}