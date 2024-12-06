package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toEntity(ReviewRequestDTO request, Store store, User user) {
        return Review.builder()
                .content(request.getContent())
                .star(request.getStar())
                .store(store)
                .user(user)
                .build();
    }

    public static ReviewResponseDTO toResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .star(review.getStar())
                .storeName(review.getStore().getName())
                .userName(review.getUser().getName())
                .build();
    }
}

