package br.com.postech.techchallenge.infra.controller;

import br.com.postech.techchallenge.core.domain.entity.Pedido;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;
import br.com.postech.techchallenge.core.domain.usecase.pedido.*;
import br.com.postech.techchallenge.core.gateway.PedidoGateway;
import br.com.postech.techchallenge.core.repository.PedidoRepository;
import br.com.postech.techchallenge.core.repository.ProdutoRepository;
import br.com.postech.techchallenge.infra.api.dto.PedidoDTO;
import br.com.postech.techchallenge.infra.api.dto.PedidoStatusDTO;
import br.com.postech.techchallenge.infra.api.request.OrderCreationRequest;
import br.com.postech.techchallenge.infra.gateway.PedidoGatewayImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PedidoController {

    private final CreateOrderUseCase createOrderUseCase;
    private final ListOrderUseCase listOrderUseCase;
    private final UpdateStatusPedidoUseCase updateStatusPedidoUseCase;
    private final ListStatusPedidoByIdUseCase listStatusPedidoByIdUseCase;
    private final GetPedidoByIdUseCase getPedidoByIdUseCase;
    private final ModelMapper modelMapper;

    public PedidoController(PedidoRepository pedidoRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        PedidoGateway pedidoGateway = new PedidoGatewayImpl(pedidoRepository);
        this.createOrderUseCase = new CreateOrderUseCase(pedidoGateway);
        this.listOrderUseCase = new ListOrderUseCase(pedidoGateway);
        this.updateStatusPedidoUseCase = new UpdateStatusPedidoUseCase(pedidoGateway);
        this.listStatusPedidoByIdUseCase = new ListStatusPedidoByIdUseCase(pedidoGateway);
        this.getPedidoByIdUseCase = new GetPedidoByIdUseCase(pedidoGateway);
    }

    public ResponseEntity<PedidoDTO> createPedido(@Valid OrderCreationRequest pedidoRequest) {
        Pedido toCreate = modelMapper.map(pedidoRequest, Pedido.class);
        Pedido createdPedido = createOrderUseCase.execute(toCreate);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(createdPedido, PedidoDTO.class));
    }

    public ResponseEntity<PedidoDTO> updatePedido(Long id, StatusPedido statusPedido) {
        try {
            Pedido updatedPedido = updateStatusPedidoUseCase.execute(id, statusPedido);
            return ResponseEntity.ok(
                    modelMapper.map(updatedPedido, PedidoDTO.class)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<PedidoDTO>> getAllPedidos() { // TODO adicionar paginacão? Ordenar
        List<Pedido> pedidos = listOrderUseCase.execute();
        return ResponseEntity.ok(
                pedidos.stream()
                        .map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
                        .toList()
        );
    }

    public ResponseEntity<PedidoStatusDTO> getStatusPedido(Long idPedido) {
        try {
            Pedido pedido = listStatusPedidoByIdUseCase.execute(idPedido);
            if (pedido != null) {
                return ResponseEntity.ok(new PedidoStatusDTO(idPedido, pedido.getStatus()));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<PedidoDTO> getPedidoById(Long idPedido) {
        try {
            Pedido pedido = getPedidoByIdUseCase.execute(idPedido);
            if (pedido != null) {
                return ResponseEntity.ok(modelMapper.map(pedido, PedidoDTO.class));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
