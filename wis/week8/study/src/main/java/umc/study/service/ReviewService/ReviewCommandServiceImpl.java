package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.repository.ReveiwRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public ReviewResponseDTO addReview(Long storeId, ReviewRequestDTO request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found")); // Replace with custom exception

        User user = getHardCodedUser(); // 하드 코딩된 사용자
        Review review = Review.builder()
                .content(request.getContent())
                .star(request.getStar())
                .store(store)
                .user(user)
                .build();
        review = reviewRepository.save(review);

        return ReviewResponseDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .star(review.getStar())
                .storeName(store.getName())
                .userName(user.getName())
                .build();
    }

    private User getHardCodedUser() {
        return User.builder().id(1L).name("Hardcoded User").build();
    }
}

