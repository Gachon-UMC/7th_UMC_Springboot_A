package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.web.controller.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.controller.dto.ReviewDTO.ReviewResponseDTO;
import umc.spring.web.controller.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDateTime;

import static umc.spring.domain.QStore.store;
import static umc.spring.domain.QUser.user;

public class ReviewConverter {

    public static ReviewResponseDTO.JoinResultDTO ToReviewDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .userId(review.getUser().getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Review ToReview(ReviewRequestDTO.JoinReviewDTO request, User user, Store store) {

        return Review.builder()
                .user(user)
                .store(store)
                .rating(request.getRating())
                .comment(request.getComment())
                .build();

    }



        public static StoreResponseDTO.ReviewDTO toReviewPageDTO(Review review) {
            return StoreResponseDTO.ReviewDTO.builder()
                    .reviewId(review.getId())
                    .comment(review.getComment())
                    .rating(review.getRating())
                    .createdAt(review.getCreatedAt())
                    .build();
        }


}
