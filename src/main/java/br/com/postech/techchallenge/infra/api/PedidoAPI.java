package br.com.postech.techchallenge.infra.api;

import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;
import br.com.postech.techchallenge.core.repository.PedidoRepository;
import br.com.postech.techchallenge.core.repository.ProdutoRepository;
import br.com.postech.techchallenge.infra.api.dto.PedidoDTO;
import br.com.postech.techchallenge.infra.api.dto.PedidoStatusDTO;
import br.com.postech.techchallenge.infra.api.request.OrderCreationRequest;
import br.com.postech.techchallenge.infra.api.response.OrderResponse;
import br.com.postech.techchallenge.infra.controller.PedidoController;
import jakarta.validation.Valid;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/techchallenge/orders")
public class PedidoAPI {
  private final PedidoController pedidoController;
  private final ModelMapper modelMapper;
  public PedidoAPI(PedidoRepository pedidoRepository, ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
      this.pedidoController = new PedidoController(pedidoRepository, modelMapper);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<PedidoDTO> orderCreation(@Valid @RequestBody final OrderCreationRequest orderCreationRequest) {
    log.info("Order creation request: {} received", orderCreationRequest);
    return this.pedidoController.createPedido(orderCreationRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<PedidoDTO>> listAllOrders() {
    log.info("Get all orders request received");
    return pedidoController.getAllPedidos();
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public OrderResponse updateOrderStatus(@RequestParam final Long id, @RequestParam final String status) {
      log.info("Update order status request received");
      var order = pedidoController.updatePedido(id, StatusPedido.valueOf(status));
      return modelMapper.map(order, OrderResponse.class);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
    return pedidoController.getPedidoById(id);
  }

  @GetMapping("/status/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<PedidoStatusDTO> getStatusPedidoById(@PathVariable Long id) {
    return pedidoController.getStatusPedido(id);
  }

}
