package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketRegisterDto {

    @NotBlank(message = "가게 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "주소는 필수입니다.")
    private String address;

    @NotBlank(message = "오픈 시간은 필수입니다.")
    private String openTime;

    @NotBlank(message = "닫는 시간은 필수입니다.")
    private String closedTime;

    @NotNull(message = "점수는 필수입니다.")
    private Integer score;
}
