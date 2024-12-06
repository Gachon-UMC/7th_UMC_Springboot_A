package umc.spring.domain.foodCategory.validation.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.foodCategory.repository.FoodCategoryRepository;
import umc.spring.domain.foodCategory.validation.annotation.ExistCategories;
import umc.spring.global.api.code.status.ErrorStatus;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

	private final FoodCategoryRepository foodCategoryRepository;

	@Override
	public void initialize(ExistCategories constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
		boolean isValid = values.stream()
			.allMatch(value -> foodCategoryRepository.existsById(value));

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
		}


		return isValid;
	}
}
