package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
	ADMIN("ADMIN"),
	GUEST("GUEST"),
	USER("USER");

	private final String userType;
}
