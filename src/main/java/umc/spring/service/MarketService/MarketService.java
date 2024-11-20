package umc.spring.service.MarketService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MarketConverter;
import umc.spring.domain.Market;
import umc.spring.web.dto.MarketRegisterDto;
import umc.spring.repository.MarketRepository.MarketRepository;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;
    private final MarketConverter marketConverter;

    @Transactional
    public Market addMarket(MarketRegisterDto dto) {
        Market market = marketConverter.toEntity(dto);
        return marketRepository.save(market);
    }
}
