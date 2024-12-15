package umc.spring.converter;

import umc.spring.domain.UserMission;
import umc.spring.domain.emums.MissionStatus;
import umc.spring.web.controller.dto.MissionDTO.UserMissionResponseDTO;
import umc.spring.web.controller.dto.UserMissionDTO.UserMissionDTO;

import java.time.LocalDateTime;

public class UserMissionConverter {

    public static UserMissionResponseDTO.MissionDTO toUserMissionDTO(UserMission userMission) {
        return UserMissionResponseDTO.MissionDTO.builder()
                .missionId(userMission.getMission().getId())
                .title(userMission.getMission().getTitle())
                .description(userMission.getMission().getDescription())
                .point(userMission.getMission().getPoint())
                .storeName(userMission.getMission().getStore().getName())
                .build();
    }

    public static UserMissionDTO.MissionUpdateResponseDTO toMissionUpdateDTO(UserMission userMission) {
        return UserMissionDTO.MissionUpdateResponseDTO.builder()
                .userMissionId(userMission.getId())
                .missionStatus(userMission.getMissionStatus().name())
                .completedDate(userMission.getCompletedDate())
                .build();
    }
    // 빌더를 활용하여 상태 변경
    public static UserMission updateMissionStatus(UserMission userMission, MissionStatus missionStatus, LocalDateTime completedDate) {
        return UserMission.builder()
                .id(userMission.getId()) // 기존 ID 유지
                .user(userMission.getUser()) // 기존 User 유지
                .mission(userMission.getMission()) // 기존 Mission 유지
                .missionStatus(missionStatus) // 변경할 Status
                .completedDate(completedDate) // 변경할 Completed Date
                .build();
    }
}
