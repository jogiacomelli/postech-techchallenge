package br.com.postech.techchallenge.external.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.postech.techchallenge.adapters.controllers.PedidoController;
import br.com.postech.techchallenge.application.dto.PedidoDTO;
import br.com.postech.techchallenge.domain.enums.StatusPedido;
import br.com.postech.techchallenge.domain.model.Pedido;

import java.util.List;

@RestController
@RequestMapping("/techchallenge/pedido")
public class PedidoApi {

    private final PedidoController controller;

    public PedidoApi(PedidoController controller) {
        this.controller = controller;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        return controller.createPedido(pedidoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        return controller.updatePedido(id, pedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        return controller.getPedidoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        return controller.deletePedido(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        return controller.getAllPedidos();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Pedido>> getPedidosByStatus(@PathVariable StatusPedido status) {
        return controller.getPedidosByStatus(status);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<PedidoDTO>> getPedidosAtivos() {
        return controller.getPedidosAtivos();
    }
}
