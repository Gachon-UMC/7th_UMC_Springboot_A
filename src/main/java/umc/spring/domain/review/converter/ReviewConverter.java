package umc.spring.domain.review.converter;

import java.time.LocalDateTime;

import umc.spring.domain.review.domain.Review;
import umc.spring.domain.review.dto.ReviewRequestDto;
import umc.spring.domain.review.dto.ReviewResponseDto;
import umc.spring.domain.store.domain.Store;
import umc.spring.domain.user.domain.User;

public class ReviewConverter {

	public static ReviewResponseDto.addReviewResultDto toReviewResponseDto(Review review) {
		return ReviewResponseDto.addReviewResultDto.builder()
			.reviewId(review.getReviewId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	public static Review toReview(ReviewRequestDto request, Store store, User user) {

		Review review = Review.createReview(user, store, request.getRating(), request.getComment());

		return review;
	}
}
