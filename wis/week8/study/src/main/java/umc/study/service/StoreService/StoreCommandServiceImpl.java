package umc.study.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public StoreResponseDTO addStore(StoreRequestDTO request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RuntimeException("Region not found")); // Replace with custom exception
        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
        store = storeRepository.save(store);

        return StoreResponseDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionName(region.getName())
                .build();
    }
}

