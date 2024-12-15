package umc.spring.Vaildator.vaildator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.Vaildator.annotation.ExistUserId;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.UserRepository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserIdExistValidator implements ConstraintValidator<ExistUserId,Long> {

    private final UserRepository userRepository;

    @Override
    public void initialize(ExistUserId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = value != null && userRepository.existsById(value);


        if (!isValid) {
            // 기본 메시지 비활성화
            context.disableDefaultConstraintViolation();
            // 사용자 정의 메시지 설정
            context.buildConstraintViolationWithTemplate(ErrorStatus.User_NOT_FOUND.getMessage())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
