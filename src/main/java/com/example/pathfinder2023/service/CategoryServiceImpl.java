package com.example.pathfinder2023.service;

import com.example.pathfinder2023.domain.entity.CategoriesEntity;
import com.example.pathfinder2023.domain.entity.enums.CategoryNameEnum;
import com.example.pathfinder2023.repository.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoriesEntity findCathegoryByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
