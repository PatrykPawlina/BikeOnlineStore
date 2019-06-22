package bike_store.domain.repository.impl;

import bike_store.domain.CartItem;
import bike_store.service.BikeService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemMapper implements RowMapper<CartItem> {
    private BikeService bikeService;

    public CartItemMapper(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @Override
    public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        CartItem cartItem = new CartItem(rs.getString("ID"));
        cartItem.setBike(bikeService.getBikeById(rs.getString("BIKE_ID")));
        cartItem.setQuantity(rs.getInt("QUANTITY"));
        return cartItem;
    }
}
