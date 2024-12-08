package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponseDTO {
    private Long id;
    private String content;
    private Float star;
    private String storeName;
    private String userName;
}

