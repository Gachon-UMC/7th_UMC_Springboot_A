package umc.spring.domain.mission.service;

import org.springframework.data.domain.Page;

import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mission.domain.Mission;

public interface MissionQueryService {

	Page<Mission> getMissionList(Long storeId, Integer page);

	Page<UserMission> getMyOngoingMissionList (Long userId, Integer page);


	Void finishMission(Long userMissionId);
}
