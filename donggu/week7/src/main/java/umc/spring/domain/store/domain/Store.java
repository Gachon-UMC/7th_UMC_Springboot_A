package umc.spring.domain.store.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.map.domain.Map;
import umc.spring.domain.review.domain.Review;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.shared.StoreStatus;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;

	@NotNull
	@Column(length = 30)
	private String storeName;

	@NotNull
	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private StoreStatus storeStatus;

	@NotNull
	@Column(length = 10)
	private String storeCategory;

	@Column
	private String storeBackgroundImageUrl;

	@NotNull
	@Column(length = 50)
	private String storeLocation;

	@Column
	private float avgRating;

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Review> reviewList = new ArrayList<>();

	@OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
	private Map map;

	@Builder
	private Store(String storeName, String storeCategory, String storeLocation){
		this.storeName = storeName;
		this.storeCategory = storeCategory;
		this.storeLocation = storeLocation;
	}

	@Override
	public String toString() {
		return "Store{" +
			"storeId=" + storeId +
			", storeName='" + storeName + '\'' +
			", storeLocation='" + storeLocation + '\'' +
			", avgRating=" + avgRating +
			", " +
			'}';
	}
}
