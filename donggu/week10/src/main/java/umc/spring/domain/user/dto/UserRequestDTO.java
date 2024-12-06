package umc.spring.domain.user.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.foodCategory.validation.annotation.ExistCategories;
import umc.spring.domain.shared.Gender;
import umc.spring.domain.shared.Role;

@Getter
public class UserRequestDTO {

	@Getter
	@Setter
	public static class JoinDto{
		@NotBlank
		String name;
		@NotNull
		Gender gender;
		@NotBlank
		@Email
		String email;
		@NotBlank
		String password;
		@NotNull
		int birthD;
		@NotNull
		int birthM;
		@NotNull
		int birthY;
		@Size(min = 5, max = 12)
		String address;
		@Size(min = 5, max = 12)
		String extraAddress;
		@ExistCategories
		List<Long> preferCategory;
		@NotNull
		Role role;
	}
}
