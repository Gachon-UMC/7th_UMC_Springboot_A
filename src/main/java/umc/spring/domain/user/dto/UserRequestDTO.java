package umc.spring.domain.user.dto;

import java.util.List;

import lombok.Getter;
import umc.spring.domain.foodCategory.validation.annotation.ExistCategories;
import umc.spring.domain.shared.Gender;

@Getter
public class UserRequestDTO {

	@Getter
	public static class JoinDto{
		String name;
		Gender gender;
		int birthD;
		int birthM;
		int birthY;
		String address;
		String extraAddress;
		@ExistCategories
		List<Long> preferCategory;
	}
}
