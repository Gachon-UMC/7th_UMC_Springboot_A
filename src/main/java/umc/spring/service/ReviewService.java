package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Market;
import umc.spring.domain.review.Review;
import umc.spring.domain.user.Users;
import umc.spring.web.dto.ReviewRegisterDto;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MarketRepository marketRepository;
    private final UsersRepository usersRepository;
    private final ReviewConverter reviewConverter;

    @Transactional
    public Review addReview(ReviewRegisterDto dto, Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        Market market = marketRepository.findById(dto.getMarketId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 가게입니다."));
        Review review = reviewConverter.toEntity(dto, user, market);
        return reviewRepository.save(review);
    }
}
