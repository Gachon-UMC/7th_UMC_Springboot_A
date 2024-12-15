package umc.spring.service.StoreService;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.controller.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.controller.dto.StoreDTO.StoreResponseDTO;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    Optional<Review> findReview(Long id);
    List<Store> findStoresByNameAndScore(String name, Integer rating);
    StoreResponseDTO.JoinResultDTO joinStore(Long regionId, StoreRequestDTO.joinStoreDTO request);
    StoreResponseDTO.ReviewPreViewListDTO getReviewList(Long storeId, int page);
}
