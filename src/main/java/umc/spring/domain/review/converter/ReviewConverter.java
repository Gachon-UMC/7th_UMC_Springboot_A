package umc.spring.domain.review.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

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

	public static ReviewResponseDto.ReviewPreviewDto reviewPreviewDto(Review review) {
		return ReviewResponseDto.ReviewPreviewDto.builder()
			.writerNickname(review.getUser().getNickname())
			.rating(review.getRating())
			.createAt(review.getCreatedAt().toLocalDate())
			.body(review.getComment())
			.build();
	} //리뷰 dto 생성

	public static ReviewResponseDto.ReviewPreviewListDto reviewPreviewListDto(Page<Review> reviewList) {
		List<ReviewResponseDto.ReviewPreviewDto> reviewPreviewDtoList = reviewList.stream()
			.map(ReviewConverter::reviewPreviewDto).collect(Collectors.toList());

		return ReviewResponseDto.ReviewPreviewListDto.builder()
			.isLast(reviewList.isLast())
			.isFirst(reviewList.isFirst())
			.totalPage(reviewList.getTotalPages())
			.totalElements(reviewList.getTotalElements())
			.listSize(reviewPreviewDtoList.size())
			.reviewList(reviewPreviewDtoList)
			.currentPage(reviewList.getNumber())
			.build();
	} //리뷰 리스트 dto
}
