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

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private LevelRoutsEnum levelRoutsEnum;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToMany
    private Set<CategoriesEntity> categories;

    public RouteEntity() {
    }
}

//•	gpx coordinates - Accepts very long text values
//•	level - Accepts the levels of the routes (BEGINNER, INTERMEDIATE, ADVANCED) as values
//•	name - Accepts String values
//•	author - Accepts User Entities as values
//•	video url – Accepts the ids of youtube videos as values