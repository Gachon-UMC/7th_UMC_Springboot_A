package umc.study.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.UserPrefer;

@Repository
public interface PreferFoodCategoryRepository extends JpaRepository<UserPrefer, Integer> {

}