package umc.spring.global.api.validation.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.global.api.code.status.ErrorStatus;
import umc.spring.global.api.validation.annotation.CheckPage;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

	@Override
	public void initialize(CheckPage constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Integer page, ConstraintValidatorContext context) {
		if (page == null || page <= 0) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_ERROR.toString())
				.addConstraintViolation();
			return false;
		}
		return true;
	}
}
