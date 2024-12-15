package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.controller.dto.MyReviewDTO.MyReviewResponseDTO;

import java.util.stream.Collectors;

public class MyReviewConverter {

    public static MyReviewResponseDTO.PagedReviewDTO toPagedReviewDTO(Page<Review> reviewPage) {
        return MyReviewResponseDTO.PagedReviewDTO.builder()
                .reviews(
                        reviewPage.getContent().stream()
                                .map(review -> MyReviewResponseDTO.ReviewDTO.builder()
                                        .reviewId(review.getId())
                                        .comment(review.getComment())
                                        .rating(review.getRating())
                                        .storeId(review.getStore().getId())
                                        .createdAt(review.getCreatedAt())
                                        .build()
                                ).collect(Collectors.toList())
                )
                .currentPage(reviewPage.getNumber() + 1) // 0 기반을 1 기반으로 변환
                .totalPages(reviewPage.getTotalPages())
                .build();
    }
}
