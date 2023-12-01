package umc.study.domain.foodcategory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.foodcategory.repository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {
    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    public boolean existsFoodCategoryById(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
