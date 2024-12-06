package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndAddress(String name, String address);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long StoreId, Integer page);
}