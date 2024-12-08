package umc.spring.domain.point.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.point.domain.Point;

public interface pointRepository extends JpaRepository<Point, Long> {
}
