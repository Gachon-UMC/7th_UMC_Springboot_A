package umc.spring.service.ReviewService;

import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.web.controller.dto.MyReviewDTO.MyReviewResponseDTO;
import umc.spring.web.controller.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.controller.dto.ReviewDTO.ReviewResponseDTO;

public interface ReviewQueryService {
    ReviewResponseDTO.JoinResultDTO addReview(ReviewRequestDTO.JoinReviewDTO request);
    MyReviewResponseDTO.PagedReviewDTO getMyReviews(Long userId, int page);
}
