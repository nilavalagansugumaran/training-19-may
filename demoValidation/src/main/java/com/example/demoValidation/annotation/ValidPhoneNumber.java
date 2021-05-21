package com.example.demoValidation.annotation;

import com.example.demoValidation.annotation.validators.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {
    String message() default "Phone number invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
