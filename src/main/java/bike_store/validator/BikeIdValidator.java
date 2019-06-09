package bike_store.validator;

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
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
