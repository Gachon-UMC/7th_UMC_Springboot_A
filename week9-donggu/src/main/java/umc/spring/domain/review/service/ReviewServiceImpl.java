package umc.spring.domain.review.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.review.converter.ReviewConverter;
import umc.spring.domain.review.domain.Review;
import umc.spring.domain.review.dto.ReviewRequestDto;
import umc.spring.domain.review.repository.ReviewRepository;
import umc.spring.domain.store.Repository.StoreRepository;
import umc.spring.domain.store.domain.Store;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.repository.UserRepository;
import umc.spring.global.api.code.status.ErrorStatus;
import umc.spring.global.api.exception.handler.StoreHandler;
import umc.spring.global.api.exception.handler.UserHandler;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final StoreRepository storeRepository;
	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;

	//리뷰 추가
	@Override
	public Review addReview(ReviewRequestDto request) {

		Store store = storeRepository.findById(request.getStoreId())
			.orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
		Review review = ReviewConverter.toReview(request, store, user);

		store.addReview(review);
		return reviewRepository.save(review);
	}
}
