package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private Integer rating;
    private String content;
    private Long userId; // 필요한 경우
}
