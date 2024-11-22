package umc.study.service.ReviewService;

import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    void addReview(ReviewRequestDTO request);
}
