package com.example.pathfinder2023.domain.entity;

import com.example.pathfinder2023.domain.entity.enums.RoleNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class  RoleEntity extends BaseEntity{

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;


    public RoleEntity() {
    }

    public RoleNameEnum getName() {
        return name;
    }

    public RoleEntity setName(RoleNameEnum name) {
        this.name = name;
        return this;
    }
}
