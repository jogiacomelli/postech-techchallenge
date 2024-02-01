package br.com.postech.techchallenge.infra.api.response;

import br.com.postech.techchallenge.core.domain.entity.enums.Categoria;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Categoria type;
}
