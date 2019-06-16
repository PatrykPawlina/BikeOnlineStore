package bike_store.domain.repository.impl;

import bike_store.domain.CartItem;
import bike_store.service.BikeService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemMapper implements RowMapper {

    private BikeService bikeService;

    public CartItemMapper(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CartItem cartItem = new CartItem(resultSet.getString("ID"));
        cartItem.setBike(bikeService.getBikeById(resultSet.getString("BIKE_ID")));
        cartItem.setQuantity(resultSet.getInt("QUANTITY"));
        return cartItem;
    }
}
