package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.Market;
import umc.spring.web.dto.MissionRegisterDto;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MarketRepository marketRepository;
    private final MissionConverter missionConverter;

    @Transactional
    public Mission addMission(MissionRegisterDto dto) {
        Market market = marketRepository.findById(dto.getMarketId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 가게 ID입니다."));
        Mission mission = missionConverter.toEntity(dto, market);
        return missionRepository.save(mission);
    }
}
