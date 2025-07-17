package com.example.SuiteIQ.server_hcm_controller;

import com.example.SuiteIQ.server_hcm_domain.User;
import com.example.SuiteIQ.server_hcm_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
