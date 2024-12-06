package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public MissionResponseDTO addMission(Long storeId, MissionRequestDTO request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found")); // Replace with custom exception

        MissionStatus missionStatus = request.getDueDate().isAfter(LocalDate.now())
                ? MissionStatus.CHALLENGING
                : MissionStatus.COMPLETE;

        Mission mission = Mission.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .point(request.getPoint())
                .dueDate(request.getDueDate())
                .store(store)
                .status(missionStatus)
                .build();

        mission = missionRepository.save(mission);

        return MissionResponseDTO.builder()
                .id(mission.getId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .point(mission.getPoint())
                .storeName(store.getName())
                .build();
    }

}

