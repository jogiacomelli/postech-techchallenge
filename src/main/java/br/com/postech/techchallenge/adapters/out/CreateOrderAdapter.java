//package br.com.postech.techchallenge.adapters.out;
//
//import br.com.postech.techchallenge.adapters.out.database.entity.OrderEntity;
//import br.com.postech.techchallenge.adapters.out.database.entity.OrderItemEntity;
//import br.com.postech.techchallenge.adapters.out.database.repository.ItemRepository;
//import br.com.postech.techchallenge.adapters.out.database.repository.OrderRepository;
//import br.com.postech.techchallenge.application.core.domain.Order;
//import br.com.postech.techchallenge.application.core.domain.OrderItem;
//import br.com.postech.techchallenge.application.ports.out.CreateOrderOutputPort;
//import jakarta.transaction.Transactional;
//import java.math.BigDecimal;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class CreateOrderAdapter implements CreateOrderOutputPort {
//
//  private final OrderRepository orderRepository;
//  private final ItemRepository itemRepository;
//  private final ModelMapper modelMapper;
//
//  @Override
//  @Transactional
//  public Order execute(Order order) {
//
//    var orderEntity = new OrderEntity();
//    if (order.isOrderWithIdentification()) {
//      orderEntity.setCpf(order.getCpf());
//    }
//
//    order.getOrderItems().forEach(orderItem -> orderEntity.addOrderItem(buildOrderItemEntity(orderItem)));
//    return modelMapper.map(orderRepository.save(orderEntity), Order.class);
//  }
//
//  private OrderItemEntity buildOrderItemEntity(OrderItem orderItem) {
//
//    var item = itemRepository.findById(orderItem.getItemId())
//        .orElseThrow(IllegalArgumentException::new);
//
//    var itemQuantity = new BigDecimal(orderItem.getQuantity());
//    var itemOrderPrice = item.getPrice().multiply(itemQuantity);
//
//    return OrderItemEntity.builder()
//        .item(item)
//        .quantity(orderItem.getQuantity())
//        .totalPrice(itemOrderPrice).build();
//
//  }
//}
