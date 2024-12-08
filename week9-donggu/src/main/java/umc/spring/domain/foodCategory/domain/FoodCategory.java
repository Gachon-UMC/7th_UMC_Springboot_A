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

//카테고리 생성용 코드
/*INSERT INTO food_category (food_name, created_at, updated_at)
VALUES
	('한식', NULL, NULL),
('일식', NULL, NULL),
	('중식', NULL, NULL),
	('양식', NULL, NULL),
	('치킨', NULL, NULL),
	('분식', NULL, NULL),
	('고기/구이', NULL, NULL),
	('도시락', NULL, NULL),
	('야식(족발,보쌈)', NULL, NULL),
	('패스트푸드', NULL, NULL),
	('디저트', NULL, NULL),
	('아시안푸드', NULL, NULL);*/
