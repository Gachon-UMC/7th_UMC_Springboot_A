package umc.spring.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
