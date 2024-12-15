package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository.RegionRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.controller.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.controller.dto.StoreDTO.StoreResponseDTO;

import umc.spring.domain.mapping.Region;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static umc.spring.apiPayload.code.status.ErrorStatus.Store_region_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final RegionRepository regionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Optional<Review> findReview(Long id) {
        return reviewRepository.findById(id);
    }




    @Override
    public List<Store> findStoresByNameAndScore(String name, Integer rating) {
        // StoreRepository에서 BooleanBuilder를 이용한 동적 쿼리로 필요한 데이터 필터링
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, rating);

        // Store 및 연결된 Review 데이터 출력
        filteredStores.forEach(store -> {
            System.out.println("Store: " + store);
            store.getStoreReviews().forEach(review -> System.out.println(" - Review: " + review));
        });
        return filteredStores;
    }


    @Override
    @Transactional
    public StoreResponseDTO.JoinResultDTO joinStore(Long regionId,StoreRequestDTO.joinStoreDTO request){

        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new StoreHandler(Store_region_NOT_FOUND));

        Store newStore = StoreConverter.ToStore(request);
        newStore.setRegion(region);

        Store savedStore = storeRepository.save(newStore);

        return StoreConverter.ToStoreDTO(savedStore);

    }

    public StoreResponseDTO.ReviewPreViewListDTO getReviewList(Long storeId, int page) {
        // 페이징 처리
        Pageable pageable = PageRequest.of(page - 1, 10); // 페이지당 10개 조회
        Page<Review> reviewPage = reviewRepository.findByStoreId(storeId, pageable);

        // 리뷰 목록 변환
        List<StoreResponseDTO.ReviewDTO> reviews = reviewPage.stream()
                .map(ReviewConverter::toReviewPageDTO)
                .collect(Collectors.toList());

        // 결과 DTO 생성
        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .reviews(reviews)
                .currentPage(page)
                .totalPages(reviewPage.getTotalPages())
                .totalReviews(reviewPage.getTotalElements())
                .build();
    }

}
