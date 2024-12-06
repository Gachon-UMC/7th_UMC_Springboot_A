package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Integer point;
    private String storeName;
}
