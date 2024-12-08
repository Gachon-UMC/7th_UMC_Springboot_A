package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ReviewResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        private String ownerNickname;
        private Float score; // 기존 Rating과 연결
        private String body; // 기존 content와 연결
        private LocalDateTime createdAt; // 생성일 추가
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        private List<ReviewPreViewDTO> reviewList; // 리뷰 리스트
        private Integer listSize; // 현재 페이지의 리뷰 개수
        private Integer totalPage; // 총 페이지 수
        private Long totalElements; // 전체 리뷰 개수
        private Boolean isFirst; // 첫 번째 페이지 여부
        private Boolean isLast; // 마지막 페이지 여부
    }
}
