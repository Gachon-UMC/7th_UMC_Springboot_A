package umc.spring.service.MarketService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MarketConverter;
import umc.spring.domain.Market;
import umc.spring.domain.mission.Mission;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MarketRegisterDto;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.web.dto.MarketResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;
    private final MarketConverter marketConverter;
    private final MissionRepository missionRepository;

    @Transactional
    public Market addMarket(MarketRegisterDto dto) {
        Market market = marketConverter.toEntity(dto);
        return marketRepository.save(market);
    }

    @Transactional(readOnly = true)
    public MarketResponseDto.MissionListResponseDto getMarketMissions(Long marketId, Integer page, Integer size) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 가게입니다."));

        Page<Mission> missionPage = missionRepository.findByMarket(market, PageRequest.of(page, size));

        List<MarketResponseDto.MissionPreviewDto> missionList = missionPage.getContent().stream()
                .map(mission -> new MarketResponseDto.MissionPreviewDto(
                        mission.getDescription(), // 미션 설명
                        mission.getMissionPoint(), // 미션 포인트
                        mission.getCreatedAt() // 생성일
                ))
                .toList();

        return MarketResponseDto.MissionListResponseDto.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}
