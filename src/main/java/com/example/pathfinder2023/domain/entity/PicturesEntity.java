package com.example.pathfinder2023.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class PicturesEntity extends BaseEntity{

    @Column
    private String title;
    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteEntity route;


}
//•	title - Accepts String values
//•	url - Accepts very long String values
//•	author - Accepts User Entities as values
//•	route - Accepts Route Entities as values