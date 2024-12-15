package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.UserPrefer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {

    public static List<UserPrefer> toUserPreferList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
