package umc.study.domain.foodcategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.foodcategory.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
