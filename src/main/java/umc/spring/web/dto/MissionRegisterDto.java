package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.validation.ValidMarket;

@Getter
@Setter
public class MissionRegisterDto {

    @NotNull(message = "가게 ID는 필수입니다.")
    @ValidMarket // 가게가 존재하는지 검증하는 커스텀 어노테이션
    private Long marketId;

    @NotBlank(message = "미션 설명은 필수입니다.")
    private String description;

    @NotNull(message = "미션 포인트는 필수입니다.")
    private Integer missionPoint;
}
