package umc.spring.global.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.shared.Gender;
import umc.spring.domain.shared.Role;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);

		// 제공자 구분
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		Map<String, Object> attributes = oAuth2User.getAttributes();

		String email = null;
		String nickname = null;

		if ("google".equals(registrationId)) {
			// Google 사용자 정보 처리
			email = (String)attributes.get("email");
			nickname = (String)attributes.get("name");
		}
		else if("kakao".equals(registrationId)) {
			Map<String, Object> properties = (Map<String, Object>)attributes.get("properties");
			nickname = (String)properties.get("nickname");
			email = nickname + "@kakao.com"; // 임시 이메일 생성
		} else if ("naver".equals(registrationId)) {
			// Naver 사용자 정보 처리
			Map<String, Object> response = (Map<String, Object>)attributes.get("response");
			nickname = (String)response.get("nickname");
			email = (String)response.get("email");

			if (email == null) {
				email = nickname + "@naver.com"; // 이메일이 없을 경우 임시 이메일 생성
			}
		}

		if (email == null) {
			throw new OAuth2AuthenticationException("Email not found from OAuth2 provider");
		}

		User user = saveOrUpdateUser(email, nickname);

		Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
		modifiedAttributes.put("email", email);
		modifiedAttributes.put("nickname", nickname);

		return new DefaultOAuth2User(
			oAuth2User.getAuthorities(),
			modifiedAttributes,
			"email"  // email Principal로 설정
		);
	}
	private User saveOrUpdateUser(String email, String nickname) {
		User user = userRepository.findByEmail(email)
			.orElse(User.builder()
				.email(email)
				.userName(nickname)
				.password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
				.gender(Gender.UNPICKED)  // 기본값 설정
				.address("소셜로그인")  // 기본값 설정
				.extraAddress("소셜로그인")  // 기본값 설정
				.role(Role.USER)
				.build());

		return userRepository.save(user);
	}
}
