package bike_store.domain.repository;

import bike_store.domain.Bike;

import java.util.List;

public interface BikeRepository {

    List<Bike> getAllBikes();

    void updateStock(String bikeId, long noOfUnits);

}
