package umc.spring.domain.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.user.domain.User;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
	boolean existsByUserAndMission(User user, Mission mission);
}
