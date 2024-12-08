package umc.study.service.ReviewService;

import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

@Service
public interface ReviewCommandService {

    Review joinReview(ReviewRequestDTO.JoinReviewDto request);

}
