package umc.spring.web.controller.dto.StoreDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        Long storeId;
        LocalDateTime createdAt;
        String name;
        String address;
        Integer status;
        String description;
    }

    @Getter
    @Builder
    public static class ReviewPreViewListDTO {
        private List<ReviewDTO> reviews; // 리뷰 목록
        private int currentPage;        // 현재 페이지
        private int totalPages;         // 총 페이지 수
        private long totalReviews;      // 총 리뷰 수
    }

    @Getter
    @Builder
    public static class ReviewDTO {
        private Long reviewId;          // 리뷰 ID
        private String comment;         // 리뷰 내용
        private int rating;             // 평점
        private LocalDateTime createdAt;
    }
}