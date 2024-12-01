package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TermType {
	OPTIONAL("OPTIONAL"),
	REQUIRED("REQUIRED");

	private final String termType;
}
