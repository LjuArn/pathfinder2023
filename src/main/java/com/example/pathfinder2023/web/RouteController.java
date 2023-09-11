package com.example.pathfinder2023.web;


import com.example.pathfinder2023.domain.bindingModel.RouteAddBindingModel;
import com.example.pathfinder2023.domain.viewModel.RouteViewModel;
import com.example.pathfinder2023.service.RouteService;
import com.example.pathfinder2023.unit.CurrentUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;

    public RouteController(RouteService routeService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.currentUser = currentUser;
    }


    @GetMapping("/all")
    public String allRoutes(Model model) {

        List<RouteViewModel> routeViewModels =
                routeService.findAllRoutesViewModel();

        model.addAttribute("routes", routeViewModels);

        return "routes";
    }


    @GetMapping("/add")
    public String addRoute(Model model) {

   //     if(currentUser.getId()==null) {
   //     return "redirect:/users/login";
   //     }

        if (!model.containsAttribute("routeAddBindingModel")) {
            model.addAttribute("routeAddBindingModel", new RouteAddBindingModel());
        }
        return "add-route";
    }


    @PostMapping("/add")
    public String addConfurm(@Valid RouteAddBindingModel routeAddBindingModelel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("routeAddBindingModelel", routeAddBindingModelel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModelel",
                            bindingResult);
            return "redirect:add-route";

        }


        boolean isNameRouteExist = routeService.isNameRouteExistMethod(routeAddBindingModelel.getName());

        if (isNameRouteExist) {
            redirectAttributes
                    .addFlashAttribute("isNameRouteExist", true)
                    .addFlashAttribute("routeAddBindingModelel", routeAddBindingModelel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModelel",
                            bindingResult);
            return "redirect:add-route";
        }






        return "redirect:all";
    }


}