package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.user.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}