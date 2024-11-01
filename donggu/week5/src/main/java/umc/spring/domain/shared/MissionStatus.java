package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MissionStatus {
	WAITING("WAITING"),
	ONGOING("ONGOING"),
	COMPLETE("COMPLETE");

	private final String missionStatus;
}
