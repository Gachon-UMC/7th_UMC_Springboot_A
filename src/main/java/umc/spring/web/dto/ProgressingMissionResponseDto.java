package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProgressingMissionResponseDto {
    private Long progressingMissionId; // 도전 중인 미션 ID
    private Long userId; // 사용자 ID
    private String userName; // 사용자 이름
    private Long missionId; // 미션 ID
    private String missionDescription; // 미션 설명
    private Integer missionPoint; // 미션 포인트
}
