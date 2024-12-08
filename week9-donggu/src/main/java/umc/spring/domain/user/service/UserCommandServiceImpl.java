package umc.spring.domain.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.foodCategory.domain.FoodCategory;
import umc.spring.domain.foodCategory.repository.FoodCategoryRepository;
import umc.spring.domain.mapping.UserPrefer;
import umc.spring.domain.mapping.converter.UserPreferConverter;
import umc.spring.domain.user.converter.UserConverter;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.dto.UserRequestDTO;
import umc.spring.domain.user.repository.UserRepository;
import umc.spring.global.api.code.status.ErrorStatus;
import umc.spring.global.api.exception.handler.FoodCategoryHandler;

@Service
@Transactional
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

	private final UserRepository userRepository;
	private final FoodCategoryRepository foodCategoryRepository;

	@Override
	public User joinUser(UserRequestDTO.JoinDto request) {

		User newUser = UserConverter.toUser(request);
		List<FoodCategory> foodCategoryList= request.getPreferCategory().stream()
			.map(category -> {
				return foodCategoryRepository.findById(category)
					.orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
			}).collect(Collectors.toList());

		List<UserPrefer>  userPreferList = UserPreferConverter.toUserPreferList(newUser,foodCategoryList);

		userPreferList.forEach(userPrefer -> {userPrefer.updatePreferUser(newUser);});
		//{userPrefer.builder().user(newUser).build();}

		return userRepository.save(newUser);
	}
}
