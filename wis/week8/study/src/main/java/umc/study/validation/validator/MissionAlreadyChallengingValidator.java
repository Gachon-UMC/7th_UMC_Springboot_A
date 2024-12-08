package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.validation.annotation.MissionAlreadyChallenging;

@Component
@RequiredArgsConstructor
public class MissionAlreadyChallengingValidator implements ConstraintValidator<MissionAlreadyChallenging, Long> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        if (missionId == null) {
            return true; // null 값은 유효성 검사 대상이 아님
        }

        try {
            // Enum MissionStatus 사용
            boolean isAlreadyChallenging = userMissionRepository.existsByMissionIdAndStatus(missionId, MissionStatus.CHALLENGING);

            if (isAlreadyChallenging) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("The mission is already being challenged.")
                        .addConstraintViolation();
            }

            return !isAlreadyChallenging;

        } catch (Exception e) {
            e.printStackTrace();
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Unexpected error during validation: " + e.getMessage())
                    .addConstraintViolation();
            return false;
        }
    }
}
