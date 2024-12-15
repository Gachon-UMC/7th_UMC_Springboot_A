package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.Vaildator.annotation.CheckPage;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.web.controller.dto.MyReviewDTO.MyReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class MyReviewController {

    private final ReviewQueryService reviewService;

    @GetMapping("/{userId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "특정 유저가 작성한 리뷰들의 목록을 페이징 처리하여 반환합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저 ID, path variable 입니다."),
            @Parameter(name = "page", description = "페이징 번호 (1 이상의 정수)")
    })
    public ApiResponse<MyReviewResponseDTO.PagedReviewDTO> getMyReviews(
            @PathVariable Long userId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        MyReviewResponseDTO.PagedReviewDTO response = reviewService.getMyReviews(userId, page - 1); // 1 기반 -> 0 기반 변환
        return ApiResponse.onSuccess(response);
    }
}
