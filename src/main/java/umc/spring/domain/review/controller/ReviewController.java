package umc.spring.domain.review.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.review.converter.ReviewConverter;
import umc.spring.domain.review.domain.Review;
import umc.spring.domain.review.dto.ReviewRequestDto;
import umc.spring.domain.review.dto.ReviewResponseDto;
import umc.spring.domain.review.service.ReviewServiceImpl;
import umc.spring.global.api.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

	private final ReviewServiceImpl reviewService;

	@PostMapping("/{storeId}")
	@Operation(summary = "가게에 리뷰 추가", description = "특정 가게에 리뷰를 추가합니다.")
	public ApiResponse<ReviewResponseDto.addReviewResultDto> addReview(
		@RequestBody @Valid ReviewRequestDto request ) {
		Review review = reviewService.addReview(request);
		return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDto(review));
	}
}
