package br.com.postech.techchallenge.infra.repository;

import br.com.postech.techchallenge.core.domain.entity.ItemPedido;
import br.com.postech.techchallenge.core.domain.entity.Pedido;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPagamento;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPedido;
import br.com.postech.techchallenge.core.exceptions.NotFoundException;
import br.com.postech.techchallenge.core.repository.PedidoRepository;
import br.com.postech.techchallenge.infra.repository.entity.ProdutoPedidoEntity;
import br.com.postech.techchallenge.infra.repository.entity.PedidoEntity;
import br.com.postech.techchallenge.infra.repository.jpa.PedidoJPARepository;
import br.com.postech.techchallenge.infra.repository.jpa.ProdutoJPARepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PedidoRepositoryImpl implements PedidoRepository {

    private final ProdutoJPARepository itemRepository;
    private final PedidoJPARepository pedidoJPARepository;
    private final ModelMapper modelMapper;

    public PedidoRepositoryImpl(ProdutoJPARepository itemRepository, PedidoJPARepository pedidoJPARepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.pedidoJPARepository = pedidoJPARepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Pedido findPedidoById(Long id) {
        var pedido = pedidoJPARepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(pedido, Pedido.class);
    }

    @Override
    public List<Pedido> findAllPedidos() {
        return pedidoJPARepository.findAll()
                .stream()
                .map(pedidoEntity -> modelMapper.map(pedidoEntity, Pedido.class)).toList();
    }

    @Override
    public Pedido createPedido(Pedido pedido) {
        var pedidoEntity = new PedidoEntity();
        if (pedido.isOrderWithIdentification()) {
            pedidoEntity.setCpf(pedido.getCpf());
        }

        pedido.getItemPedidos().forEach(orderItem -> pedidoEntity.addOrderItem(buildOrderItemEntity(orderItem)));

        return modelMapper.map(pedidoJPARepository.save(pedidoEntity), Pedido.class);
    }

    @Override
    public Pedido updatePedido(Long id, Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoJPARepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));

        pedidoEntity.setStatus(StatusPedido.valueOf(pedido.getStatus().name()));
        pedido.getItemPedidos().forEach(orderItem -> pedidoEntity.addOrderItem(buildOrderItemEntity(orderItem)));


        return this.modelMapper.map(pedidoJPARepository.save(pedidoEntity), Pedido.class);
    }

    @Override
    public void updatePagamentoToPedido(Long idPedido, StatusPagamento statusPagamento) {
        this.pedidoJPARepository.findById(idPedido).ifPresentOrElse(pedidoEntity -> {
            pedidoEntity.getPayment().setStatus(statusPagamento);
            pedidoJPARepository.save(pedidoEntity);
        }, () -> {
            throw new IllegalArgumentException("Pedido não encontrado");
        });
    }

    private ProdutoPedidoEntity buildOrderItemEntity(ItemPedido itemPedido) {

        var item = itemRepository.findById(itemPedido.getItemId())
                .orElseThrow(IllegalArgumentException::new);

        var itemQuantity = new BigDecimal(itemPedido.getQuantity());
        var itemOrderPrice = item.getPrice().multiply(itemQuantity);

        return ProdutoPedidoEntity.builder()
                .item(item)
                .quantity(itemPedido.getQuantity())
                .totalPrice(itemOrderPrice).build();
    }


}
