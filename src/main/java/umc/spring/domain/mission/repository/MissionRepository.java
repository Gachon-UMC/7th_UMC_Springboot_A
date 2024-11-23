package umc.spring.domain.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.mission.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
