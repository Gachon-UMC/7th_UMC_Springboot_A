package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.validation.ValidMarket;

@Getter
@Setter
public class ReviewRegisterDto {

    @NotNull(message = "유효한 가게 ID를 입력해주세요.")
    @ValidMarket // 커스텀 어노테이션으로 가게 검증
    private Long marketId;

    @NotNull(message = "평점은 필수입니다.")
    private Integer rating;

    @NotBlank(message = "리뷰 내용은 필수입니다.")
    private String content;
}
