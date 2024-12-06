package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.MissionAlreadyChallenging;

@Getter
@Setter
public class MissionChallengeRequestDTO {

    @NotNull(message = "Mission ID is required.")
    @MissionAlreadyChallenging
    private Long missionId;

    @NotNull(message = "User ID is required.")
    private Long userId;
}
