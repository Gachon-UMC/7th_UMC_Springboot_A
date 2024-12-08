package umc.spring.repository.MarketRepository;

import umc.spring.domain.Market;

import java.util.List;

public interface MarketRepositoryCustom {
    List<Market> dynamicQueryWithBooleanBuilder(String name, Float score);
}
