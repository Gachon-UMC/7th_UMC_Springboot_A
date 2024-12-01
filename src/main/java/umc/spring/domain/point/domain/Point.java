package umc.spring.domain.point.domain;

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
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.shared.PointStatus;
import umc.spring.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Point extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pointId;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mission_id")
	private UserMission userMission;

	@NotNull
	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private PointStatus pointStatus;

	@NotNull
	@Column(length = 100)
	private String content;

	@NotNull
	@Column
	private int pointValue;

	@Builder
	private Point(User user, UserMission userMission, PointStatus pointStatus, String content, int pointValue) {
		this.user = user;
		this.userMission = userMission;
		this.pointStatus = pointStatus;
		this.content = content;
		this.pointValue = pointValue;
	}

}
