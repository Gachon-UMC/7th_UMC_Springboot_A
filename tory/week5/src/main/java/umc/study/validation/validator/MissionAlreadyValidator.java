package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.MissionAlready;

@RequiredArgsConstructor
public class MissionAlreadyValidator implements ConstraintValidator<MissionAlready, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {

        return storeRepository.existsById(storeId);
    }
}
