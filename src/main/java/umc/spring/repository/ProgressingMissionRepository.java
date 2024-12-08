package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mission.ProgressingMission;

import java.util.Optional;

public interface ProgressingMissionRepository extends JpaRepository<ProgressingMission, Long> {
    Optional<ProgressingMission> findByUserIdAndMissionId(Long userId, Long missionId);
    Page<ProgressingMission> findByUserId(Long userId, Pageable pageable);

}
