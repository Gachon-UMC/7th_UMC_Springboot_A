package umc.study.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus status);
}
