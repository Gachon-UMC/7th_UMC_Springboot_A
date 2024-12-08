package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StoreStatus {
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE"),
	OPEN("OPEN");

	private final String storeStatus;

}
