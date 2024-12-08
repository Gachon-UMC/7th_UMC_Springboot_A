package umc.spring.domain.mission.service;

import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.mission.dto.MissionRequestDto;
import umc.spring.domain.mission.dto.MissionSelectRequestDto;

public interface MissionService {

	Mission addMission(MissionRequestDto request);

	UserMission addUserMission(MissionSelectRequestDto request);
}
