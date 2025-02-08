package com.portfolio.portfoliomgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.portfoliomgr.entity.Users;
import com.portfolio.portfoliomgr.service.UserService;

@RestController
@RequestMapping("/users") // Ensure this matches the URL you're calling
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping // Ensure this is a POST mapping
    public Users createUser(@RequestBody Users users) {
        return userService.createUser(users);
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
