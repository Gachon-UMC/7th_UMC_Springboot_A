package umc.spring.web.controller.dto.StoreDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.Vaildator.annotation.ExistStoreStatus;

public class StoreRequestDTO {

    @Getter
    public static class joinStoreDTO{
        @NotNull(message = "가게 이름은 필수 입니다.")
        String name;
        @Size(min = 5, max = 12)
        String address;
        @ExistStoreStatus
        Integer status;
        @Size(max = 255, message = "설명은 최대 255자까지 입력할 수 있습니다.")
        String description;
    }
}
