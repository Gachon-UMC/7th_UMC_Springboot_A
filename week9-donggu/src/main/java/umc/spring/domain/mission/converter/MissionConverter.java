package umc.spring.domain.mission.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

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

	public static MissionResponseDto.missionPreviewDto missionPreviewDto (Mission mission) {
		return MissionResponseDto.missionPreviewDto.builder()
			.storeName(mission.getStore().getStoreName())
			.category(mission.getStore().getStoreCategory())
			.body(mission.getContent())
			.point(mission.getPoint())
			.dueDate(mission.getDueDate())
			.build();
	}

	public static MissionResponseDto.missionPreviewListDto missionPreviewListDto (Page<Mission> missionList) {
		List<MissionResponseDto.missionPreviewDto> missionPreviewDtoList = missionList.stream()
			.map(MissionConverter::missionPreviewDto).collect(Collectors.toList());

		return MissionResponseDto.missionPreviewListDto.builder()
			.isLast(missionList.isLast())
			.isFirst(missionList.isFirst())
			.totalPage(missionList.getTotalPages())
			.totalElements(missionList.getTotalElements())
			.listSize(missionPreviewDtoList.size())
			.missionList(missionPreviewDtoList)
			.currentPage(missionList.getNumber())
			.build();
	}

	public static MissionResponseDto.myMissionPreviewDto myMissionPreviewDto (UserMission userMission) {
		return MissionResponseDto.myMissionPreviewDto.builder()
			.storeName(userMission.getMission().getStore().getStoreName())
			.nickName(userMission.getUser().getNickname())
			.category(userMission.getMission().getStore().getStoreCategory())
			.body(userMission.getMission().getContent())
			.point(userMission.getMission().getPoint())
			.dueDate(userMission.getMission().getDueDate())
			.build();
	}

	public static MissionResponseDto.myMissionPreviewListDto myMissionPreviewListDto (Page<UserMission> myMissionList) {
		List<MissionResponseDto.myMissionPreviewDto> myMissionPreviewDtoList = myMissionList.stream()
			.map(MissionConverter::myMissionPreviewDto).collect(Collectors.toList());

		return MissionResponseDto.myMissionPreviewListDto.builder()
			.isLast(myMissionList.isLast())
			.isFirst(myMissionList.isFirst())
			.totalPage(myMissionList.getTotalPages())
			.totalElements(myMissionList.getTotalElements())
			.listSize(myMissionPreviewDtoList.size())
			.myMissionList(myMissionPreviewDtoList)
			.currentPage(myMissionList.getNumber())
			.build();
	}
}
