package umc.spring.domain.store.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.etc.map.domain.Map;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.region.domain.Region;
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
	@Column(columnDefinition = "VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private StoreStatus storeStatus;

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

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Mission> missionList = new ArrayList<>();

	@OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
	private Map map;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private Region region;

	@Builder
	private Store(String storeName, String storeCategory, String storeLocation){
		this.storeName = storeName;
		this.storeCategory = storeCategory;
		this.storeLocation = storeLocation;
		this.storeStatus = StoreStatus.INACTIVE;
	}

	public static Store createStore(String storeName, String storeLocation){
		return Store.builder()
			.storeName(storeName)
			.storeLocation(storeLocation)
			.build();
	}

	public void updateRegion(Region region){
		this.region = region;
	}

	public void addReview(Review review){
		if(this.reviewList == null){
			this.reviewList = new ArrayList<>();
		}
		this.reviewList.add(review);
	}

	public void addMission(Mission mission){
		if(this.missionList == null){
			this.missionList = new ArrayList<>();
		}
		this.missionList.add(mission);
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
