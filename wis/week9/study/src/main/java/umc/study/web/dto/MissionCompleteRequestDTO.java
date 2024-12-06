package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionCompleteRequestDTO {

    @NotNull(message = "Mission ID is required.")
    private Long missionId;

    @NotNull(message = "User ID is required.")
    private Long userId;
}


