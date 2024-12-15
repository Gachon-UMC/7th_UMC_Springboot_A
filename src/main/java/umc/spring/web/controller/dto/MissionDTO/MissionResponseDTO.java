package umc.spring.web.controller.dto.MissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JoinResultDTO {
        Long missionId;
        Long storeId;
        String missionTitle;
        String missionDescription;
        Integer points;
        LocalDateTime createdAt;
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionDTO {
        private Long missionId;
        private String title;
        private String description;
        private Integer point;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PagedMissionDTO {
        private List<MissionDTO> missions;
        private int currentPage;
        private int totalPages;
    }
}
