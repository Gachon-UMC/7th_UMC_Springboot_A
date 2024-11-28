package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import umc.spring.domain.mission.ProgressStatus;

import java.time.LocalDateTime;
import java.util.List;

public class MarketResponseDto {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionListResponseDto {
        private List<MissionPreviewDto> missionList; // 미션 리스트
        private Integer listSize; // 현재 페이지의 미션 개수
        private Integer totalPage; // 총 페이지 수
        private Long totalElements; // 전체 미션 개수
        private Boolean isFirst; // 첫 번째 페이지 여부
        private Boolean isLast; // 마지막 페이지 여부
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionPreviewDto {
        private String description; // 미션 설명
        private Integer missionPoint; // 미션 포인트
        private LocalDateTime createdAt; // 생성일
    }

}