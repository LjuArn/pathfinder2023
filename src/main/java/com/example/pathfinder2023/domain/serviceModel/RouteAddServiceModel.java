package com.example.pathfinder2023.domain.serviceModel;

import com.example.pathfinder2023.domain.entity.CategoriesEntity;
import com.example.pathfinder2023.domain.entity.PicturesEntity;
import com.example.pathfinder2023.domain.entity.UserEntity;
import com.example.pathfinder2023.domain.entity.enums.CategoryNameEnum;
import com.example.pathfinder2023.domain.entity.enums.LevelRoutsEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class RouteAddServiceModel {

    private Long id;
    private String description;
    private String gpxCoordinates;
    private LevelRoutsEnum level;
    private String name;
    private String videoUrl;
    private UserEntity author;
    private Set<CategoryNameEnum> categories;
    private Set<PicturesEntity> pictures;

    public RouteAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public RouteAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteAddServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelRoutsEnum getLevel() {
        return level;
    }

    public RouteAddServiceModel setLevel(LevelRoutsEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteAddServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteAddServiceModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }

    public RouteAddServiceModel setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
        return this;
    }

    public Set<PicturesEntity> getPictures() {
        return pictures;
    }

    public RouteAddServiceModel setPictures(Set<PicturesEntity> pictures) {
        this.pictures = pictures;
        return this;
    }
}
