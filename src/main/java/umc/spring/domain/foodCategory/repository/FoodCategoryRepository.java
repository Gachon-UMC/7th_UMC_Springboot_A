package umc.spring.domain.foodCategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.foodCategory.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
