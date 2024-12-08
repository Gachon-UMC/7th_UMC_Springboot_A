package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import umc.spring.web.dto.ReviewResponseDto;

import java.util.List;

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

    @Transactional(readOnly = true)
    public ReviewResponseDto.ReviewPreViewListDTO getMyReviews(Integer page, Integer size, Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));

        Page<Review> reviewPage = reviewRepository.findByUserId(user.getId(), PageRequest.of(page, size));

        List<ReviewResponseDto.ReviewPreViewDTO> reviewList = reviewPage.getContent().stream()
                .map(review -> new ReviewResponseDto.ReviewPreViewDTO(
                        user.getName(), // 닉네임
                        review.getRating().floatValue(), // 점수
                        review.getContent(), // 본문
                        review.getCreatedAt() // 생성일
                ))
                .toList();

        return ReviewResponseDto.ReviewPreViewListDTO.builder()
                .reviewList(reviewList)
                .listSize(reviewList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}
