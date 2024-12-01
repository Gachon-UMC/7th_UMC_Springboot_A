package umc.spring.domain.mission.dto;

import lombok.Getter;
import umc.spring.domain.mission.validation.annotation.ChallengingCheck;

@Getter
@ChallengingCheck
public class MissionSelectRequestDto {
	private long missionId;
	private long userId;
}
