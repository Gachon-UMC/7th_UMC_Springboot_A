package umc.spring.domain.user.service;

import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.dto.UserRequestDTO;

public interface UserCommandService {

	User joinUser(UserRequestDTO.JoinDto request);
}
