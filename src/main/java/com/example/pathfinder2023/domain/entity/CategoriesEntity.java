package com.example.pathfinder2023.domain.entity;

import com.example.pathfinder2023.domain.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity{

    @Column(name = "name", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public CategoriesEntity() {
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public CategoriesEntity setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoriesEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
//•	name - Accepts String values (PEDESTRIAN, BICYCLE, MOTORCYCLE, CAR)
//•	description - Accepts very long String values