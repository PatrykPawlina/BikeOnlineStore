package bike_store.service.impl;

import bike_store.domain.Bike;
import bike_store.domain.repository.BikeRepository;
import bike_store.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public void updateAllStock() {
        List<Bike> allBikes = bikeRepository.getAllBikes();
        for (Bike bike : allBikes) {
            if (bike.getUnitsInStock() < 500)
                bikeRepository.updateStock(bike.getBikeId(), bike.getUnitsInStock() + 1000);
        }
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.getAllBikes();
    }

    @Override
    public List<Bike> getBikesByCategory(String category) {
        return bikeRepository.getBikesByCategory(category);
    }
}
