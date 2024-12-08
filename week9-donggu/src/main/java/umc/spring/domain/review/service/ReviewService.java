package umc.spring.domain.review.service;

import umc.spring.domain.review.domain.Review;
import umc.spring.domain.review.dto.ReviewRequestDto;

public interface ReviewService {

	Review addReview(ReviewRequestDto reviewRequestDto);
}
