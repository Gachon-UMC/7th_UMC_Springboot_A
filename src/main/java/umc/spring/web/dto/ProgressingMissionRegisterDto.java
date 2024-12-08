package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.validation.ValidMission;
import umc.spring.validation.ValidProgressingMission;


@Getter
@Setter
@ValidProgressingMission // 커스텀 어노테이션 추가
public class ProgressingMissionRegisterDto {

    @NotNull(message = "사용자 ID는 필수입니다.")
    private Long userId;

    @NotNull(message = "미션 ID는 필수입니다.")
    private Long missionId;
}