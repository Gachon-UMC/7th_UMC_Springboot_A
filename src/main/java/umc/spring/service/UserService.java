package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.user.Users;
import umc.spring.dto.UserRegisterDto;
import umc.spring.repository.UsersRepository;
import umc.spring.converter.UsersConverter;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    @Transactional
    public Users createUser(UserRegisterDto request) {
        Users user = usersConverter.toEntity(request);
        return usersRepository.save(user);
    }
}
