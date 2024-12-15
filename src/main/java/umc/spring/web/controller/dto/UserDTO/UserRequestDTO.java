package umc.spring.web.controller.dto.UserDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.Vaildator.annotation.ExistCategories;

import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @Size(min = 5, max = 12)
        String address;
        @ExistCategories
        List<Long> preferCategory;
    }
}
