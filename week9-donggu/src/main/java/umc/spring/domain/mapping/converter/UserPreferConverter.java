package umc.spring.domain.mapping.converter;

import java.util.List;
import java.util.stream.Collectors;

import umc.spring.domain.foodCategory.domain.FoodCategory;
import umc.spring.domain.mapping.UserPrefer;
import umc.spring.domain.user.domain.User;

public class UserPreferConverter {

	public static List<UserPrefer> toUserPreferList(User newUser, List<FoodCategory> foodCategoryList) {

		return foodCategoryList.stream()
			.map(foodCategory ->
				UserPrefer.createUserPrefer(newUser, foodCategory)
			).collect(Collectors.toList());
	}
}
