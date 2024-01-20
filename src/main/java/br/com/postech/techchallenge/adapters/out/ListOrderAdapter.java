//package br.com.postech.techchallenge.adapters.out;
//
//import br.com.postech.techchallenge.adapters.out.database.repository.OrderRepository;
//import br.com.postech.techchallenge.application.core.domain.Order;
//import br.com.postech.techchallenge.application.ports.out.ListOrderOutputPort;
//import jakarta.transaction.Transactional;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@AllArgsConstructor
//public class ListOrderAdapter implements ListOrderOutputPort {
//    private final OrderRepository orderRepository;
//    private final ModelMapper modelMapper;
//    @Override
//    @Transactional
//    public List<Order> execute() {
//        var allOrders = orderRepository.findAll();
//        return allOrders.stream()
//                .map(order -> modelMapper.map(order, Order.class))
//                .toList();
//    }
//}
