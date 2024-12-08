package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.Market;
import umc.spring.web.dto.MissionRegisterDto;

@Component
public class MissionConverter {

    public Mission toEntity(MissionRegisterDto dto, Market market) {
        return Mission.builder()
                .description(dto.getDescription())
                .missionPoint(dto.getMissionPoint())
                .build();
    }
}
