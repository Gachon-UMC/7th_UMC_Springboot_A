package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
public class MissionRequestDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Integer point;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private Integer status; // 1: CHALLENGING, 2: COMPLETE
}

