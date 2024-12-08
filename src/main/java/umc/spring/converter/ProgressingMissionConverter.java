package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.mission.ProgressingMission;
import umc.spring.domain.user.Users;

@Component
public class ProgressingMissionConverter {

    public ProgressingMission toEntity(Users user, Mission mission) {
        return ProgressingMission.builder()
                .user(user)
                .mission(mission)
                .build();
    }
}
