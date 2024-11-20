package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mission.ProgressingMission;

import java.util.Optional;

public interface ProgressingMissionRepository extends JpaRepository<ProgressingMission, Long> {
    Optional<ProgressingMission> findByUserIdAndMissionId(Long userId, Long missionId);
}
