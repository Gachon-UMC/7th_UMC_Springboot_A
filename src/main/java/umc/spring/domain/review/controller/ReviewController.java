package umc.spring.domain.review.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.review.converter.ReviewConverter;
import umc.spring.domain.review.domain.Review;
import umc.spring.domain.review.dto.ReviewRequestDto;
import umc.spring.domain.review.dto.ReviewResponseDto;
import umc.spring.domain.review.service.ReviewQueryService;
import umc.spring.domain.review.service.ReviewServiceImpl;
import umc.spring.domain.review.validation.annotation.ExistStore;
import umc.spring.global.api.ApiResponse;
import umc.spring.global.api.validation.annotation.CheckPage;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/review")
public class ReviewController {

	private final ReviewServiceImpl reviewService;
	private final ReviewQueryService reviewQueryService;

	@PostMapping("/{storeId}")
	@Operation(summary = "가게에 리뷰 추가", description = "특정 가게에 리뷰를 추가합니다.")
	public ApiResponse<ReviewResponseDto.addReviewResultDto> addReview(
		@RequestBody @Valid ReviewRequestDto request ) {
		Review review = reviewService.addReview(request);
		return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDto(review));
	}

	@GetMapping("/{storeId}/reviews")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "storeId", description = "유저의 아이디, path variable 입니다!")
	})
	@Operation(summary = "가게의 리뷰 조회", description = "특정 가게의 리뷰를 조회합니다.")
	public ApiResponse<ReviewResponseDto.ReviewPreviewListDto> getReviewList(
		@ExistStore @PathVariable(name="storeId") Long storeId,
		@CheckPage @RequestParam(name="page") Integer page){
		int convertedPage = (page > 0) ? page - 1 : 0;
		return ApiResponse.onSuccess(ReviewConverter.reviewPreviewListDto(reviewQueryService.getReviewList(storeId,convertedPage)));
	}

	@GetMapping("/{userId}")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
	})
	@Operation(summary = "가게에 작성한 나의 리뷰 조회", description = "특정 가게에 작성한 나의 리뷰를 조회합니다.")
	public ApiResponse<ReviewResponseDto.ReviewPreviewListDto> getMyReviewList(
		@PathVariable(name="userId") Long userId,
		@CheckPage @RequestParam(name="page") Integer page ) {
		int convertedPage = (page > 0) ? page - 1 : 0;
		return ApiResponse.onSuccess(ReviewConverter.reviewPreviewListDto(reviewQueryService.getMyReviewList(userId,convertedPage)));
	}

}
