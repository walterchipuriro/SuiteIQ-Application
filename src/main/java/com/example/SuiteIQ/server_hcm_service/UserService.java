package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> findByUsername(String username);

}
