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

    public PicturesEntity() {
    }

    public String getTitle() {
        return title;
    }

    public PicturesEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PicturesEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public PicturesEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public PicturesEntity setRoute(RouteEntity route) {
        this.route = route;
        return this;
    }
}
//•	title - Accepts String values
//•	url - Accepts very long String values
//•	author - Accepts User Entities as values
//•	route - Accepts Route Entities as values