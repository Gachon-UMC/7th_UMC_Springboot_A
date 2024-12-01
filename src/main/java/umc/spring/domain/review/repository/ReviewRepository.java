package umc.spring.domain.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.review.domain.Review;
import umc.spring.domain.store.domain.Store;
import umc.spring.domain.user.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	Page<Review> findAllByStore(Store store, PageRequest pageRequest);

	Page<Review> findAllByUser(User user, PageRequest pageRequest);
}
