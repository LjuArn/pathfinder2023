package com.example.pathfinder2023.service;

import com.example.pathfinder2023.domain.entity.CategoriesEntity;
import com.example.pathfinder2023.domain.entity.enums.CategoryNameEnum;

public interface CategoryService {

    CategoriesEntity findCathegoryByName(CategoryNameEnum categoryNameEnum);
}
