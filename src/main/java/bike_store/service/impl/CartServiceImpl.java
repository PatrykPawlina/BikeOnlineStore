package bike_store.service.impl;

import bike_store.domain.Cart;
import bike_store.domain.repository.CartRepository;
import bike_store.dto.CartDto;
import bike_store.exception.InvalidCartException;
import bike_store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    public void create(CartDto cartDto) {
        cartRepository.create(cartDto);
    }

    @Override
    public Cart read(String id) {
        return cartRepository.read(id);
    }

    @Override
    public void update(String id, CartDto cartDto) {
        cartRepository.update(id, cartDto);
    }

    @Override
    public void delete(String id) {
        cartRepository.delete(id);
    }

    @Override
    public void addItem(String cartId, String
            bikeId) {
        cartRepository.addItem(cartId, bikeId);
    }

    @Override
    public void removeItem(String cartId, String
            bikeId) {
        cartRepository.removeItem(cartId, bikeId);
    }

    @Override
    public Cart validate(String cartId) {
        Cart cart = cartRepository.read(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new InvalidCartException(cartId);
        }
        return cart;
    }

    @Override
    public void clearCart(String cartId) {
        cartRepository.clearCart(cartId);
    }
}
