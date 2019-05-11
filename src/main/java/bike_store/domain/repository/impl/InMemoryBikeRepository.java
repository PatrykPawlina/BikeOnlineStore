package bike_store.domain.repository.impl;

import bike_store.domain.Bike;
import bike_store.domain.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryBikeRepository implements BikeRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Bike> getAllBikes() {
        Map<String, Object> params = new HashMap<>();
        List<Bike> result = jdbcTemplate.query("SELECT * FROM BIKES", params, new BikeMapper());
        return result;
    }

    @Override
    public void updateStock(String bikeId, long noOfUnits) {
        String SQL = "UPDATE BIKES SET UNITS_IN_STOCK = :unitsInStock WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("unitsInStock", noOfUnits);
        params.put("id", bikeId);
        jdbcTemplate.update(SQL, params);
    }

    @Override
    public List<Bike> getBikesByCategory(String category) {
        String SQL = "SELECT * FROM BIKES WHERE CATEGORY = :category";
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        return jdbcTemplate.query(SQL, params, new BikeMapper());
    }

    @Override
    public List<Bike> getBikesByFilter(Map<String, List<String>> filterParams) {
        String SQL = "SELECT * FROM BIKES WHERE CATEGORY IN( :categories) AND MANUFACTURER IN( :brands)";
        return jdbcTemplate.query(SQL, filterParams, new BikeMapper());
    }

    @Override
    public Bike getBikeById(String bikeID) {
        String SQL = "SELECT * FROM BIKES WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", bikeID);
        return jdbcTemplate.queryForObject(SQL, params, new BikeMapper());
    }

    private static final class BikeMapper implements RowMapper<Bike> {

        public Bike mapRow(ResultSet resultSet, int i) throws SQLException {
            Bike bike = new Bike();
            bike.setBikeId(resultSet.getString("ID"));
            bike.setName(resultSet.getString("NAME"));
            bike.setDescription(resultSet.getString("DESCRIPTION"));
            bike.setUnitPrice(resultSet.getBigDecimal("UNIT_PRICE"));
            bike.setManufacturer(resultSet.getString("MANUFACTURER"));
            bike.setCategory(resultSet.getString("CATEGORY"));
            bike.setCondition(resultSet.getString("CONDITION"));
            bike.setUnitsInStock(resultSet.getLong("UNITS_IN_STOCK"));
            bike.setUnitsInOrder(resultSet.getLong("UNITS_IN_ORDER"));
            bike.setDiscontinued(resultSet.getBoolean("DISCONTINUED"));
            return bike;
        }
    }
}
