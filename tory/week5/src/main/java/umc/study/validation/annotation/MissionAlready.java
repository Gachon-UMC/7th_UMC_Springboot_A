package umc.study.validation.annotation;


import jakarta.validation.Constraint;
import umc.study.validation.validator.MissionAlreadyValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MissionAlreadyValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionAlready {
//    String message() default "미션이 이미 진행 중 입니다";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
}
