package umc.spring.service.UserService;

import umc.spring.domain.User;
import umc.spring.web.controller.dto.UserDTO.UserRequestDTO;

public interface UserQueryService {
    User joinUser(UserRequestDTO.JoinDto request);
}
