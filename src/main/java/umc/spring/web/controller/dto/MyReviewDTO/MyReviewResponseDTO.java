package umc.spring.web.controller.dto.MyReviewDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class MyReviewResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewDTO {
        private Long reviewId;
        private String comment;
        private Integer rating;
        private Long storeId;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PagedReviewDTO {
        private List<ReviewDTO> reviews;
        private int currentPage;
        private int totalPages;
    }
}

