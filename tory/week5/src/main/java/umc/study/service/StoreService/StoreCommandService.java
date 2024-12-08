package umc.study.service.StoreService;

import org.springframework.stereotype.Service;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;

@Service
public interface StoreCommandService {

    Store joinStore(StoreRequestDTO.JoinStoreDto request);

}
