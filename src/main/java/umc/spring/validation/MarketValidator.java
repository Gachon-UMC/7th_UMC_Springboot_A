package umc.spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.repository.MarketRepository.MarketRepository;

@RequiredArgsConstructor
public class MarketValidator implements ConstraintValidator<ValidMarket, Long> {

    private final MarketRepository marketRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != null && marketRepository.existsById(value);
    }
}
