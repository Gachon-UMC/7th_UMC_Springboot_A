package umc.spring.service.MarketService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.error.Mark;
import umc.spring.domain.Market;
import umc.spring.repository.MarketRepository.MarketRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketQueryServiceImpl implements MarketQueryService {

    private final MarketRepository marketRepository;

    @Override
    public Optional<Market> findMarket(Long id) {
        return marketRepository.findById(id);
    }

    @Override
    public List<Market> findMarketsByNameAndScore(String name, Float score) {
        List<Market> filteredMarkets = marketRepository.dynamicQueryWithBooleanBuilder(name, score);
        filteredMarkets.forEach(market -> System.out.println("market = " + market));
        return filteredMarkets;
    }
}
