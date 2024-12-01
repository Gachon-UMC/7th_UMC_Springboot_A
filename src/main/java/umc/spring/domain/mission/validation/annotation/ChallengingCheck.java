package umc.spring.domain.mission.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.domain.mission.validation.validator.ChallengingCheckValidator;

@Documented
@Constraint(validatedBy = ChallengingCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ChallengingCheck {
	String message() default "이미 도전중인 미션입니다.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
