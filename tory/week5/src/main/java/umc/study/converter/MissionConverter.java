package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.JoinMissionResultDTO toJoinMissionResultDTO(Mission mission){
        return MissionResponseDTO.JoinMissionResultDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.JoinMissionDto request){
        return Mission.builder()
                .missionTitle(request.getMissionTitle())
                .missionDescription(request.getMissionDescription())
                .storeId(request.getStoreId())
                .earnablePoint(request.getEarnablePoint())
                .missionDueDate(request.getMissionDueTime())

                .build();
    }
}