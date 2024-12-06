package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static MissionStatus getMissionStatus(int status) {
        MissionStatus missionStatus = null;

        switch (status) {
            case 1:
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case 2:
                missionStatus = MissionStatus.COMPLETE;
                break;
            default:
                throw new IllegalArgumentException("Invalid Mission Status");
        }

        return missionStatus;
    }

    public static Mission toEntity(MissionRequestDTO request, Store store) {
        return Mission.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .point(request.getPoint())
                .dueDate(request.getDueDate())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toResponseDTO(Mission mission) {
        return MissionResponseDTO.builder()
                .id(mission.getId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .point(mission.getPoint())
                .storeName(mission.getStore().getName())
                .build();
    }
}

