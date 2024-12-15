package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.MyReviewConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.controller.dto.MyReviewDTO.MyReviewResponseDTO;
import umc.spring.web.controller.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.controller.dto.ReviewDTO.ReviewResponseDTO;

import static umc.spring.apiPayload.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public ReviewResponseDTO.JoinResultDTO addReview( ReviewRequestDTO.JoinReviewDTO request){

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()-> new StoreHandler(Review_STORE_NOT_FOUND));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new StoreHandler(Review_User_NOT_FOUN));

        Review newReview = ReviewConverter.ToReview(request,user,store);

        Review savedReview = reviewRepository.save(newReview);

        return ReviewConverter.ToReviewDTO(savedReview);
    }

    public MyReviewResponseDTO.PagedReviewDTO getMyReviews(Long userId, int page) {
        Page<Review> reviewPage = reviewRepository.findByUserId(userId, PageRequest.of(page, 10)); // 한 페이지에 10개씩
        return MyReviewConverter.toPagedReviewDTO(reviewPage);
    }
}
