package com.example.pathfinder2023.service;

import com.example.pathfinder2023.domain.entity.UserEntity;
import com.example.pathfinder2023.domain.serviceModel.UserServiceModel;
import com.example.pathfinder2023.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

private final UserRepository userRepository;
private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));
    }
}
