package com.example.SpringBootWeb.controller;


import com.example.SpringBootWeb.model.User;
import com.example.SpringBootWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showUsers(ModelMap model) {
        List<User> users;
        users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int userId) {
        userService.deleteUser(userId);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addnewuser";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/editUser")
    public String editUserForm(@RequestParam("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "updateuser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}