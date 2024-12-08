package umc.spring.repository.MarketRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Market;
import umc.spring.domain.mission.Mission;

public interface MarketRepository extends JpaRepository<Market, Long>, MarketRepositoryCustom {

}