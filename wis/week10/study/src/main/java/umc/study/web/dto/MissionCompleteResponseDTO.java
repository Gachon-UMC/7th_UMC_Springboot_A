package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionCompleteResponseDTO {
    private Long userId;
    private Long missionId;
    private String status;
}
