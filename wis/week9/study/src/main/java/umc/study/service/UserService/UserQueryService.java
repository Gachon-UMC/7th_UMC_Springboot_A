package umc.study.service.UserService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;

public interface UserQueryService {

    Page<Review> getReviewList(Long UserId, Integer page);
}
