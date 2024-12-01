package umc.spring.domain.review.service;

import org.springframework.data.domain.Page;

import umc.spring.domain.review.domain.Review;

public interface ReviewQueryService {

	Page<Review> getReviewList(Long StoreId, Integer page);

	Page<Review> getMyReviewList(Long userId, Integer page);
}
