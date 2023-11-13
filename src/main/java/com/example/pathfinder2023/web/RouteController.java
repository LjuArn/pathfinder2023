package com.example.pathfinder2023.web;


import com.example.pathfinder2023.domain.bindingModel.RouteAddBindingModel;
import com.example.pathfinder2023.domain.serviceModel.RouteAddServiceModel;
import com.example.pathfinder2023.domain.viewModel.RouteViewModel;
import com.example.pathfinder2023.service.RouteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService,
                           ModelMapper modelMapper) {
        this.routeService = routeService;
        this.modelMapper = modelMapper;
    }


//    @GetMapping("/all")
//    public String allRoutes(Model model) {
//
//        List<RouteViewModel> routeViewModels =
//                routeService.findAllRoutesViewModel();
//
//        model.addAttribute("routes", routeViewModels);
//
//        return "routes";
//    }


    @GetMapping("/all")
    public String allRoutes(Model model) {

        model.addAttribute("routes", routeService.findAllRoutesViewModel());
        return "routes";
    }

    @GetMapping("/add")
    public String addRoute(Model model) {
        if (!model.containsAttribute("routeAddBindingModel")) {
            model.addAttribute("routeAddBindingModel", new RouteAddBindingModel());
        }
        return "add-route";
    }


    @PostMapping("/add")
    public String addConfurm(@Valid RouteAddBindingModel routeAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("routeAddBindingModel", routeAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel",
                            bindingResult);
            return "redirect:add";

        }


//        boolean isNameRouteExist = routeService.isNameRouteExistMethod(routeAddBindingModel.getName());
//
//        if (isNameRouteExist) {
//            redirectAttributes
//                    .addFlashAttribute("isNameRouteExist", true)
//                    .addFlashAttribute("routeAddBindingModel", routeAddBindingModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel",
//                            bindingResult);
//            return "redirect:add";
//        }


        RouteAddServiceModel routeAddServiceModel = modelMapper.map(routeAddBindingModel, RouteAddServiceModel.class);
        routeAddServiceModel.setGpxCoordinates(new String(routeAddBindingModel.getGpxCoordinates().getBytes()));

         routeService.addNewRoute(routeAddServiceModel);
        return "redirect:all";
    }



    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {


        model.addAttribute("route", routeService.findRouteById(id));
        model.addAttribute("authorName", routeService.findRouteById(id).getAuthor().getUsername());

        return "route-details";
    }
}