package com.example.pathfinder2023.domain.bindingModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    @Size(min = 4, message = "Username length must be more than 2 characters")
    private String username;
    @Size(min = 3, message = "Full name length must be more than 3 characters")
    private String fullName;
    @Email(message = "Must be valid email")
    private String email;
    @Positive(message = "Must be valid age")
    private Integer age;
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters")
    private String password;
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
