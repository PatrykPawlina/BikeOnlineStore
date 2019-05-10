package bike_store.service;

import bike_store.domain.Bike;

import java.util.List;

public interface BikeService {
    void updateAllStock();

    List<Bike> getAllBikes();
}
