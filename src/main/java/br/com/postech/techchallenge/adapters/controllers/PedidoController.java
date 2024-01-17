package br.com.postech.techchallenge.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.postech.techchallenge.application.dto.PedidoDTO;
import br.com.postech.techchallenge.domain.enums.StatusPedido;
import br.com.postech.techchallenge.domain.interfaces.usecase.PedidoUseCase;
import br.com.postech.techchallenge.domain.model.Pedido;

import java.util.List;

@Controller
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    public PedidoController(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO createdPedido = pedidoUseCase.createPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
    }

    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        try {
            PedidoDTO updatedPedido = pedidoUseCase.updatePedido(id, pedidoDTO);
            if (updatedPedido != null) {
                return ResponseEntity.ok(updatedPedido);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        try {
            PedidoDTO pedido = pedidoUseCase.getPedidoById(id);
            if (pedido != null) {
                return ResponseEntity.ok(pedido);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        try {
            boolean deleted = pedidoUseCase.deletePedido(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        List<PedidoDTO> pedidos = pedidoUseCase.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    public ResponseEntity<List<Pedido>> getPedidosByStatus(@PathVariable StatusPedido status) {
        try {
            List<Pedido> pedidos = pedidoUseCase.findPedidosByStatus(status);
            if (!pedidos.isEmpty()) {
                return ResponseEntity.ok(pedidos);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<PedidoDTO>> getPedidosAtivos() {
        try {
            List<PedidoDTO> pedidos = pedidoUseCase.findPedidosAtivos();
            if (!pedidos.isEmpty()) {
                return ResponseEntity.ok(pedidos);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
