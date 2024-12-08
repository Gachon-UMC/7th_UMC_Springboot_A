package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Market;
import umc.spring.domain.mission.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findByMarket(Market market, Pageable pageable);

}