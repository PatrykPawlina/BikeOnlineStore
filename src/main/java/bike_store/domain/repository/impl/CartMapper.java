package bike_store.domain.repository.impl;

import bike_store.domain.Cart;
import bike_store.domain.CartItem;
import bike_store.service.BikeService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartMapper implements RowMapper {

    private CartItemMapper cartItemMapper;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CartMapper(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BikeService bikeService) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        cartItemMapper = new CartItemMapper(bikeService);
    }

    @Override
    public Cart mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String id = resultSet.getString("ID");
        Cart cart = new Cart(id);
        String SQL = String.format("SELECT * FROM CART_ITEM WHERE CARD_ID = '$S'", id);
        List<CartItem> cartItems = namedParameterJdbcTemplate.query(SQL, cartItemMapper);
        cart.setCartItems(cartItems);
        return cart;
    }
}
