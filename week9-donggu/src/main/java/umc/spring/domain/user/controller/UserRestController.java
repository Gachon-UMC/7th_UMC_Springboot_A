package umc.spring.domain.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.review.dto.ReviewResponseDto;
import umc.spring.domain.user.converter.UserConverter;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.service.UserCommandService;
import umc.spring.global.api.ApiResponse;
import umc.spring.domain.user.dto.UserRequestDTO;
import umc.spring.domain.user.dto.UserResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

	private final UserCommandService userCommandService;

	@PostMapping("/")
	@Operation(summary = "회원가입", description = "회원을 등록합니다.")
	public ApiResponse<UserResponseDto.JoinResultDto> join(
		@RequestBody @Valid UserRequestDTO.JoinDto request) {
		User user = userCommandService.joinUser(request);
		return ApiResponse.onSuccess(UserConverter.toJoinResultDto(user));
	}
}
