package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.ValidStore;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ValidStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) {
            return false; // storeId가 null이면 검증 실패
        }
        return storeRepository.existsById(storeId); // storeId가 존재하면 true, 없으면 false
    }
}

