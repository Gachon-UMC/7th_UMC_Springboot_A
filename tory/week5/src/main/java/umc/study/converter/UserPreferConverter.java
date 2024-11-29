package umc.study.converter;

import umc.study.domain.UserPrefer;

import java.util.List;

public class UserPreferConverter {

    public static List<UserPrefer> toUserPreferList(List<UserPrefer> foodCategoryList){

//        return foodCategoryList.stream()
//                .map(foodCategory ->
//                        UserPrefer.builder()
//                                .food(foodCategory)
//                                .build()
//                ).collect(Collectors.toList());
        return foodCategoryList;
    }
}
