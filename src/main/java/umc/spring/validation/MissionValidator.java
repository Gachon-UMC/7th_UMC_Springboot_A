package umc.spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.repository.ProgressingMissionRepository;

@RequiredArgsConstructor
public class MissionValidator implements ConstraintValidator<ValidMission, Long> {

    private final ProgressingMissionRepository progressingMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        // 실제 사용자 ID는 Validator 외부에서 확인해야 하므로 유효성 검증은 missionId로만 수행
        // 아래 로직에서 이미 사용자가 해당 미션을 도전 중인지를 검증
        return progressingMissionRepository.findByUserIdAndMissionId(1L, missionId).isEmpty(); // 예시로 userId = 1L로 설정
    }
}
