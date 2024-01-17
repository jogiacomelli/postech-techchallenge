package br.com.postech.techchallenge.application.dto;

import java.math.BigDecimal;


public record ComboDTO(
        Long id,
        ProdutoDTO lanche,
        ProdutoDTO acompanhamento,
        ProdutoDTO bebida,
        ProdutoDTO sobremesa,
        Integer quantidade,
        BigDecimal valorUnitario,
        BigDecimal valorTotal
) {}
