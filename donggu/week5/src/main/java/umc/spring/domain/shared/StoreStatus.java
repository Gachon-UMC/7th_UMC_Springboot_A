package umc.spring.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StoreStatus {
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE");

	private final String storeStatus;

}
