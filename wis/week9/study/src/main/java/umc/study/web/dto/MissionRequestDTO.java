package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
public class MissionRequestDTO {
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Point value is required")
    private Integer point;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

//    @NotNull(message = "Store ID is required")
//    private Long storeId;
}

