package umc.spring.web.controller.dto.MissionChallenge;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionChallengeResponseDTO {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JoinChallengeResultDTO{
        Long userMissionId;
        Integer missionStatus;
        LocalDateTime createdAt;
    }
}
