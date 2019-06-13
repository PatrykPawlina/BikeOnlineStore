package bike_store.validator;

import bike_store.domain.Bike;
import bike_store.exception.BikeNotFoundException;
import bike_store.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BikeIdValidator implements ConstraintValidator<BikeId, String> {
    @Autowired
    private BikeService bikeService;

    @Override
    public void initialize(BikeId constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Bike bike;
        try {
            bike = bikeService.getBikeById(value);
        } catch (BikeNotFoundException e) {
            return true;
        }
        return bike == null;
    }
}
