package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.domain.mapping.Mission;
import umc.spring.web.controller.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.controller.dto.MissionDTO.MissionResponseDTO;


import java.time.LocalDateTime;

public class MissionConverter {


    public static MissionResponseDTO.JoinResultDTO ToMissionDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .missionTitle(mission.getTitle())
                .missionDescription(mission.getDescription())
                .points(mission.getPoint())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission ToMission(MissionRequestDTO.JoinAddMissionDTO request, Store store){
        return Mission.builder()
                .store(store)
                .title(request.getMissionTitle())
                .description(request.getMissionDescription())
                .point(request.getPoint())
                .build();
    }

    public static MissionResponseDTO.MissionDTO toMissionPageDTO(Mission mission) {
        return MissionResponseDTO.MissionDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .point(mission.getPoint())
                .build();
    }
}
