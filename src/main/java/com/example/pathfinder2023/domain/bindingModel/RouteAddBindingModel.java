package com.example.pathfinder2023.domain.bindingModel;

import com.example.pathfinder2023.domain.entity.enums.CategoryNameEnum;
import com.example.pathfinder2023.domain.entity.enums.LevelRoutsEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class RouteAddBindingModel {


    @NotEmpty
    @Size(min = 5, max = 20, message = "Name length must be between 5 and 20 characters")
    private String name;
    @Size(min = 5, message = "Description length must be more than 5")
    private String description;
    //@Size(message = "Must be valid GPX Coordinates")
    private MultipartFile gpxCoordinates;
    @NotNull
    private LevelRoutsEnum level;

    private String videoUrl;

    private Set<CategoryNameEnum> categories;

    public RouteAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public RouteAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteAddBindingModel setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelRoutsEnum getLevel() {
        return level;
    }

    public RouteAddBindingModel setLevel(LevelRoutsEnum level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteAddBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }

    public RouteAddBindingModel setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
        return this;
    }
}
