package com.example.pathfinder2023.web;

import com.example.pathfinder2023.domain.bindingModel.UserRegisterBindingModel;
import com.example.pathfinder2023.domain.serviceModel.UserServiceModel;
import com.example.pathfinder2023.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }


    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",
                            bindingResult);
            return "redirect:register";
        }


        //    boolean isNameExist = userService.isNameExistMethod(userRegisterBindingModel.getUsername());

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));


        return "redirect:login";
    }


//___________________________________________________________


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    //_______________________________


}
