package umc.spring.domain.shared;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	ADMIN("ADMIN", "관리자"),
	USER("USER", "회원"),
	GUEST("GUEST", "비회원");

	private final String key;
	private final String title;
}
