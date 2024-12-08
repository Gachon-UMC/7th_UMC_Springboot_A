package umc.spring.domain.mapping;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.shared.MissionStatus;
import umc.spring.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMission extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assignId;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mission_id")
	private Mission mission;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(30) DEFAULT 'WAITING'")
	private MissionStatus missionStatus;

	@Column(length = 20)
	private String missionNumber;

	@Builder
	private UserMission(Mission mission, User user) {
		this.mission = mission;
		this.user = user;
		this.missionStatus = MissionStatus.WAITING;
	}

	public static UserMission createUserMission(Mission mission, User user) {
		return UserMission.builder()
			.mission(mission)
			.user(user)
			.build();
	}

	public void createMissionNumber() {
		this.missionNumber = getMissionNumber();
	}

	public static String generateMissionCode() {
		Random random = new Random();
		int randomNumber = 10000000 + random.nextInt(90000000); // 8자리 숫자 생성
		return String.valueOf(randomNumber);
	}

	public void startMissionStatus() {
		this.missionStatus = MissionStatus.ONGOING;
	}

	public void finishMissionStatus() {
		this.missionStatus = MissionStatus.COMPLETE;
	}
}
/*INSERT INTO user_mission (mission_id, user_id, mission_status, mission_number)
VALUES
    (1, 1, 'ONGOING', 11111111),
    (2, 1, 'ONGOING', 11111111),
    (3, 1, 'ONGOING', 11111111);*/
//UPDATE user_mission SET created_at = '2023-11-28 12:00:00' WHERE user_id = 1;