package com.example.pathfinder2023.service;

import com.example.pathfinder2023.domain.entity.RouteEntity;
import com.example.pathfinder2023.domain.viewModel.RouteViewModel;
import com.example.pathfinder2023.repository.RouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {


    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteViewModel> findAllRoutesViewModel() {
        return routeRepository
                .findAll()
                .stream()
                .map(routeEntity -> {
                    RouteViewModel routeViewModel = modelMapper.map(routeEntity, RouteViewModel.class);

                    if (routeEntity.getPictures().isEmpty()) {
                        routeViewModel.setPicture("/imiges/pic1.jpg");
                    } else {
                        routeViewModel.setPicture(routeEntity.getPictures().stream().findFirst().get().getUrl());
                    }

                    return routeViewModel;
                })
                .collect(Collectors.toList());

    }

    @Override
    public boolean isNameRouteExistMethod(String name) {
        return routeRepository.findByName(name).isPresent();
    }
}


