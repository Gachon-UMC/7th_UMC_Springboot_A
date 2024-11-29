package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.ReviewRequestDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinReviewDto request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid userId: " + request.getUserId()));
        Store store = storeRepository.findById(Long.valueOf(request.getStoreId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid storeId: " + request.getStoreId()));



        Review newReview = ReviewConverter.toReview(request,user,store);
        newReview.setUser(user);
        newReview.setStore(store);

        newReview.setCreatedAt(LocalDateTime.now());
        newReview.setUpdatedAt(LocalDateTime.now());

        return reviewRepository.save(newReview);
    }
}