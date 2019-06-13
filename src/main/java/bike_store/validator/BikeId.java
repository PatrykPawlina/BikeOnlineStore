package bike_store.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BikeIdValidator.class)
@Documented
public @interface BikeId {
    String message() default "{bike_store.validator.BikeId.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
