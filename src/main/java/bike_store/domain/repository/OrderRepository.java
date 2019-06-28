package bike_store.domain.repository;

import bike_store.domain.Order;

public interface OrderRepository {

    long saveOrder(Order order);
}
