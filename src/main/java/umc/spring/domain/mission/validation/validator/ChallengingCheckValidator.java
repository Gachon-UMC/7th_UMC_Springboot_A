package umc.spring.domain.mission.validation.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.mapping.repository.UserMissionRepository;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.mission.dto.MissionSelectRequestDto;
import umc.spring.domain.mission.repository.MissionRepository;
import umc.spring.domain.mission.validation.annotation.ChallengingCheck;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class ChallengingCheckValidator implements ConstraintValidator<ChallengingCheck, MissionSelectRequestDto> {

	private final UserRepository userRepository;
	private final MissionRepository missionRepository;
	private final UserMissionRepository userMissionRepository;

	@Override
	public boolean isValid(MissionSelectRequestDto request, ConstraintValidatorContext context) {
		if (request == null) {
			return false;
		}

		User user = userRepository.findById(request.getUserId()).orElse(null);
		Mission mission = missionRepository.findById(request.getMissionId()).orElse(null);

		if (user == null || mission == null) {
			return false;
		}

		boolean exists = userMissionRepository.existsByUserAndMission(user, mission);

		if (exists) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("이미 도전중인 미션입니다.")
				.addConstraintViolation();
			return false;
		}

		return true;
	}
}
