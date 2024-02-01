package br.com.postech.techchallenge.infra.api.response;

import br.com.postech.techchallenge.core.domain.entity.ItemPedido;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {
    private Integer id;
    private String cpf;
    private List<ItemPedido> itemPedidos;
    private StatusPedido status;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime orderDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime lastUpdateDate;
}
