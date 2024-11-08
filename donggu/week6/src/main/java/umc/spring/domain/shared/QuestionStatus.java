package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionStatus {
	WAITING("WAITING"),
	COMPLETE("COMPLETE");

	private final String questionStatus;
}
