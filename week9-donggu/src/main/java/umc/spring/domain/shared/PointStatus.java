package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PointStatus {
	PLUS("PLUS"),
	MINUS("MINUS");

	private final String pointStatus;
}
