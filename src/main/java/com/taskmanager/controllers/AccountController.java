package com.taskmanager.controllers;

import com.taskmanager.models.User;
import com.taskmanager.services.AuthenticationService;
import com.taskmanager.services.modelServices.UsersService;
import com.taskmanager.viewModels.accountVM.AccountLoginVM;
import com.taskmanager.viewModels.accountVM.AccountRegisterVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    UsersService usersService;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:account/login");
    }

    @RequestMapping(value = "account/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("account/login");
    }

    @RequestMapping(value = "account/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("model") @Valid AccountLoginVM model, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("account/login");
        }

        AuthenticationService.setLoggedUser(usersService.getByUsernameAndPassword(model.getUsername(), model.getPassword()));

        if (AuthenticationService.getLoggedUser() == null) {
            result.reject("model", "Invalid username or password.");
            return new ModelAndView("account/login");
        }

        return new ModelAndView("redirect:/tasks/list");
    }

    @RequestMapping(value = "account/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("account/register");
    }

    @RequestMapping(value = "account/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("model") @Valid AccountRegisterVM model, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("account/register");
        }

        if (usersService.ifUserExists(model)) {
            result.reject("model", "Username is already taken.");
            return new ModelAndView("account/register");
        }

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(model, User.class);

        usersService.save(user);
        return new ModelAndView("redirect:login");
    }

    @RequestMapping(value = "account/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        AuthenticationService.logout();
        return new ModelAndView("redirect: login");
    }
}