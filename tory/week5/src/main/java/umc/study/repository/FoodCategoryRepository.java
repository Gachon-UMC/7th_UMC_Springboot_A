package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.UserPrefer;

public interface FoodCategoryRepository extends JpaRepository<UserPrefer, Long> {
}