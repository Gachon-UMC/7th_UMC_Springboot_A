package umc.spring.web.controller.dto.UserMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserMissionDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionUpdateResponseDTO {
        private Long userMissionId;
        private String missionStatus;
        private LocalDateTime completedDate;
    }
}
