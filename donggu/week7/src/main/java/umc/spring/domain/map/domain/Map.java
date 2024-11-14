package umc.spring.domain.map.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.store.domain.Store;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Map extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mapId;

	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;

	@Column
	private String location;

	@Builder
	private Map(Store store, String location) {
		this.store = store;
	}
}
