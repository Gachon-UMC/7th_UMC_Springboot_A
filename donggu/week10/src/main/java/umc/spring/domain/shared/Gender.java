package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
	MALE("MALE"),
	FEMALE("FEMALE"),
	UNPICKED("UNPICKED");

	private final String gender;
}
