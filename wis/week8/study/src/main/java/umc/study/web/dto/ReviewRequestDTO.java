package umc.study.web.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.ValidStore;

@Getter
@Setter
public class ReviewRequestDTO {

    @NotNull(message = "Store ID cannot be null.")
    @ValidStore // 가게 존재 여부 검증
    private Long storeId;

    @NotBlank(message = "Review content cannot be empty.")
    private String content;

    @NotNull(message = "Star rating is required.")

    @DecimalMin(value = "0.0", inclusive = false)

    @DecimalMax(value = "5.0", inclusive = true)

    private Float star;
}
