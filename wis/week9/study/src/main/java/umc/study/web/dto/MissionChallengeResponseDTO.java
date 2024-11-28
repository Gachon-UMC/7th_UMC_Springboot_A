package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionChallengeResponseDTO {
    private Long userId;
    private Long missionId;
    private String status;
}
