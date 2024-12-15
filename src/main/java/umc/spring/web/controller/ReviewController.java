package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.ReviewService.ReviewQueryServiceImpl;
import umc.spring.web.controller.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.controller.dto.ReviewDTO.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewQueryServiceImpl reviewQueryService;

    @PostMapping()
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.JoinReviewDTO request){
        return ApiResponse.onSuccess(reviewQueryService.addReview(request));
    }
}
