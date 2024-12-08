package umc.spring.domain.review.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.review.domain.Review;
import umc.spring.domain.review.repository.ReviewRepository;
import umc.spring.domain.store.Repository.StoreRepository;
import umc.spring.domain.store.domain.Store;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

	private final StoreRepository storeRepository;
	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;
	@Override
	public Page<Review> getReviewList(Long StoreId, Integer page) {

		Store store = storeRepository.findById(StoreId).get();

		Page<Review> ReviewPage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
		return ReviewPage;
	}

	@Override
	public Page<Review> getMyReviewList(Long userId, Integer page) {
		User user = userRepository.findById(userId).get();

		Page<Review> ReviewPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
		return ReviewPage;
	}
}
