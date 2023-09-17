package com.example.pathfinder2023.service;

import com.example.pathfinder2023.domain.serviceModel.RouteAddServiceModel;
import com.example.pathfinder2023.domain.viewModel.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesViewModel();

    boolean isNameRouteExistMethod(String name);


    void addNewRoute(RouteAddServiceModel routeAddServiceModel);
}
