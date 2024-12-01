package umc.spring.domain.review.dto;

import lombok.Getter;
import umc.spring.domain.review.validation.annotation.ExistStore;

@Getter
public class ReviewRequestDto {
	long userId;
	@ExistStore
	long storeId;
	float rating;
	String comment;
}
