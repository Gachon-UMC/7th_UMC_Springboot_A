package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionType {
	ACCOUNT("ACCOUNT"),
	MISSION("MISSION"),
	SYSTEM("SYSTEM"),
	STORE("STORE"),
	REPORT("REPORT"),
	RECOMMEND("RECOMMEND");

	private final String questionType;
}
