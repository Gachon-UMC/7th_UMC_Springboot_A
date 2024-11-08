package umc.spring.domain.foodCategory.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
import umc.spring.domain.mapping.UserPrefer;
import umc.spring.domain.shared.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodCategory extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long foodId;

	@NotNull
	@Column(length = 30)
	private String foodName;

	@OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
	private List<UserPrefer> userPreferList = new ArrayList<>();

	@Builder
	private FoodCategory(String foodName) {
		this.foodName = foodName;
	}
}
