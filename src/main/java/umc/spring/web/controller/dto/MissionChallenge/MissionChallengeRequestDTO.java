package umc.spring.web.controller.dto.MissionChallenge;

import lombok.Getter;
import lombok.Setter;
import umc.spring.Vaildator.annotation.ExistMission;
import umc.spring.Vaildator.annotation.ExistStoreId;
import umc.spring.Vaildator.annotation.ExistUserId;

public class MissionChallengeRequestDTO {

    @Getter
    @Setter
    public static class JoinAddMissionChallengeDTO {
        @ExistStoreId
        Long storeId;
        @ExistMission
        Long missionId;
    }
}
