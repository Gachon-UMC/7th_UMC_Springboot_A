package umc.spring.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.User;
import umc.spring.domain.UserPrefer;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.controller.dto.UserDTO.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserQueryService{
    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request){
        User newUser = UserConverter.toUser(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category ->{
                        return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus._FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> UserPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);

        UserPreferList.forEach(userPrefer -> {userPrefer.setUser(newUser);});


        return userRepository.save(newUser);

    }
}
