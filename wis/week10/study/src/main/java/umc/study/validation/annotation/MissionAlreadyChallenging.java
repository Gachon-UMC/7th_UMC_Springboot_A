package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.MissionAlreadyChallengingValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionAlreadyChallengingValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionAlreadyChallenging {

    String message() default "The mission is already being challenged.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
