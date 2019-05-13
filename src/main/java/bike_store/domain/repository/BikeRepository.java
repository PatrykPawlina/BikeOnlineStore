package bike_store.domain.repository;

import bike_store.domain.Bike;

import java.util.List;
import java.util.Map;

public interface BikeRepository {

    List<Bike> getAllBikes();

    void updateStock(String bikeId, long noOfUnits);

    List<Bike> getBikesByCategory(String category);

    List<Bike> getBikesByFilter(Map<String, List<String>> filterParams);

    Bike getBikeById(String bikeId);

    void addBike(Bike bike);
}
