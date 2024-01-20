package br.com.postech.techchallenge.adapters.mappers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.postech.techchallenge.application.dto.ComboDTO;
import br.com.postech.techchallenge.application.dto.PedidoDTO;
import br.com.postech.techchallenge.domain.model.Combo;
import br.com.postech.techchallenge.domain.model.Pedido;
import br.com.postech.techchallenge.external.infrastructure.dataBaseEntities.ComboEntity;
import br.com.postech.techchallenge.external.infrastructure.dataBaseEntities.PedidoEntity;

@Component
public class PedidoMapper {

    private final ComboMapper comboMapper;

    public PedidoMapper(ComboMapper comboMapper) {
        this.comboMapper = comboMapper;
    }

    public PedidoEntity domainToEntity(Pedido pedido) {
        List<ComboEntity> comboEntities = pedido.getCombos().stream()
                .map(comboMapper::domainToEntity)
                .collect(Collectors.toList());

        comboEntities.size();

        return new PedidoEntity(
                pedido.getId(),
                pedido.getIdCliente(),
                comboEntities,
                pedido.getValorTotal(),
                pedido.getStatus(),
                pedido.isPago(),
                pedido.getDataCadastro(),
                pedido.getDataAlteracao()
        );
    }

    public PedidoDTO domainToDto(Pedido pedido) {
        List<ComboDTO> comboDTOs = pedido.getCombos().stream()
                .map(comboMapper::domainToDto)
                .collect(Collectors.toList());

        return new PedidoDTO(
                pedido.getId(),
                pedido.getIdCliente(),
                comboDTOs,
                pedido.getValorTotal(),
                pedido.getStatus(),
                pedido.isPago(),
                pedido.getDataCadastro(),
                pedido.getDataAlteracao()
        );
    }

    public Pedido dtoToDomain(PedidoDTO pedidoDTO) {
        List<Combo> combos = pedidoDTO.combos().stream()
                .map(comboMapper::dtoToDomain)
                .collect(Collectors.toList());

        combos.size();

        return new Pedido(
                pedidoDTO.id(),
                pedidoDTO.idCliente(),
                combos,
                pedidoDTO.valorTotal(),
                pedidoDTO.status(),
                pedidoDTO.pago(),
                pedidoDTO.dataCadastro(),
                pedidoDTO.dataAlteracao()
        );
    }

    public Pedido entityToDomain(PedidoEntity pedidoEntity) {
        List<Combo> combos = pedidoEntity.getCombos().stream()
                .map(comboMapper::entityToDomain)
                .collect(Collectors.toList());

        return new Pedido(
                pedidoEntity.getId(),
                pedidoEntity.getIdCliente(),
                combos,
                pedidoEntity.getValorTotal(),
                pedidoEntity.getStatus(),
                pedidoEntity.isPago(),
                pedidoEntity.getDataCadastro(),
                pedidoEntity.getDataAlteracao()
        );
    }
}
