package bike_store.domain.repository.impl;

import bike_store.domain.Cart;
import bike_store.domain.CartItem;
import bike_store.service.BikeService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartMapper implements RowMapper<Cart> {
    private CartItemMapper cartItemMapper;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public CartMapper(NamedParameterJdbcTemplate jdbcTemplate, BikeService bikeService) {
        this.jdbcTemplate = jdbcTemplate;
        cartItemMapper = new CartItemMapper(bikeService);
    }

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("ID");
        Cart cart = new Cart(id);
        String SQL = String.format("SELECT * FROM CART_ITEM WHERE CART_ID = '%s'", id);
        List<CartItem> cartItems = jdbcTemplate.query(SQL, cartItemMapper);
        cart.setCartItems(cartItems);
        return cart;
    }
}
