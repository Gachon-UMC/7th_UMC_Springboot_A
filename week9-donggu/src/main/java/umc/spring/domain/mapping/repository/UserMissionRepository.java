package umc.spring.domain.mapping.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.user.domain.User;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
	boolean existsByUserAndMission(User user, Mission mission);

	@Query("SElECT m FROM UserMission m WHERE m.missionStatus = umc.spring.domain.shared.MissionStatus.ONGOING")
	Page<UserMission> findAllByUserAndMissionStatus(@Param("userId") User user, PageRequest pageRequest );
}
