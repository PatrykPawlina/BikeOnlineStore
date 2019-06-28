package bike_store.service;

import bike_store.domain.Cart;
import bike_store.dto.CartDto;

public interface CartService {

    void create(CartDto cartDto);

    Cart read(String cartId);

    void update(String cartId, CartDto cartDto);

    void delete(String id);

    void addItem(String cartId, String bikeId);

    void removeItem(String cartId, String bikeId);

    Cart validate(String cartId);

    void clearCart(String cartId);
}
