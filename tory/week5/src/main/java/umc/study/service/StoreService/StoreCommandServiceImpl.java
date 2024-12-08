package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Validated
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinStoreDto request) {
        Store newStore = StoreConverter.toStore(request);
        newStore.setCreatedAt(LocalDateTime.now());
        newStore.setUpdatedAt(LocalDateTime.now());
        newStore.setStarRate(4.5);

        return storeRepository.save(newStore);
    }

    public Store findById(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
    }
}
