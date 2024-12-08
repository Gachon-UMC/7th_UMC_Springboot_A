package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getUserId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                //.specAddress(request.getSpecAddress())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .gender(gender)
                .name(request.getName())
                .role(request.getRole())   // 추가된 코드
                .preferFoodCategory(request.getPreferCategory().toString())
                .build();
    }
    public static UserResponseDTO.UserReviewPreViewDTO reviewPreViewDTO(Review review){
        return UserResponseDTO.UserReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static UserResponseDTO.UserReviewPreViewListDTO UserReviewPreViewListDTO(Page<Review> reviewPage){
        List<UserResponseDTO.UserReviewPreViewDTO> UserReviewPreViewDTOList = reviewPage.stream()
                .map(UserConverter::reviewPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.UserReviewPreViewListDTO.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(UserReviewPreViewDTOList.size())
                .userReviewList(UserReviewPreViewDTOList)
                .build();
    }
    public static UserResponseDTO.UserMisisonPreViewDTO missionPreViewDTO(Mission mission){
        return UserResponseDTO.UserMisisonPreViewDTO.builder()
                .ownerNickname(mission.getUser().getName())
                .body(mission.getMissionDescription())
                .build();
    }
    public static UserResponseDTO.UserMissionPreViewListDTO UserMisisonPreViewListDTO(Page<Mission> missionPage){
        List<UserResponseDTO.UserMisisonPreViewDTO> UserMissionPreViewDTOList = missionPage.stream()
                .map(UserConverter::missionPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.UserMissionPreViewListDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(UserMissionPreViewDTOList.size())
                .userMissionList(UserMissionPreViewDTOList)
                .build();
    }




}