package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
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
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                //.specAddress(request.getSpecAddress())
                .gender(gender)
                .email(request.getEmail())
                .name(request.getName())
                .userPreferList(new ArrayList<>())
                .build();
    }

    public static UserResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return UserResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static UserResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<UserResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(UserConverter::reviewPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static UserResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission) {
        return UserResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .point(mission.getPoint())
                .dueDate(mission.getDueDate())
                .status(mission.getStatus().name())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static UserResponseDTO.MissionListDTO missionPreViewListDTO(Page<Mission> missionList) {
        List<UserResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(UserConverter::missionPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missions(missionPreViewDTOList)
                .build();
    }

}
