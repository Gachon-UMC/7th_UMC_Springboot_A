package umc.spring.global.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username)
			.orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 가진 유저가 존재하지 않습니다: " + username));

		return org.springframework.security.core.userdetails.User
			.withUsername(user.getEmail())
			.password(user.getPassword())
			.roles(user.getRole().name())
			.build();
	}
}
