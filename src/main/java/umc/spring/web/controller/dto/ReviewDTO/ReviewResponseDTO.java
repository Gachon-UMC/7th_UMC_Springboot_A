package umc.spring.web.controller.dto.ReviewDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JoinResultDTO {
        Long reviewId;
        Long storeId;
        Long userId;
        Integer rating;
        String comment;
        LocalDateTime createdAt;
    }



}
