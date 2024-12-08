package umc.spring.domain.region.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.store.domain.Store;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Region extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 20)
	private String regionName;

	@OneToMany(mappedBy = "region")
	private List<Store> storeList = new ArrayList<>();

	@Builder
	private Region(String regionName) {
		this.regionName = regionName;
	}

	public static Region createRegion(String regionName) {
		return Region.builder()
			.regionName(regionName)
			.build();
	}

	public void addStore(Store store) {
		if(this.storeList == null){
			this.storeList = new ArrayList<>();
		}
		this.storeList.add(store);
	}
}

/*INSERT INTO region (region_name) VALUES ('Seoul');*/
/*INSERT INTO region (region_name) VALUES ('Busan');*/
