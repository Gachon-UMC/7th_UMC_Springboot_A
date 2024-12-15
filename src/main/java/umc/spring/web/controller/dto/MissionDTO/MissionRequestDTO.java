package umc.spring.web.controller.dto.MissionDTO;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.Vaildator.annotation.ExistStoreId;

public class MissionRequestDTO {


    @Getter
    @Setter
    public static class JoinAddMissionDTO {
        @ExistStoreId
        Long storeId;
        String missionTitle;
        @Size(min = 1, max = 255)
        String missionDescription;
        Integer point;
    }
}
