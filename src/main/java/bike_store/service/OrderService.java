package bike_store.service;

import bike_store.domain.Order;

public interface OrderService {

    Long saveOrder(Order order);
}
