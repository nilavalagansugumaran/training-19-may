package com.example.demoValidation.annotation.validators;

import com.example.demoValidation.annotation.ValidPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber,String> {

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String var1, ConstraintValidatorContext var2){
        return var1 != null && var1.matches("[0-9]+") && (var1.length() > 8) && (var1.length() < 14);
    }
}
