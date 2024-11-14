package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SocialStatus {
	KAKAO("KAKAO"),
	NAVER("NAVER"),
	APPLE("APPLE"),
	GOOGLE("GOOGLE");

	private final String SocialStatus;
}
