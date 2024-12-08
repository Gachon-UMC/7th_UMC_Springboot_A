package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.review.Review;
import umc.spring.validation.CheckPage;
import umc.spring.web.dto.ReviewRegisterDto;
import umc.spring.service.ReviewService;
import umc.spring.web.dto.ReviewResponseDto;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDto.ReviewPreViewDTO> registerReview(
            @Valid @RequestBody ReviewRegisterDto dto,
            @RequestParam(name = "userId") Long userId) {
        Review createdReview = reviewService.addReview(dto, userId);

        // 새로운 구조에 맞게 ReviewPreViewDTO를 생성
        ReviewResponseDto.ReviewPreViewDTO responseDto = new ReviewResponseDto.ReviewPreViewDTO(
                createdReview.getUser().getName(), // 닉네임
                createdReview.getRating().floatValue(), // 점수
                createdReview.getContent(), // 본문
                createdReview.getCreatedAt() // 생성일
        );
        return ResponseEntity.ok(responseDto);
    }


    @GetMapping("/my-reviews")
    public ResponseEntity<ReviewResponseDto.ReviewPreViewListDTO> getMyReviews(
            @CheckPage @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "userId") Long userId) {
        ReviewResponseDto.ReviewPreViewListDTO response = reviewService.getMyReviews(page - 1, size, userId);
        return ResponseEntity.ok(response);
    }
}