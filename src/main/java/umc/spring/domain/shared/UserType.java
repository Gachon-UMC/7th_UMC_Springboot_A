package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
	ADMIN("ADMIN"),
	OWNER("OWNER"),
	CUSTOMER("CUSTOMER");

	private final String userType;
}
