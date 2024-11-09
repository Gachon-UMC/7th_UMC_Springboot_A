package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Alarm;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}