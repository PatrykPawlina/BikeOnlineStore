package bike_store.service.impl;

import bike_store.domain.Order;
import bike_store.domain.repository.OrderRepository;
import bike_store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Long saveOrder(Order order) {
        return orderRepository.saveOrder(order);
    }
}
