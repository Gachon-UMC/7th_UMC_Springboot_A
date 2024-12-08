package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class JoinStoreDto {
        @NotBlank
        String storeName;

        @NotNull
        String description;

        @NotNull
        String category;

        @NotNull
        String address;

        @NotNull
        Integer earnablePoint;

        //@StoreExist  // StoreExist 어노테이션 추가
        Integer storeId;  // 이 필드에 @StoreExist 추가
    }
}
