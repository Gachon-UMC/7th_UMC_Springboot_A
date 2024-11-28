package umc.study.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus status);

    @Query("SELECT um FROM UserMission um WHERE um.user = :user AND um.status = :status")
    Page<UserMission> findAllByUser(
            @Param("user") User user,
            @Param("status") MissionStatus status,
            Pageable pageable
    );
}
