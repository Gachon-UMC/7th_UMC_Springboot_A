package umc.spring.domain.user.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;

import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.dto.UserRequestDTO;
import umc.spring.domain.user.dto.UserResponseDto;

public class UserConverter {

	public static UserResponseDto.JoinResultDto toJoinResultDto(User user) {
		return UserResponseDto.JoinResultDto.builder()
			.userId(user.getUserId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	public static User toUser(UserRequestDTO.JoinDto request){

		User user = User.create(request.getName(), request.getGender(), request.getBirthD(),
			request.getBirthM(), request.getBirthY(), request.getAddress(), request.getExtraAddress(),
			request.getRole(), request.getEmail(), request.getPassword());

		user.addPrefer(new ArrayList<>());
		return user;
	}
}
