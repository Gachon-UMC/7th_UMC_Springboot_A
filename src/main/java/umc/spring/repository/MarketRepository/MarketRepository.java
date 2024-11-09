package umc.spring.repository.MarketRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Market;

public interface MarketRepository extends JpaRepository<Market, Long>, MarketRepositoryCustom {
}