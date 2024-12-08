package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class JoinMissionDto{
        @NotBlank
        String missionTitle;
        @NotBlank
        String missionDescription;
        @NotNull
        Integer storeId;

        @NotNull
        Integer earnablePoint;
        @NotNull
        Integer missionDueTime;
    }
}