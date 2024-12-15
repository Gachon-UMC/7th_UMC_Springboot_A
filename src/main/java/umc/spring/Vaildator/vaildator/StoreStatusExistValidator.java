package umc.spring.Vaildator.vaildator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.Vaildator.annotation.ExistStoreStatus;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreStatusExistValidator implements ConstraintValidator<ExistStoreStatus, Integer> {

    private static final List<Integer> VALID_STATUSES = List.of(1, 2);


    @Override
    public void initialize(ExistStoreStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // null이거나 유효하지 않은 값일 경우 false 반환
        boolean isValid = value != null && VALID_STATUSES.contains(value);

        if (!isValid) {
            // 기본 메시지 비활성화
            context.disableDefaultConstraintViolation();
            // 사용자 지정 메시지 설정
            context.buildConstraintViolationWithTemplate(ErrorStatus.STATUS_ERROR.getMessage())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
