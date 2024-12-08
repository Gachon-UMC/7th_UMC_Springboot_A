package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.web.dto.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ResponseEntity<String> addReview(@Valid @RequestBody ReviewRequestDTO request) {
        reviewCommandService.addReview(request);
        return ResponseEntity.ok("리뷰가 성공적으로 추가되었습니다.");
    }
}
