package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Market;
import umc.spring.domain.review.Review;
import umc.spring.domain.user.Users;
import umc.spring.web.dto.ReviewRegisterDto;

@Component
public class ReviewConverter {

    public Review toEntity(ReviewRegisterDto dto, Users user, Market market) {
        return Review.builder()
                .user(user)
                .Rating(dto.getRating())
                .content(dto.getContent())
                .build();
    }
}
