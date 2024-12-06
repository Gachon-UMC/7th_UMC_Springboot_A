package umc.study.Config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //Spring Security 설정을 활성화
@Configuration
public class SecurityConfig { // 보안 설정을 위해 Spring Security가 Filter Chain을 사용하여 들어오는 HTTP 요청을 필터링하고 인증 또는 인가 로직을 처리할 때, 필터 체인과 보안 정책을 설정하는 역할

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { //SecurityFilterChain 정의 -> HttpSecurity 객체를 통해 다양한 보안 설정을 구성
        http
                .authorizeHttpRequests((requests) -> requests // HTTP 요청에 대한 접근 제어를 설정
                        .requestMatchers("/", "/home", "/signup", "/users/signup","/css/**").permitAll() //.requestMatchers(): 특정 URL 패턴에 대한 접근 권한 설정 / permitAll(): 인증 없이 접근 가능한 경로를 지정
                        .requestMatchers("/admin/**").hasRole("ADMIN") //hasRole("ADMIN"): 'ADMIN' 역할을 가진 사용자만 접근 가능하도록 제한
                        .anyRequest().authenticated() //그 외 모든 요청에 대해 인증을 요구
                )
                .formLogin((form) -> form //폼 기반 로그인에 대한 설정
                        .loginPage("/login") //커스텀 로그인 페이지를 /login 경로로 지정
                        .defaultSuccessUrl("/home", true) //로그인 성공 시 /home으로 리다이렉트
                        .permitAll() //로그인 페이지는 모든 사용자가 접근 가능하도록 설정
                )
                .logout((logout) -> logout //로그아웃 처리에 대한 설정
                        .logoutUrl("/logout") ///logout 경로로 로그아웃을 처리
                        .logoutSuccessUrl("/login?logout") //로그아웃 성공 시 /login?logout으로 리다이렉트
                        .permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                );;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //비밀번호를 암호화하여 저장하기 위해 BCryptPasswordEncoder를 사용
        return new BCryptPasswordEncoder();
    }
}

/*
@EnableWebSecurity // 설정을 활성화
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //요청에 대한 접근 제어
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/home")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/signup")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                        .anyRequest().authenticated()

                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        //로그인 성공 시 리다이렉트로 합니다.
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/