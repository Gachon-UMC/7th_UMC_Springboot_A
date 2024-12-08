package umc.spring.domain.review.validation.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.review.validation.annotation.ExistStore;
import umc.spring.domain.store.Repository.StoreRepository;
import umc.spring.global.api.code.status.ErrorStatus;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

	private final StoreRepository storeRepository;

	@Override
	public void initialize(ExistStore constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		if (value == null || value <= 0) {
			return false;
		}

		boolean isValid = storeRepository.existsById(Long.valueOf(value));

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString())
				.addConstraintViolation();
		}

		return isValid;
	}
}
