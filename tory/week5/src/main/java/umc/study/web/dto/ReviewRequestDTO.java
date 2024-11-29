package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ReviewRequestDTO {

    @Getter
    @Setter
    public static class JoinReviewDto{
        @NotBlank
        String userName;
        @NotNull
        Integer storeId;
        @NotNull
        Integer userId;

        @NotNull
        String content;

        @NotNull
        Double starRate;

    }
}