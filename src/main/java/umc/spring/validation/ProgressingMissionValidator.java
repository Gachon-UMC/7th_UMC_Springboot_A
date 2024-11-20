package umc.spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.web.dto.ProgressingMissionRegisterDto;
import umc.spring.repository.ProgressingMissionRepository;

@RequiredArgsConstructor
public class ProgressingMissionValidator implements ConstraintValidator<ValidProgressingMission, ProgressingMissionRegisterDto> {

    private final ProgressingMissionRepository progressingMissionRepository;

    @Override
    public boolean isValid(ProgressingMissionRegisterDto dto, ConstraintValidatorContext context) {
        if (dto.getUserId() == null || dto.getMissionId() == null) {
            return false; // 기본 값 검증 실패
        }

        // 이미 도전 중인지 확인
        boolean exists = progressingMissionRepository.findByUserIdAndMissionId(dto.getUserId(), dto.getMissionId()).isPresent();
        return !exists; // 존재하지 않아야 유효
    }
}
