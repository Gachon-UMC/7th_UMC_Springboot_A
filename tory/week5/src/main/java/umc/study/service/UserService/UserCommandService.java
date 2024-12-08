package umc.study.service.UserService;

import org.springframework.stereotype.Service;
import umc.study.domain.User;
import umc.study.web.dto.UserRequestDTO;

@Service
public interface UserCommandService {

    User joinUser(UserRequestDTO.JoinDto request);

}
