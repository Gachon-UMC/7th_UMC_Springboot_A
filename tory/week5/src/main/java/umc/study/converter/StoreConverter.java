package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.JoinStoreResultDTO toJoinStoreResultDTO(Store store){
        return StoreResponseDTO.JoinStoreResultDTO.builder()
                .storeId(store.getStoreId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinStoreDto request){
        return Store.builder()
                .storeName(request.getStoreName())
                .description(request.getDescription())
                .category(request.getCategory())
                .address(request.getAddress())
                .reviewList(new ArrayList<>())
                .earnablePoint(request.getEarnablePoint())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewPage){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewPage.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getMissionId())
                .missionDescription(mission.getMissionDescription())
                .missionTitle(mission.getMissionTitle())
                .earnablePoint(mission.getEarnablePoint())
                .build();
    }
    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionPage){
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionPage.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }


}