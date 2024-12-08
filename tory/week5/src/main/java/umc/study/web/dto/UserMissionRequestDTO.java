package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.enums.MissionStatus;

public class UserMissionRequestDTO {

    @Getter
    public static class JoinUserMissionDto{
        @NotNull
        Integer userId;
        @NotNull
        Integer missionId;
        @NotNull
        MissionStatus status;
    }
}