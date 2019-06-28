package bike_store.domain.repository.impl;

import bike_store.domain.Bike;
import bike_store.domain.Cart;
import bike_store.domain.CartItem;
import bike_store.domain.repository.CartRepository;
import bike_store.dto.CartDto;
import bike_store.dto.CartItemDto;
import bike_store.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryCartRepository implements CartRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTempleate;

    @Autowired
    private BikeService bikeService;

    public void create(CartDto cartDto) {
        String INSERT_CART_SQL = "INSERT INTO CART(ID) VALUES (:id)";
        Map<String, Object> cartParams = new HashMap<>();
        cartParams.put("id", cartDto.getId());
        jdbcTempleate.update(INSERT_CART_SQL, cartParams);
        cartDto.getCartItems().stream().forEach(cartItemDto -> {
            Bike bikeById = bikeService.getBikeById(cartItemDto.getBikeId());
            String INSERT_CART_ITEM_SQL = "INSERT INTO CART_ITEM(ID, BIKE_ID, CART_ID, QUANTITY) " +
                    "VALUES (:id, :bike_id, :cart_id, :quantity)";
            Map<String, Object> cartItemsParams = new HashMap<>();
            cartItemsParams.put("id", cartItemDto.getId());
            cartItemsParams.put("bike_id", bikeById.getBikeId());
            cartItemsParams.put("cart_id", cartDto.getId());
            cartItemsParams.put("quantity", cartItemDto.getQuantity());
            jdbcTempleate.update(INSERT_CART_ITEM_SQL, cartItemsParams);
        });
    }

    public Cart read(String id) {
        String SQL = "SELECT * FROM CART WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        CartMapper cartMapper = new CartMapper(jdbcTempleate, bikeService);

        try {
            return jdbcTempleate.queryForObject(SQL, params, cartMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(String id, CartDto cartDto) {
        List<CartItemDto> cartItems = cartDto.getCartItems();
        for (CartItemDto cartItem : cartItems) {
            String SQL = "UPDATE CART_ITEM SET QUANTITY = :quantity, BIKE_ID = :bikeId WHERE ID = :id AND CART_ID = :cartId";
            Map<String, Object> params = new HashMap<>();
            params.put("id", cartItem.getId());
            params.put("quantity", cartItem.getQuantity());
            params.put("bikeId", cartItem.getBikeId());
            params.put("cartId", id);
            jdbcTempleate.update(SQL, params);
        }
    }

    @Override
    public void delete(String id) {
        String SQL_DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE CART_ID = :id";
        String SQL_DELETE_CART = "DELETE FROM CART WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTempleate.update(SQL_DELETE_CART_ITEM, params);
        jdbcTempleate.update(SQL_DELETE_CART, params);
    }

    @Override
    public void addItem(String cartId, String bikeId) {
        String SQL = null;
        Cart cart = null;
        cart = read(cartId);
        if (cart == null) {
            CartItemDto newCartItemDto = new CartItemDto();
            newCartItemDto.setId(cartId + bikeId);
            newCartItemDto.setBikeId(bikeId);
            newCartItemDto.setQuantity(1);
            CartDto newCartDto = new CartDto(cartId);
            newCartDto.addCartItem(newCartItemDto);
            create(newCartDto);
            return;
        }

        Map<String, Object> cartItemsParams = new HashMap<>();
        if (cart.getItemByBikeId(bikeId) == null) {
            SQL = "INSERT INTO CART_ITEM (ID, BIKE_ID, CART_ID, QUANTITY) VALUES (:id, :bikeId, :cartId, :quantity)";
            cartItemsParams.put("id", cartId + bikeId);
            cartItemsParams.put("quantity", 1);
        } else {
            SQL = "UPDATE CART_ITEM SET QUANTITY = :quantity WHERE CART_ID = :cartId AND BIKE_ID = :bikeId";
            CartItem existingItem = cart.getItemByBikeId(bikeId);
            cartItemsParams.put("id", existingItem.getId());
            cartItemsParams.put("quantity", existingItem.getQuantity() + 1);
        }
        cartItemsParams.put("bikeId", bikeId);
        cartItemsParams.put("cartId", cartId);
        jdbcTempleate.update(SQL, cartItemsParams);
    }

    @Override
    public void removeItem(String cartId, String bikeId) {
        String SQL_DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE BIKE_ID = :bikeId AND CART_ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", cartId);
        params.put("bikeId", bikeId);
        jdbcTempleate.update(SQL_DELETE_CART_ITEM, params);
    }

    @Override
    public void clearCart(String cartId) {
        String SQL_DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE CART_ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", cartId);
        jdbcTempleate.update(SQL_DELETE_CART_ITEM, params);
    }
}

