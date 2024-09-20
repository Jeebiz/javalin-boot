package io.javalin.boot.api.annotation;

import io.javalin.boot.api.validation.NumberValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(validatedBy = {NumberValueValidator.class})
public @interface NumberValue {

    String regex() default "^[0-9\\-]+$";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
