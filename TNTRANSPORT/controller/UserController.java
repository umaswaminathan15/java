package com.example.TNTRANSPORT.controller;

import com.example.TNTRANSPORT.model.User;
import com.example.TNTRANSPORT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String registeruser(@RequestBody User user){
        return  service.registeruser(user);
    }

    @PostMapping("/login")
    public  String loginuser(@RequestBody User user){
        return  service.loginUser(user);
    }
}
