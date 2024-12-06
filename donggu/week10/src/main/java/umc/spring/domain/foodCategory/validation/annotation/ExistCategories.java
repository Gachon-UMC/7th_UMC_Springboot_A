package umc.spring.domain.foodCategory.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.domain.foodCategory.validation.validator.CategoriesExistValidator;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {
	String message() default "해당하는 카테고리가 존재하지 않습니다.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
