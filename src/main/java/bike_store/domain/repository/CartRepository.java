package bike_store.domain.repository;

import bike_store.domain.Cart;
import bike_store.dto.CartDto;

public interface CartRepository {
    void create(CartDto cartDto);

    Cart read(String id);

    void update(String id, CartDto cartDto);

    void delete(String id);

    void addItem(String cartId, String bikeId);

    void removeItem(String cartId, String bikeId);

    void clearCart(String cartId);
}

