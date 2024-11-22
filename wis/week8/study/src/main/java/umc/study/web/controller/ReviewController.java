package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequestMapping("/stores/{storeId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> addReview(
            @PathVariable Long storeId,
            @RequestBody @Valid ReviewRequestDTO request) {
        ReviewResponseDTO review = reviewCommandService.addReview(storeId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }
}

