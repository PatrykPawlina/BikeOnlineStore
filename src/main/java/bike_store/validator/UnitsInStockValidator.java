package bike_store.validator;

import bike_store.domain.Bike;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component
public class UnitsInStockValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Bike.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Bike bike = (Bike) target;
        if (bike.getUnitPrice() != null && new BigDecimal(1000).compareTo(bike.getUnitPrice()) <= 0 && bike.getUnitsInStock() > 99) {
            errors.rejectValue("unitsInStock", "bike_store.validator.UnitsInStockValidator.message");
        }
    }
}
