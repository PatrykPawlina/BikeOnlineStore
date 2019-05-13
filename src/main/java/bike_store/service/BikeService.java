package bike_store.service;

import bike_store.domain.Bike;

import java.util.List;
import java.util.Map;

public interface BikeService {
    void updateAllStock();

    List<Bike> getAllBikes();

    List<Bike> getBikesByCategory(String category);

    List<Bike> getBikesByFilter(Map<String, List<String>> filterParams);

    Bike getBikeById(String bikeID);

    void addBike(Bike bike);
}
