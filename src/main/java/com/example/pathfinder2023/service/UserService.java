package com.example.pathfinder2023.service;

import com.example.pathfinder2023.domain.serviceModel.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    UserServiceModel findById(long id);

    boolean isNameExistMethod(String username);
}
