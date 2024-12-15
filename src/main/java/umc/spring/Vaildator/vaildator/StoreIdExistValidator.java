package umc.spring.Vaildator.vaildator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.Vaildator.annotation.ExistStoreId;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreIdExistValidator implements ConstraintValidator<ExistStoreId , Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStoreId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long values, ConstraintValidatorContext context) {
        boolean isValid = values != null && storeRepository.existsById(values);


        if (!isValid) {
            // 기본 메시지 비활성화
            context.disableDefaultConstraintViolation();
            // 사용자 정의 메시지 설정
            context.buildConstraintViolationWithTemplate(ErrorStatus.Store_NOT_FOUND.getMessage())
                    .addConstraintViolation();
        }

        return isValid;

    }
}
