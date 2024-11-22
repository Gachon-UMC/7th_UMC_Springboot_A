package umc.study.web.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDTO {
    @NotBlank(message = "Review content cannot be empty")
    private String content;

    @NotNull(message = "Star rating is required")

    @DecimalMin(value = "0.0", inclusive = false)

    @DecimalMax(value = "5.0", inclusive = true)

    private Float star;
}
