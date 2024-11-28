package umc.spring.domain.mission.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.store.domain.Store;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mission{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long missionId;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;

	@NotNull
	@Column
	private int point;

	@NotNull
	@Column(length = 100)
	private String content;

	@Column(length = 20)
	private String missionLocation;

	@NotNull
	@Column
	private int dueDate;

	@OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
	private List<UserMission> userMissionList = new ArrayList<>();

	@Builder
	private Mission(Store store, int point, String content, int dueDate) {
		this.store = store;
		this.point = point;
		this.content = content;
		this.dueDate = dueDate;
	}

	public static Mission createMission(Store store, int point, String content, int dueDate) {
		return Mission.builder()
			.store(store)
			.point(point)
			.content(content)
			.dueDate(dueDate)
			.build();
	}

	public void updateMissionLocation(Store store) {
		this.missionLocation = store.getStoreLocation();
	}
}
