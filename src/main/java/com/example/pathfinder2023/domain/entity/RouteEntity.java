package com.example.pathfinder2023.domain.entity;

import com.example.pathfinder2023.domain.entity.enums.CategoryNameEnum;
import com.example.pathfinder2023.domain.entity.enums.LevelRoutsEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class RouteEntity extends  BaseEntity{


    //name, description, gpx_coordinates, level, video_url, author_id
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private LevelRoutsEnum level;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<CategoriesEntity> categories;

    public RouteEntity() {
    }

    public String getDescription() {
        return description;
    }

    public RouteEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteEntity setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelRoutsEnum getLevel() {
        return level;
    }

    public RouteEntity setLevel(LevelRoutsEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public Set<CategoriesEntity> getCategories() {
        return categories;
    }

    public RouteEntity setCategories(Set<CategoriesEntity> categories) {
        this.categories = categories;
        return this;
    }
}

//•	gpx coordinates - Accepts very long text values
//•	level - Accepts the levels of the routes (BEGINNER, INTERMEDIATE, ADVANCED) as values
//•	name - Accepts String values
//•	author - Accepts User Entities as values
//•	video url – Accepts the ids of youtube videos as values