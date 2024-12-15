package umc.spring.Vaildator.vaildator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.Vaildator.annotation.ExistMission;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.emums.MissionStatus;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {

    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        // 1. 미션이 존재하는지 확인
        boolean isMissionExists = missionId != null && missionRepository.existsById(missionId);

        // 2. 미션이 진행 중인지 확인 (UserMission에서 PENDING 상태인지)
        boolean isMissionInProgress = userMissionRepository.existsByMissionIdAndMissionStatus(missionId, MissionStatus.PENDING);

        // 기본 메시지 비활성화
        context.disableDefaultConstraintViolation();

        // 미션이 없을 경우
        if (!isMissionExists) {
            context.buildConstraintViolationWithTemplate(ErrorStatus.Mission_NOT_FOUND.getMessage())
                    .addConstraintViolation();
            return false;
        }

        // 미션이 이미 진행 중일 경우
        if (isMissionInProgress) {
            context.buildConstraintViolationWithTemplate(ErrorStatus.Mission_ALREADY_IN_PROGRESS.getMessage())
                    .addConstraintViolation();
            return false;
        }

        // 위 조건들을 모두 통과하면 valid
        return true;
    }
}
