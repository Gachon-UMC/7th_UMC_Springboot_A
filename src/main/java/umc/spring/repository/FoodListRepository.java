package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.food.FoodList;

public interface FoodListRepository extends JpaRepository<FoodList, Long> {
}