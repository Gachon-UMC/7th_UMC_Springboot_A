package umc.spring.domain.mission.converter;

import java.time.LocalDateTime;

import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.mission.dto.MissionRequestDto;
import umc.spring.domain.mission.dto.MissionResponseDto;
import umc.spring.domain.store.domain.Store;
import umc.spring.domain.user.domain.User;

public class MissionConverter {

	public static MissionResponseDto.addMissionResultDto toMissionResponseDto(Mission mission) {
		return MissionResponseDto.addMissionResultDto.builder()
			.missionId(mission.getMissionId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	public static MissionResponseDto.addUserMissionResultDto toUserMissionResponseDto(UserMission userMission) {
		return MissionResponseDto.addUserMissionResultDto.builder()
			.userMissionId(userMission.getMission().getMissionId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	public static Mission toMission(MissionRequestDto request, Store store){

		Mission mission = Mission.createMission(store, request.getPoint(), request.getContent(), request.getDueDate());

		return mission;
	}

	public static UserMission toUserMission(Mission mission, User user){

		UserMission userMission = UserMission.createUserMission(mission, user);
		userMission.createMissionNumber();
		return userMission;
	}
}
