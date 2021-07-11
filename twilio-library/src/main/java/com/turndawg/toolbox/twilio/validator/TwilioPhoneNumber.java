package com.turndawg.toolbox.twilio.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Target({ ElementType.FIELD ,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TwilioPhoneNumberValidator.class)
public @interface TwilioPhoneNumber {
   String message() default "doesn't seem to be a valid twilio phone number";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}