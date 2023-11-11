package com.example.pathfinder2023.repository;

import com.example.pathfinder2023.domain.entity.CategoriesEntity;
import com.example.pathfinder2023.domain.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, Long> {

    Optional<CategoriesEntity>findByName(CategoryNameEnum categoryNameEnum);
}
