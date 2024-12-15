package umc.spring.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.User;
import umc.spring.domain.UserMission;
import umc.spring.domain.emums.MissionStatus;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission ,Long> {
    boolean existsByMissionIdAndMissionStatus(Long missionId, MissionStatus missionStatus);
    Page<UserMission> findByUserAndMissionStatus(User user, MissionStatus missionStatus, Pageable pageable);

}
