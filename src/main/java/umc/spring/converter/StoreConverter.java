package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.domain.emums.StoreStatus;
import umc.spring.web.controller.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.controller.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO ToStoreDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .name(store.getName())
                .address(store.getAddress())
                .status(store.getStatus().ordinal())
                .description(store.getDescription())
                .build();
    }
    public static Store ToStore(StoreRequestDTO.joinStoreDTO request) {
        StoreStatus status = null;

        switch (request.getStatus()){
            case 1:
                status = StoreStatus.OPEN;
                break;
            case 2:
                status = StoreStatus.CLOSED;
                break;
        }

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .description(request.getDescription())
                .status(status)
                .build();
    }
}
