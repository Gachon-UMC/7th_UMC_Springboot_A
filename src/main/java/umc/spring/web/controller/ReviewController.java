package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.review.Review;
import umc.spring.web.dto.ReviewRegisterDto;
import umc.spring.service.ReviewService;
import umc.spring.web.dto.ReviewResponseDto;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> registerReview(
            @Valid @RequestBody ReviewRegisterDto dto,
            @RequestParam(name = "userId") Long userId) {
        Review createdReview = reviewService.addReview(dto, userId);
        ReviewResponseDto responseDto = new ReviewResponseDto(
                createdReview.getId(),
                createdReview.getRating(),
                createdReview.getContent(),
                createdReview.getUser().getId()
        );
        return ResponseEntity.ok(responseDto);
    }


}
