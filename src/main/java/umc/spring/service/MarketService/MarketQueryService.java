package umc.spring.service.MarketService;

import umc.spring.domain.Market;

import java.util.List;
import java.util.Optional;

public interface MarketQueryService {
    Optional<Market> findMarket(Long id);
    List<Market> findMarketsByNameAndScore(String name, Float score);
}
