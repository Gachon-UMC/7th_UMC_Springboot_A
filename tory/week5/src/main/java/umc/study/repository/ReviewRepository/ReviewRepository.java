package umc.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByUser(User user, PageRequest pageRequest);



}