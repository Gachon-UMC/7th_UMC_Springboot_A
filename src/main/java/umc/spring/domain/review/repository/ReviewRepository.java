package umc.spring.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
