package com.example.pathfinder2023.service;

import com.example.pathfinder2023.domain.entity.RouteEntity;
import com.example.pathfinder2023.domain.serviceModel.RouteAddServiceModel;
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
    private final CategoryService categoryService;


    public RouteServiceImpl(RouteRepository routeRepository,
                            ModelMapper modelMapper,
                            CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;

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

    /*
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
    */
    @Override
    public boolean isNameRouteExistMethod(String name) {
        return routeRepository.findByName(name).isPresent();
    }

    @Override
    public void addNewRoute(RouteAddServiceModel routeAddServiceModel) {

        RouteEntity route = modelMapper.map(routeAddServiceModel, RouteEntity.class);
//        todo: current user
//        route.setAuthor(userService.findCurrentLoginUserEntity());
        route.setCategories(routeAddServiceModel
                .getCategories()
                .stream()
                .map(categoryNameEnum -> categoryService.findCathegoryByName(categoryNameEnum))
                .collect(Collectors.toSet()));
        routeRepository.save(route);
    }

    @Override
    public RouteAddServiceModel findRouteById(Long id) {
        return routeRepository
                .findById(id)
                .map(routeEntity -> modelMapper.map(routeEntity,RouteAddServiceModel.class))
                .orElse(null);
    }


}

//    Route route = modelMapper.map(routeServiceModel, Route.class);
//        //todo: current user
//        //route.setAuthor(userService.findCurrentLoginUserEntity());
//
//        route.setCategories(routeServiceModel
//                .getCategories()
//                .stream()
//                .map(categoryService::findCategoryByName)
//                .collect(Collectors.toList()));
//
//
//        routeRepository.save(route);

