package umc.study.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus status);

    @Query("SELECT um FROM UserMission um WHERE um.user = :user AND um.status = :status")
    Page<UserMission> findAllByUser(
            @Param("user") User user,
            @Param("status") MissionStatus status,
            Pageable pageable
    );

    @Query("SELECT um FROM UserMission um WHERE um.user = :user AND um.mission.id = :missionId AND um.status = :status")
    Optional<UserMission> findByUserAndMissionIdAndStatus(
            @Param("user") User user,
            @Param("missionId") Long missionId,
            @Param("status") MissionStatus status
    );
}
