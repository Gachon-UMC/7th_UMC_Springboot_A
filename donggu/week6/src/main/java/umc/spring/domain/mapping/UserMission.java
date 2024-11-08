package umc.spring.domain.mapping;

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
	@Column(columnDefinition = "VARCHAR(10) DEFAULT 'WAITING'")
	private MissionStatus missionStatus;

	@NotNull
	@Column(length = 20)
	private String missionNumber;

	@Builder
	private UserMission(Mission mission, User user, MissionStatus missionStatus, String missionNumber) {
		this.mission = mission;
		this.user = user;
		this.missionStatus = MissionStatus.WAITING;
		this.missionNumber = missionNumber;
	}
}
