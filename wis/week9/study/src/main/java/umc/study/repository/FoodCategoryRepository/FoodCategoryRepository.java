package umc.study.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Food;

public interface FoodCategoryRepository extends JpaRepository<Food, Long> {

}
