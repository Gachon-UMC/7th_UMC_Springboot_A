package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.JoinReviewResultDTO toJoinReviewResultDTO(Review review){
        return ReviewResponseDTO.JoinReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinReviewDto request){
        return Review.builder()
                .userName(request.getUserName())
                .content(request.getContent())
                .starRate(request.getStarRate())
                .build();
    }
}