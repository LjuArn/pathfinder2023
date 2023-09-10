package com.example.pathfinder2023.domain.viewModel;

import com.example.pathfinder2023.domain.entity.enums.LevelUserEnum;
import com.example.pathfinder2023.domain.entity.enums.RoleNameEnum;

public class UserModel {

    private Long id;
    private LevelUserEnum level;
    private String fullName;
    private String username;
    private Integer age;

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public LevelUserEnum getLevel() {
        return level;
    }

    public UserModel setLevel(LevelUserEnum level) {
        this.level = level;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserModel setAge(Integer age) {
        this.age = age;
        return this;
    }
}
