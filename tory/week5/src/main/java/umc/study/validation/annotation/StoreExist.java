package umc.study.validation.annotation;


import jakarta.validation.Constraint;
import umc.study.validation.validator.StoreExistValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StoreExistValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StoreExist {
//    String message() default "가게가 존재하지 않습니다";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
}

