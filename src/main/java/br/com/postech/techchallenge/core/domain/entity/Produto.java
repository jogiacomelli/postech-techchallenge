package br.com.postech.techchallenge.core.domain.entity;

import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Produto {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Categoria type;
}