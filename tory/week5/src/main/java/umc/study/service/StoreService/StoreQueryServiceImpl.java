package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }



    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));


        return storePage;
    }
    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> storePage = missionRepository.findAllByStoreId(storeId, PageRequest.of(page, 10));


        return storePage;
    }


}